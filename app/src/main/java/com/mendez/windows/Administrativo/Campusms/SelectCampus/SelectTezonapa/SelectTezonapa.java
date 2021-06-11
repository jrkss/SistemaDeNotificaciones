package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTezonapa;

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

public class SelectTezonapa extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tezonapa);
        cardViewdesarrollo = (CardView)findViewById(R.id.tezonapadesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.tezonapaforestal);
        cardViewgestion = (CardView)findViewById(R.id.tezonapagestion);
        cardViewsistemas = (CardView)findViewById(R.id.tezonapasistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.tezonapainnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTezonapa.this, TezonapaDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTezonapa.this, TezonapaGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTezonapa.this, TezonapaForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTezonapa.this, TezonapaSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTezonapa.this, TezonapaInnovacion.class);
                startActivity(i);
            }
        });
    }
}