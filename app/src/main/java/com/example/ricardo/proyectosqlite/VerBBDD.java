package com.example.ricardo.proyectosqlite;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VerBBDD extends AppCompatActivity {

    private ListView lista;
    private Spinner spinner;
    private MyDBAdapter dbAdapter;
    private Cursor cursor;
    ArrayAdapter<String> comboAdapter;

    String filtros[] = {"Ver todo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_bbdd);

        lista = (ListView) findViewById(R.id.lista);
        Intent i = getIntent();

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        switch  (i.getStringExtra("Boton")){
            case "Todos":
                cursor = dbAdapter.recuperarTodo();
                break;
            case "Profesores":
                cursor = dbAdapter.recuperarProfesores();
                break;
            case "Alumnos":
                cursor = dbAdapter.recuperarAlumnos();
                break;
        }

        //Declaramos el cursor
        //Cursor cursor = dbAdapter.recuperarTodo();
        //Crea el adapter de la lista y le mete los datos del cursor
        final UserAdapter usuariosAdapter = new UserAdapter(this, cursor);
        lista.setAdapter(usuariosAdapter);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        spinner = (Spinner) findViewById(R.id.spinner);
        comboAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, filtros);
        spinner.setAdapter(comboAdapter);

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //cursor.getColumnIndexOrThrow()
                Toast.makeText(VerBBDD.this, "Usuario "+position+1+" eliminado", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
