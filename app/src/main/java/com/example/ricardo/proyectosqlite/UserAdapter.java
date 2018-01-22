package com.example.ricardo.proyectosqlite;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class UserAdapter extends CursorAdapter {

    public UserAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        return LayoutInflater.from(context).inflate(R.layout.element, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Obtenemos los views
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView rol = (TextView) view.findViewById(R.id.rol);
        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        TextView edad = (TextView) view.findViewById(R.id.edad);
        TextView ciclo = (TextView) view.findViewById(R.id.ciclo);
        TextView curso = (TextView) view.findViewById(R.id.curso);
        TextView variable = (TextView) view.findViewById(R.id.var);
        ImageView foto = (ImageView) view.findViewById(R.id.foto);

        // Obtenemos la información del cursor
        String sID = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String sNombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String sCurso = cursor.getString(cursor.getColumnIndexOrThrow("curso"));
        String sRol = cursor.getString(cursor.getColumnIndexOrThrow("rol"));
        String sEdad = cursor.getString(cursor.getColumnIndexOrThrow("edad"));
        String sCiclo = cursor.getString(cursor.getColumnIndexOrThrow("ciclo"));
        String sVariable = cursor.getString(cursor.getColumnIndexOrThrow("variable"));

        id.setText("ID: " + sID);
        nombre.setText("Nombre: " + sNombre);
        rol.setText("Rol: " + sRol);
        edad.setText("Edad: " + sEdad);
        ciclo.setText("Ciclo: " + sCiclo);
        curso.setText("Curso: " + sCurso);
        if (sRol.equals("Alumno")) {
            variable.setText("Nota media: " + sVariable);
            foto.setImageResource(R.drawable.alumno);
        } else {
            variable.setText("Despacho: " + sVariable);
            foto.setImageResource(R.drawable.profesor);
        }

    }

}
