package com.example.ricardo.proyectosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NuevaAsignatura extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
    private EditText nombre, horas;
    private Button ok;
    private String sNom, sAsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_asignatura);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));

        nombre = (EditText) findViewById(R.id.nombre);
        horas = (EditText) findViewById(R.id.horas);
        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sNom = nombre.getText().toString();
                sAsig = horas.getText().toString();

                Asignatura a = new Asignatura(sNom, sAsig);

                dbAdapter.nuevaAsignatura(a);

                Toast.makeText(NuevaAsignatura.this, "Usuario creado", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
