package com.mendez.windows.Administrativo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mendez.windows.Administrativo.Contacts.Contacts;
import com.mendez.windows.Administrativo.Grupos.SelectGrupo;
import com.mendez.windows.Administrativo.Perfil.PerfilAdminActivity;
import com.mendez.windows.Alumno.CCarreraActivity;
import com.mendez.windows.Alumno.CampusActivity;
import com.mendez.windows.Alumno.Perfil.PerfilActivity;
import com.mendez.windows.Alumno.Principal;
import com.mendez.windows.LoginActivity;
import com.mendez.windows.R;

public class MenuAdminActivity extends AppCompatActivity {
    private TextView txtnombre, txtcontats, txtGruposid;
    private Button btnSalir;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private BottomNavigationView bottonNavITSZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        btnSalir = findViewById(R.id.btnClose);

        txtGruposid = findViewById(R.id.gruposid);
        txtnombre = findViewById(R.id.nombreUser);
        txtcontats = findViewById(R.id.nombrecontacts);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        bottonNavITSZ = findViewById(R.id.BottomBav);

        ////////////////////////////////////////////////////////////////////////////////////////////
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        String userID = currentFirebaseUser.getUid();
        mDatabase.child("Usuario").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nm = snapshot.child("nombre").getValue(String.class);
                    txtnombre.setText(nm);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        bottonNavITSZ.setSelectedItemId(R.id.menuid);
        bottonNavITSZ.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.campusid:
                        startActivity(new Intent(getApplicationContext(), CampusAdminActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.campusCaid:
                        startActivity(new Intent(getApplicationContext(), CCarreraAdminActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.carrerazid:
                        startActivity(new Intent(getApplicationContext(), CarreraAdminActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuid:
                        return true;

                    case R.id.itszid:
                        startActivity(new Intent(getApplicationContext(), PrincipalAdministrativo.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        //////////////////////////////////////////////SALIR/////////////////////////////////////////
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        txtnombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerfilAdminActivity.class));
            }
        });
        txtcontats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Contacts.class));
            }
        });
        txtGruposid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SelectGrupo.class));
            }
        });
    }
}