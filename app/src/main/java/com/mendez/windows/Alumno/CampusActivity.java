package com.mendez.windows.Alumno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mendez.windows.Alumno.Controller.AdapterMensajesA;
import com.mendez.windows.Alumno.ModeloA.MensajeRecibirA;
import com.mendez.windows.LoginActivity;
import com.mendez.windows.R;

public class CampusActivity extends AppCompatActivity {
    private BottomNavigationView bottonNavITSZ;
/////////////Referencias/////////////////

    private TextView nombre;
    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private Button btnEnviar;
    private AdapterMensajesA adapter;
    private ImageButton btnEnviarFoto;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private static final int PHOTO_SEND = 1;

    private FirebaseAuth mAuth;
    private String NOMBRE_USUARIO;
    private String  CAMPUSNAME;
    ////////////////////////////
    private DatabaseReference mDatabase;
    private DatabaseReference mDataba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);
        ///////////////////////Ref///////////////////////////
        rvMensajes = (RecyclerView) findViewById(R.id.recycler);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);

        //////////////////////////////////////////////
        adapter = new AdapterMensajesA(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapter);

        ///////////////////////////////////////////////////////////////////////////////////////////
        mDatabase = FirebaseDatabase.getInstance().getReference();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        String userID = currentFirebaseUser.getUid();
        mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String campus = snapshot.child("campus").getValue(String.class);
                    if (campus.equals("Zongolica")){
                         CAMPUSNAME = "Zongolicams";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else if (campus.equals("Nogales")){
                        CAMPUSNAME = "Nogalesms";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else if (campus.equals("Tezonapa")){
                        CAMPUSNAME = "Tezonapams";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else if (campus.equals("Tequila")){
                        CAMPUSNAME = "Tequilams";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else if (campus.equals("Tehuipango")){
                        CAMPUSNAME = "Tehuipangoms";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else if (campus.equals("Cuichapa")){
                        CAMPUSNAME = "Cuichapams";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else if (campus.equals("Aculzinapa")){
                        CAMPUSNAME = "Aculzinapams";
                        databaseReference = database.getReference(CAMPUSNAME);//Sala de chat (nombre) version 2
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                MensajeRecibirA mm = dataSnapshot.getValue(MensajeRecibirA.class);
                                adapter.addMensaje(mm);
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
                    }else{
                        Toast.makeText(CampusActivity.this, "No se ha encontrado su campus", Toast.LENGTH_SHORT).show();

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /////////////////////Recibir datos////////////////////////////

        bottonNavITSZ = findViewById(R.id.BottomBav);
        bottonNavITSZ.setSelectedItemId(R.id.campusid);
        bottonNavITSZ.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.campusid:
                        return true;

                    case R.id.campusCaid:
                        startActivity(new Intent(getApplicationContext(), CCarreraActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.carrerazid:
                        startActivity(new Intent(getApplicationContext(), CarreraActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.itszid:
                        startActivity(new Intent(getApplicationContext(), Principal.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menuid:
                        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
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
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
            String userID = currentFirebaseUser.getUid();
            mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String nombre = snapshot.child("nombre").getValue(String.class);
                        NOMBRE_USUARIO = nombre;
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
        startActivity(new Intent(CampusActivity.this, LoginActivity.class));
        finish();
    }

}