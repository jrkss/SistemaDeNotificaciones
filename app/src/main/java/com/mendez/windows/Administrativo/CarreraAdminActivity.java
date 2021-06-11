package com.mendez.windows.Administrativo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mendez.windows.Administrativo.MensajeCarrera.DesarrolloAdmin;
import com.mendez.windows.Administrativo.MensajeCarrera.ForestalAdmin;
import com.mendez.windows.Administrativo.MensajeCarrera.GestionAdmin;
import com.mendez.windows.Administrativo.MensajeCarrera.SistemasAdmin;
import com.mendez.windows.Administrativo.MensajeCarrera.SustentableAdmin;
import com.mendez.windows.Alumno.CCarreraActivity;
import com.mendez.windows.Alumno.CampusActivity;
import com.mendez.windows.Alumno.MenuActivity;
import com.mendez.windows.Alumno.Principal;
import com.mendez.windows.R;

public class CarreraAdminActivity extends AppCompatActivity {
    private CardView sistemasidc, gestionidc, desarrolloidc, forestalidc, sustentablec;

    private BottomNavigationView bottonNavITSZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_admin);
        sistemasidc = findViewById(R.id.sistemasid);
        gestionidc = findViewById(R.id.gestionid);
        desarrolloidc = findViewById(R.id.desarrolloid);
        forestalidc = findViewById(R.id.forestalid);
        sustentablec = findViewById(R.id.sustentableid);


        bottonNavITSZ = findViewById(R.id.BottomBav);

        bottonNavITSZ.setSelectedItemId(R.id.carrerazid);

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
                        return true;

                    case R.id.itszid:
                        startActivity(new Intent(getApplicationContext(), PrincipalAdministrativo.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuid:
                        startActivity(new Intent(getApplicationContext(), MenuAdminActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        sistemasidc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SistemasAdmin.class);
                startActivity(i);
            }
        });
        gestionidc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GestionAdmin.class);
                startActivity(i);
            }
        });
        desarrolloidc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DesarrolloAdmin.class);
                startActivity(i);
            }
        });
        forestalidc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForestalAdmin.class);
                startActivity(i);
            }
        });
        sustentablec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SustentableAdmin.class);
                startActivity(i);
            }
        });
    }
}