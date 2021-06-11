package com.mendez.windows;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mendez.windows.Alumno.Principal;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    private EditText editTextNombreA;
    private EditText editTextMatriculaA;
    private Spinner spnIng;
    private Spinner spnCam;
    private Spinner spnSem;
    private EditText editTextCorreoA;
    private EditText editTextContraA;

    //Datos vacios
    private String nombreAlumno ="";
    private String matriculaAlumno ="";
    private String ingAlumno ="";
    private String campusAlumno ="";
    private String semestreAlumno ="";
    private String correoAlumno ="";
    private String contraAlumno ="";

    private Button btnR;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        editTextNombreA = findViewById(R.id.et_NombreA);
        editTextMatriculaA = findViewById(R.id.et_MatriculaA);
        spnIng = findViewById(R.id.SpinnerIngenieria);
        spnCam = findViewById(R.id.SpinnerCampus);
        spnSem = findViewById(R.id.SpinnerSemestre);
        editTextCorreoA = findViewById(R.id.et_EmailA);
        editTextContraA = findViewById(R.id.et_PassA);
        btnR = findViewById(R.id.et_RegistroA);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombreAlumno= editTextNombreA.getText().toString();
                matriculaAlumno=editTextMatriculaA.getText().toString();
                ingAlumno=spnIng.getSelectedItem().toString();
                campusAlumno=spnCam.getSelectedItem().toString();
                semestreAlumno=spnSem.getSelectedItem().toString();
                correoAlumno=editTextCorreoA.getText().toString();
                contraAlumno=editTextContraA.getText().toString();

                if(!nombreAlumno.isEmpty() && !matriculaAlumno.isEmpty() && !ingAlumno.isEmpty() && !campusAlumno.isEmpty()
                        && !semestreAlumno.isEmpty() && !correoAlumno.isEmpty() && !contraAlumno.isEmpty()){
                    if (contraAlumno.length() >=6) {
                        regAlumno();
                    }
                }else{
                    Toast.makeText(Registro.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void regAlumno() {
        mAuth.createUserWithEmailAndPassword(correoAlumno, contraAlumno).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object>map = new HashMap<>();
                    map.put("nombre", nombreAlumno);
                    map.put("matricula", matriculaAlumno);
                    map.put("ingenieria", ingAlumno);
                    map.put("campus", campusAlumno);
                    map.put("semestre", semestreAlumno);
                    map.put("correo", correoAlumno);
                    map.put("iduser", "Alumno");

                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Usuario").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(Registro.this, Principal.class));
                                finish();
                            }
                        }
                    });
                }
            }
        });
    }
}