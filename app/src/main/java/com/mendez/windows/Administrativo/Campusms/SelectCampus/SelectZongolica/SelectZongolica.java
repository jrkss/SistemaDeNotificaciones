package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectZongolica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.AculzinapaDesarrollo;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.AculzinapaForestal;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.AculzinapaGestion;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.AculzinapaInnovacion;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.AculzinapaSistemas;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa.SelectAculzinapa;
import com.mendez.windows.R;

public class SelectZongolica extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_zongolica);
        cardViewdesarrollo = (CardView)findViewById(R.id.zongolicadesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.zongolicaforestal);
        cardViewgestion = (CardView)findViewById(R.id.zongolicagestion);
        cardViewsistemas = (CardView)findViewById(R.id.zongolicasistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.zongolicainnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectZongolica.this, ZongolicaDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectZongolica.this, ZongolicaGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectZongolica.this, ZongolicaForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectZongolica.this, ZongolicaSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectZongolica.this, ZongolicaInnovacion.class);
                startActivity(i);
            }
        });
    }
}