package com.mendez.windows.Alumno;

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
import com.mendez.windows.Alumno.CCarreraActivity;
import com.mendez.windows.Alumno.CampusActivity;
import com.mendez.windows.Alumno.Perfil.PerfilActivity;
import com.mendez.windows.Alumno.Principal;
import com.mendez.windows.LoginActivity;
import com.mendez.windows.R;

public class MenuActivity extends AppCompatActivity {
    private TextView txtnombre;
    private Button btnSalir;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    float  x1, x2, y1, y2;
    private BottomNavigationView bottonNavITSZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnSalir = findViewById(R.id.btnClose);

        txtnombre = findViewById(R.id.nombreUser);
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
                        startActivity(new Intent(getApplicationContext(), CampusActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.campusCaid:
                        startActivity(new Intent(getApplicationContext(), CCarreraActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.carrerazid:
                        startActivity(new Intent(getApplicationContext(), CarreraActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuid:
                        return true;

                    case R.id.itszid:
                        startActivity(new Intent(getApplicationContext(), Principal.class));
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
                startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
            }
        });
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 <x2){
                    startActivity(new Intent(getApplicationContext(), CCarreraActivity.class));
                    overridePendingTransition(0,0);
                }
                break;
        }
        return false;
    }
}