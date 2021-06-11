package com.mendez.windows;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeleccionRegistro extends AppCompatActivity {
    TextView inicio;
    Button btnAlumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_registro);
        inicio = findViewById(R.id.idsesion);
        btnAlumno = findViewById(R.id.idbtnAlumno);

        btnAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(SeleccionRegistro.this, Registro.class);
                startActivity(inte);
            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(SeleccionRegistro.this, LoginActivity.class);
                startActivity(inte);
            }
        });
    }
}