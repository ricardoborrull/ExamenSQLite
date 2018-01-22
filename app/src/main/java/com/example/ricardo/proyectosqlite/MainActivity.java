package com.example.ricardo.proyectosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
    private Button nuevo, verbbdd, borrar, nueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));

        nuevo = (Button) findViewById(R.id.nuevo);
        verbbdd = (Button) findViewById(R.id.verbbdd);
        borrar = (Button) findViewById(R.id.borrar);
        nueva = (Button) findViewById(R.id.nueva);

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NuevaAsignatura.class);
                startActivity(i);
            }
        });

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NuevoUsuario.class);
                startActivity(i);
            }
        });

        verbbdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.borrarDB();
                Toast.makeText(MainActivity.this, "Base de datos eliminada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
