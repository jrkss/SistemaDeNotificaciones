package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTequila;

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

public class SelectTequila extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tequila);
        cardViewdesarrollo = (CardView)findViewById(R.id.tequiladesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.tequilaforestal);
        cardViewgestion = (CardView)findViewById(R.id.tequilagestion);
        cardViewsistemas = (CardView)findViewById(R.id.tequilasistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.tequilainnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTequila.this, TequilaDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTequila.this, TequilaGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTequila.this, TequilaForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTequila.this, TequilaSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTequila.this, TequilaInnovacion.class);
                startActivity(i);
            }
        });
    }
}