package com.mendez.windows.Administrativo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mendez.windows.Administrativo.Campusms.Aculzinapams;
import com.mendez.windows.Administrativo.Campusms.Cuichapams;
import com.mendez.windows.Administrativo.Campusms.Nogalesms;
import com.mendez.windows.Administrativo.Campusms.Tehuipangoms;
import com.mendez.windows.Administrativo.Campusms.Tequilams;
import com.mendez.windows.Administrativo.Campusms.Tezonapams;
import com.mendez.windows.Administrativo.Campusms.Zongolicams;
import com.mendez.windows.Alumno.CCarreraActivity;
import com.mendez.windows.Alumno.CarreraActivity;
import com.mendez.windows.Alumno.MenuActivity;
import com.mendez.windows.Alumno.Principal;
import com.mendez.windows.R;

public class CampusAdminActivity extends AppCompatActivity {
    private BottomNavigationView bottonNavITSZ;

    private CardView txtZon;
    private CardView txtNog;
    private CardView txtTe;
    private CardView txtTez;
    private CardView txtTeh;
    private CardView txtCui;
    private CardView txtAcu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_admin);

        txtZon = findViewById(R.id.zongolicaidms1);
        txtNog = findViewById(R.id.nogalesidms1);
        txtTe = findViewById(R.id.tequilams1);
        txtTez = findViewById(R.id.tezonapams1);
        txtTeh = findViewById(R.id.tehuipangoms1);
        txtCui = findViewById(R.id.cuichapams1);
        txtAcu = findViewById(R.id.aculzinapams1);

        bottonNavITSZ = findViewById(R.id.BottomBav);
        bottonNavITSZ.setSelectedItemId(R.id.campusid);
        bottonNavITSZ.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.campusid:
                        return true;

                    case R.id.campusCaid:
                        startActivity(new Intent(getApplicationContext(), CCarreraAdminActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.carrerazid:
                        startActivity(new Intent(getApplicationContext(), CarreraAdminActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.itszid:
                        startActivity(new Intent(getApplicationContext(), PrincipalAdministrativo.class));
                        overridePendingTransition(0, 0);
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
                Intent intent = new Intent(CampusAdminActivity.this, Zongolicams.class);
                startActivity(intent);
            }
        });
        txtNog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampusAdminActivity.this, Nogalesms.class);
                startActivity(intent);
            }
        });
        txtTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampusAdminActivity.this, Tequilams.class);
                startActivity(intent);
            }
        });
        txtTez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampusAdminActivity.this, Tezonapams.class);
                startActivity(intent);
            }
        });
        txtTeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampusAdminActivity.this, Tehuipangoms.class);
                startActivity(intent);
            }
        });
        txtCui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampusAdminActivity.this, Cuichapams.class);
                startActivity(intent);
            }
        });
        txtAcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampusAdminActivity.this, Aculzinapams.class);
                startActivity(intent);
            }
        });
    }
}