package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTequila;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTehuipango.TehuipangoDesarrollo;
import com.mendez.windows.Administrativo.ModeloA.MensajeEnviar;
import com.mendez.windows.Administrativo.ModeloA.MensajeRecibir;
import com.mendez.windows.Administrativo.controller.AdapterMensajes;
import com.mendez.windows.LoginActivity;
import com.mendez.windows.R;

public class TequilaSistemas extends AppCompatActivity {
    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private ImageButton btnEnviar;
    private AdapterMensajes adapter;
    private ImageButton btnEnviarFile;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private static final int PHOTO_SEND = 1;
    private static final int DOC_SEND = 2342;


    private FirebaseAuth mAuth;
    private String NOMBRE_USUARIO;
    ////////////////////////////
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tequila_sistemas);
        rvMensajes = (RecyclerView) findViewById(R.id.recycler);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        btnEnviar = (ImageButton) findViewById(R.id.btnEnviar);
        btnEnviarFile = (ImageButton) findViewById(R.id.btnEnviarDoc);
        /////////////////////////////////////////
        mDatabase = FirebaseDatabase.getInstance().getReference();


        /////////////////////Recibir datos////////////////////////////
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("TequilaSistemas");//Sala de chat (nombre) version 2
        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        adapter = new AdapterMensajes(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapter);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = txtMensaje.getText().toString();
                if (!mensaje.isEmpty()){
                    databaseReference.push().setValue(new MensajeEnviar(txtMensaje.getText().toString(), NOMBRE_USUARIO, "1", ServerValue.TIMESTAMP));
                    txtMensaje.setText("");
                }else {
                    Toast.makeText(TequilaSistemas.this, "Escriba un mensaje...", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnEnviarFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TequilaSistemas.this);
                builder.setTitle("Adjuntar: ");

                String[] opciones = {"Imagen", "Documento"};
                builder.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case 0:
                                Intent imagen = new Intent(Intent.ACTION_GET_CONTENT);
                                imagen.setType("image/*");
                                imagen.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                                startActivityForResult(Intent.createChooser(imagen, "Selecciona una foto"), PHOTO_SEND);
                                break;

                            case 1:
                                Intent pdf = new Intent(Intent.ACTION_GET_CONTENT);
                                pdf.setType("application/*");
                                pdf.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                                startActivityForResult(Intent.createChooser(pdf, "Seleccione un archivo PDF"), DOC_SEND);
                                break;
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MensajeRecibir m = dataSnapshot.getValue(MensajeRecibir.class);
                adapter.addMensaje(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        verifyStoragePermissions(this);
    }
    private void setScrollbar() {
        rvMensajes.scrollToPosition(adapter.getItemCount() - 1);
    }

    public static boolean verifyStoragePermissions(Activity activity) {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int REQUEST_EXTERNAL_STORAGE = 1;
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_SEND && resultCode == RESULT_OK) {
            Uri u = data.getData();
            storageReference = storage.getReference("imagenes_tequila_sistemas");//imagenes_chat
            final StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());
            fotoReferencia.putFile(u).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()){
                        throw  task.getException();
                    }
                    return fotoReferencia.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()){
                        Uri uri = task.getResult();
                        MensajeEnviar m = new MensajeEnviar("", uri.toString(), NOMBRE_USUARIO, "2", ServerValue.TIMESTAMP);
                        databaseReference.push().setValue(m);
                    }
                }
            });

        }if (requestCode == DOC_SEND && resultCode == RESULT_OK){
            Uri u = data.getData();
            storageReference = storage.getReference("Documentos_tequila_sistemas");
            final StorageReference docReferencia = storageReference.child(u.getLastPathSegment());
            docReferencia.putFile(u).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()){
                        throw task.getException();
                    }
                    return docReferencia.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()){
                        Uri uri= task.getResult();
                        MensajeEnviar m = new MensajeEnviar("",uri.toString(),"", NOMBRE_USUARIO, "3", ServerValue.TIMESTAMP);
                        databaseReference.push().setValue(m);
                    }
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            btnEnviar.setEnabled(false);
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
            String userID = currentFirebaseUser.getUid();
            mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String nombre = snapshot.child("nombre").getValue(String.class);
                        NOMBRE_USUARIO = nombre;
                        btnEnviar.setEnabled(true);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        } else {
            returnLogin();
        }
    }

    private void returnLogin() {
        startActivity(new Intent(TequilaSistemas.this, LoginActivity.class));
        finish();
    }
}