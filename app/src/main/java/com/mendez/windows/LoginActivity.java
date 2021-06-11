package com.mendez.windows;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mendez.windows.Administrativo.PrincipalAdministrativo;
import com.mendez.windows.Alumno.Principal;
import com.mendez.windows.Docente.PrincipalDocente;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextCorreo;
    private EditText editTextPasswor;

    private Button btnI;

    private String Correo;
    private String Pass;

    private DatabaseReference mDatabase;
    private String nuevoDato;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextCorreo=findViewById(R.id.edtCorreo);
        editTextPasswor=findViewById(R.id.edtConta);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnI = findViewById(R.id.et_Inicio);

        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Correo = editTextCorreo.getText().toString();
                Pass = editTextPasswor.getText().toString();
                if (!Correo.isEmpty() && !Pass.isEmpty()){
                    singIn();
                }else {
                    Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
///Inicio de sesion
    private void singIn() {
        mAuth.signInWithEmailAndPassword(Correo, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
                    String userID = currentFirebaseUser.getUid();
                    mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                String rol = snapshot.child("iduser").getValue(String.class);

                                if (rol.equals("Alumno")){
                                    Intent i = new Intent(getApplicationContext(), Principal.class);
                                    startActivity(i);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Alumno encontrado", Toast.LENGTH_SHORT).show();
                                }else if (rol.equals("Administrativo")){
                                    Intent i = new Intent(getApplicationContext(), PrincipalAdministrativo.class);
                                    startActivity(i);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Administrativo", Toast.LENGTH_SHORT).show();

                                }else if (rol.equals("Docente")){
                                    Intent i = new Intent(getApplicationContext(), PrincipalDocente.class);
                                    startActivity(i);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Docente", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Usuario no registrado", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "UID No encontrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void onStart(){
        super.onStart();
/*
        if (mAuth.getCurrentUser() !=null){
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
            String userID = currentFirebaseUser.getUid();
            mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String rol = snapshot.child("iduser").getValue(String.class);
                        if (rol.equals("Alumno")){
                            Intent i = new Intent(getApplicationContext(), Principal.class);
                            startActivity(i);
                            finish();

                        }else if (rol.equals("Administrativo")){
                            Intent i = new Intent(getApplicationContext(), PrincipalAdministrativo.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(getApplicationContext(), "Administrativo", Toast.LENGTH_SHORT).show();
                        }else if (rol.equals("Docente")) {
                            Intent i = new Intent(getApplicationContext(), PrincipalDocente.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(getApplicationContext(), "Docente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
*/
    }

}