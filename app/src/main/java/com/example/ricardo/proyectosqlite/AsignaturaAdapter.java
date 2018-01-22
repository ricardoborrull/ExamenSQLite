package com.example.ricardo.proyectosqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 2dam on 22/01/2018.
 */

public class AsignaturaAdapter extends CursorAdapter {

    public AsignaturaAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        return LayoutInflater.from(context).inflate(R.layout.asignatura, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Obtenemos los views
        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        TextView horas = (TextView) view.findViewById(R.id.horas);

        // Obtenemos la información del cursor
        String sNombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String sHoras = cursor.getString(cursor.getColumnIndexOrThrow("horas"));

        nombre.setText("Nombre: " + sNombre);
        horas.setText("Horas: "+ sHoras);
        }
    }

