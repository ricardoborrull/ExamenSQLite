package com.example.ricardo.proyectosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ricardo on 21/01/2018.
 */

public class MyDBAdapter {

    //Definición de nombre de bbdd, tabla y versión.
    private static final String DATABASE_NAME = "florida.db";
    private static final String DATABASE_TABLE1 = "usuarios";
    private static final String DATABASE_TABLE2 = "asignaturas";
    private static final int DATABASE_VERSION = 1;

    //Definición de campos
    private static final String ID = "_id";
    private static final String ROL = "rol";
    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String CURSO = "curso";
    private static final String VARIABLE = "variable";

    private static final String IDA = "_id";
    private static final String NOMBREA = "nombre";
    private static final String HORAS = "horas";

    private static String[] camposTabla;
    private static String where;
    private static String[] argsWhere;
    private static String groupBy;
    private static String having;
    private static String orderBy;

    //Creación de la tabla
    private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE1 + " (_id integer primary key autoincrement, " +
            "nombre text, rol text, edad text, ciclo text, curso text, variable text); CREATE TABLE " + DATABASE_TABLE2 +
            " (_id interger primary key autoincrement, nombre text, horas text;";

    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS " + DATABASE_TABLE1 + ";";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS " + DATABASE_TABLE2 + ";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter(Context c) {
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open() {

        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = dbHelper.getReadableDatabase();
        }
    }

    public void borrarDB() {
        dbHelper.onUpgrade(db, DATABASE_VERSION, DATABASE_VERSION);
    }

    //Método para la inserción de usuarios en la bbdd;
    public void nuevoUsuario(Usuario u) {

        ContentValues newValues = new ContentValues();
        newValues.put(NOMBRE, u.getNombre());
        newValues.put(ROL, u.getRol());
        newValues.put(EDAD, u.getEdad());
        newValues.put(CURSO, u.getCurso());
        newValues.put(CICLO, u.getCiclo());
        newValues.put(VARIABLE, u.getVariable());
        db.insert(DATABASE_TABLE1, null, newValues);
    }

    public void nuevaAsignatura(Asignatura a) {
        ContentValues newValues = new ContentValues();
        newValues.put(NOMBREA, a.getNombre());
        newValues.put(HORAS, a.getHoras());
        db.insert(DATABASE_TABLE2, null, newValues);
    }

    public void borrarUsuario(int row) {
        db.delete(DATABASE_TABLE1, ID + "=" + row, null);
    }

    public Cursor recuperarTodo() {
        camposTabla = null;
        where = null;
        argsWhere = null;
        groupBy = null;
        having = null;
        orderBy = "nombre ASC";

        Cursor cursor = db.query(DATABASE_TABLE1, camposTabla, where, argsWhere, groupBy, having, orderBy);
        return cursor;
    }

    public Cursor recuperarAsignaturas() {
        camposTabla = null;
        where = null;
        argsWhere = null;
        groupBy = null;
        having = null;
        orderBy = "nombre ASC";

        Cursor cursor = db.query(DATABASE_TABLE2, camposTabla, where, argsWhere, groupBy, having, orderBy);
        return cursor;
    }

    public Cursor recuperarAlumnos() {
        camposTabla = null;
        where = ROL+"=?";
        argsWhere = new String[]{"Alumno"};
        groupBy = null;
        having = null;
        orderBy = "nombre ASC";

        Cursor cursor = db.query(DATABASE_TABLE1, camposTabla, where, argsWhere, groupBy, having, null);
        return cursor;
    }

    public Cursor recuperarProfesores() {
        camposTabla = null;
        where = ROL+"=?";
        argsWhere = new String[]{"Profesor"};
        groupBy = null;
        having = null;
        orderBy = "nombre ASC";

        Cursor cursor = db.query(DATABASE_TABLE1, camposTabla, where, argsWhere, groupBy, having, orderBy);
        return cursor;
    }


    private static class MyDbHelper extends SQLiteOpenHelper {
        public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }
    }
}

