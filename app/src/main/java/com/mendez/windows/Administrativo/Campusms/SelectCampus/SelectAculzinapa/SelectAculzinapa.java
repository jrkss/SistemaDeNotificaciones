package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectAculzinapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.CuichapaDesarrollo;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.CuichapaForestal;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.CuichapaGestion;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.CuichapaInnovacion;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.CuichapaSistemas;
import com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa.SelectCuichapa;
import com.mendez.windows.R;

public class SelectAculzinapa extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_aculzinapa);
        cardViewdesarrollo = (CardView)findViewById(R.id.aculzinapadesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.aculzinapaforestal);
        cardViewgestion = (CardView)findViewById(R.id.aculzinapagestion);
        cardViewsistemas = (CardView)findViewById(R.id.aculzinapasistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.aculzinapainnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectAculzinapa.this, AculzinapaDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectAculzinapa.this, AculzinapaGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectAculzinapa.this, AculzinapaForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectAculzinapa.this, AculzinapaSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectAculzinapa.this, AculzinapaInnovacion.class);
                startActivity(i);
            }
        });
    }
}