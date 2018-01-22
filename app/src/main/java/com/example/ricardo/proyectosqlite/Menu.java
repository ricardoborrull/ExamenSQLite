package com.example.ricardo.proyectosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;

public class Menu extends AppCompatActivity {

    private Button vertodo, asignatura, prof, alum;
    private Cursor cursor;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        vertodo = (Button) findViewById(R.id.vertodo);
        alum = (Button) findViewById(R.id.alum);
        prof = (Button) findViewById(R.id.prof);
        asignatura = (Button) findViewById(R.id.asignatura);


        vertodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, VerBBDD.class);
                i.putExtra("Boton", "Todos");
                startActivity(i);
            }
        });

        alum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, VerBBDD.class);
                i.putExtra("Boton", "Alumnos");
                startActivity(i);
            }
        });


        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, VerBBDD.class);
                i.putExtra("Boton", "Profesores");
                startActivity(i);
            }
        });

        asignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, VerAsignatura.class);
                startActivity(i);
            }
        });
    }
}
