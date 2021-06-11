package com.mendez.windows.Docente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mendez.windows.Alumno.Controller.AdapterMensajesA;
import com.mendez.windows.R;

public class CCarreraDocenteActivity extends AppCompatActivity {
    private TextView nombre;
    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private ImageButton btnEnviar;
    private AdapterMensajesA adapter;
    private ImageButton btnEnviarFoto;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private static final int PHOTO_SEND = 1;

    private FirebaseAuth mAuth;
    private String NOMBRE_USUARIO;

    private String CAMPUSNAME;
    ////////////////////////////
    private DatabaseReference mDatabase;
    private BottomNavigationView bottonNavITSZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_carrera_docente);
    }
}