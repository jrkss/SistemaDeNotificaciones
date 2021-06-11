package com.mendez.windows.Administrativo.Campusms.SelectCampus.SelectCuichapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mendez.windows.Administrativo.controller.AdapterMensajes;
import com.mendez.windows.R;

public class SelectCuichapa extends AppCompatActivity {
    CardView cardViewsistemas, cardViewgestion,cardViewdesarrollo, cardViewforestal, cardViewinnovacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cuichapa);
        cardViewdesarrollo = (CardView)findViewById(R.id.cuichapadesarrollo);
        cardViewforestal = (CardView)findViewById(R.id.cuichapaforestal);
        cardViewgestion = (CardView)findViewById(R.id.cuichapagestion);
        cardViewsistemas = (CardView)findViewById(R.id.cuichapasistemas);
        cardViewinnovacion = (CardView)findViewById(R.id.cuichapainnovacion);

        cardViewdesarrollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCuichapa.this, CuichapaDesarrollo.class);
                startActivity(i);
            }
        });
        cardViewgestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCuichapa.this, CuichapaGestion.class);
                startActivity(i);
            }
        });
        cardViewforestal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCuichapa.this, CuichapaForestal.class);
                startActivity(i);
            }
        });
        cardViewsistemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCuichapa.this, CuichapaSistemas.class);
                startActivity(i);
            }
        });
        cardViewinnovacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCuichapa.this, CuichapaInnovacion.class);
                startActivity(i);
            }
        });
    }
}