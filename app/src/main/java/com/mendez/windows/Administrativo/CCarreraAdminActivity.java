package com.mendez.windows.Administrativo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.SelectAculzinapa;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.SelectCuichapa;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectNogales.SelectNogales;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTehuipango.SelectTehuipango;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTequila.SelectTequila;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTezonapa.SelectTezonapa;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectZongolica.SelectZongolica;
import com.mendez.windows.R;

public class CCarreraAdminActivity extends AppCompatActivity {
    private CardView txtZon, txtNog, txtTeq, txtTez, txtTeh, txtCui, txtAcu;
    private BottomNavigationView bottonNavITSZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_carrera_admin);
        txtZon = findViewById(R.id.selectzongolica);
        txtNog = findViewById(R.id.nogalesidms1);
        txtTeq = findViewById(R.id.tequilams1);
        txtTez = findViewById(R.id.tezonapams1);
        txtTeh = findViewById(R.id.tehuipangoms1);
        txtCui = findViewById(R.id.cuichapams1);
        txtAcu = findViewById(R.id.aculzinapams1);

        bottonNavITSZ = findViewById(R.id.BottomBav);
        bottonNavITSZ.setSelectedItemId(R.id.campusCaid);
        bottonNavITSZ.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.campusid:
                        startActivity(new Intent(getApplicationContext(), CampusAdminActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.campusCaid:

                        return true;

                    case R.id.carrerazid:
                        startActivity(new Intent(getApplicationContext(), CarreraAdminActivity.class));
                        overridePendingTransition(0,0);
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
        txtZon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectZongolica.class);
                startActivity(intent);
            }
        });
        txtNog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectNogales.class);
                startActivity(intent);
            }
        });
        txtTeq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectTequila.class);
                startActivity(intent);
            }
        });
        txtTez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectTezonapa.class);
                startActivity(intent);
            }
        });
        txtTeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectTehuipango.class);
                startActivity(intent);
            }
        });
        txtCui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectCuichapa.class);
                startActivity(intent);
            }
        });
        txtAcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CCarreraAdminActivity.this, SelectAculzinapa.class);
                startActivity(intent);
            }
        });
    }

}