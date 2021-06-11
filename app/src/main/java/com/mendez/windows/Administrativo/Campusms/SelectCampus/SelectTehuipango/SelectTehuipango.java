package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectTehuipango;

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

public class SelectTehuipango extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tehuipango);
        cardViewdesarrollo = (CardView)findViewById(R.id.tehuipangodesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.tehuipangoforestal);
        cardViewgestion = (CardView)findViewById(R.id.tehuipangogestion);
        cardViewsistemas = (CardView)findViewById(R.id.tehuipangosistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.tehuipangoinnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTehuipango.this, TehuipangoDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTehuipango.this, TehuipangoGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTehuipango.this, TehuipangoForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTehuipango.this, TehuipangoSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTehuipango.this, TehuipangoInnovacion.class);
                startActivity(i);
            }
        });
    }
}