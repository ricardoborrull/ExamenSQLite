package com.example.ricardo.proyectosqlite;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NuevoUsuario extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
    private EditText nombre, edad, curso, ciclo, variable;
    private RadioButton alumno, profesor;
    private RadioGroup rol;
    private Button ok;
    private String opcion, sID, sNom, sEdad, sRol, sCiclo, sCurso, sVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));

        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        curso = (EditText) findViewById(R.id.curso);
        ciclo = (EditText) findViewById(R.id.ciclo);
        variable = (EditText) findViewById(R.id.var);
        ok = (Button) findViewById(R.id.ok);
        rol = (RadioGroup) findViewById(R.id.rol);
        alumno = (RadioButton) findViewById(R.id.alumno);
        profesor = (RadioButton) findViewById(R.id.profesor);

        rol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.alumno){
                    opcion = alumno.getText().toString();
                    sRol = opcion;
                }else if (checkedId == R.id.profesor) {
                    opcion = profesor.getText().toString();
                    sRol = opcion;
                }
            }

        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sNom = nombre.getText().toString();
                sEdad = edad.getText().toString();
                sCiclo = ciclo.getText().toString();
                sCurso = curso.getText().toString();
                sVar = variable.getText().toString();

                Usuario u = new Usuario(sNom, sEdad, sCiclo, sCurso, sRol, sVar); // Creamos un nuevo usuario

                dbAdapter.nuevoUsuario(u);

                Toast.makeText(NuevoUsuario.this, "Usuario creado", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
