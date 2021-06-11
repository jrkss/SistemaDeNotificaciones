package com.mendez.windows;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    ImageView img;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        img.animate().alpha(7000).setDuration(0);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
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

                }else{
                    Intent dsp = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(dsp);
                    finish();
                }

            }
        }, 3500);
    }
}