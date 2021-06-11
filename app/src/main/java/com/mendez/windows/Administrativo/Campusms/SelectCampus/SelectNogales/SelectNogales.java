package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectNogales;

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

public class SelectNogales extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_nogales);
        cardViewdesarrollo = (CardView)findViewById(R.id.nogalesdesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.nogalesforestal);
        cardViewgestion = (CardView)findViewById(R.id.nogalesgestion);
        cardViewsistemas = (CardView)findViewById(R.id.nogalessistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.nogalesinnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectNogales.this, NogalesDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectNogales.this, NogalesGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectNogales.this, NogalesForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectNogales.this, NogalesSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectNogales.this, NogalesInnovacion.class);
                startActivity(i);
            }
        });
    }
}