package com.mendez.windows.Administrativo.Grupos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mendez.windows.R;

public class SelectGrupo extends AppCompatActivity {

    private CardView jefe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_grupo);
        jefe = (CardView) findViewById(R.id.jefeid);


        jefe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectGrupo.this, JefeGrupo.class));
            }
        });
    }
}