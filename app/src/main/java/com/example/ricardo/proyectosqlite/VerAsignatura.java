package com.example.ricardo.proyectosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

public class VerAsignatura extends AppCompatActivity {

    private ListView lista;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_asignatura);

        lista = (ListView) findViewById(R.id.lista);;

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        Cursor cursor = dbAdapter.recuperarAsignaturas();
        //Crea el adapter de la lista y le mete los datos del cursor
        final AsignaturaAdapter Adapter = new AsignaturaAdapter(this, cursor);
        lista.setAdapter(Adapter);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
    }
}
