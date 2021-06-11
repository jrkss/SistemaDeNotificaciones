package com.mendez.windows.Alumno.Perfil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mendez.windows.R;


public class PerfilActivity extends AppCompatActivity {
    private TextView txtnombre;
    private TextView txtmatricula;
    private TextView txtcampus;
    private TextView txtingenieria;
    private TextView txtcorreo;
    private TextView txtsemestre;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtnombre = findViewById(R.id.nombreUser);
        txtmatricula = findViewById(R.id.matriculaUser);
        txtingenieria = findViewById(R.id.ingenieriaUser);
        txtcampus = findViewById(R.id.campusUser);
        txtcorreo = findViewById(R.id.correoUser);
        txtsemestre = findViewById(R.id.semestreUser);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        ////////////////////////////////////////////////////////////////////////////////////////////
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        String userID = currentFirebaseUser.getUid();
        mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nm = snapshot.child("nombre").getValue(String.class);
                    String mt = snapshot.child("matricula").getValue(String.class);
                    String cp = snapshot.child("campus").getValue(String.class);
                    String in = snapshot.child("ingenieria").getValue(String.class);
                    String cr = snapshot.child("correo").getValue(String.class);
                    String se = snapshot.child("semestre").getValue(String.class);
                    txtnombre.setText(nm);
                    txtmatricula.setText(mt);
                    txtcampus.setText(cp);
                    txtingenieria.setText(in);
                    txtcorreo.setText(cr);
                    txtsemestre.setText(se);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}