package com.mendez.windows.Administrativo.Perfil;

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

public class PerfilAdminActivity extends AppCompatActivity {
    private TextView txtnombre;
    private TextView txtcargo;
    private TextView txtcampus;
    private TextView txttelefono;
    private TextView txtcorreo;
    private TextView txtrol;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_admin);


        txtnombre = findViewById(R.id.nombreadminid);
        txtcargo = findViewById(R.id.cargoadminid);
        txttelefono = findViewById(R.id.telefonoadminid);
        txtcampus = findViewById(R.id.campusadminid);
        txtcorreo = findViewById(R.id.correoadminid);
        txtrol = findViewById(R.id.roladminid);
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
                    String mt = snapshot.child("cargo").getValue(String.class);
                    String cp = snapshot.child("campus").getValue(String.class);
                    String in = snapshot.child("telefono").getValue(String.class);
                    String cr = snapshot.child("correo").getValue(String.class);
                    String se = snapshot.child("iduser").getValue(String.class);
                    txtnombre.setText(nm);
                    txtcargo.setText(mt);
                    txtcampus.setText(cp);
                    txttelefono.setText(in);
                    txtcorreo.setText(cr);
                    txtrol.setText(se);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}