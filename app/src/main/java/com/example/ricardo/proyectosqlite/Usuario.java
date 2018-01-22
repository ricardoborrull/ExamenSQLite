package com.example.ricardo.proyectosqlite;

/**
 * Created by Ricardo on 20/01/2018.
 */

public class Usuario {

    private String nombre;
    private String edad;
    private String ciclo;
    private String curso;
    private String rol;
    //Esto es nota media o despacho.
    private String variable;

    public Usuario(String nombre, String edad, String ciclo, String curso, String rol, String variable) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.curso = curso;
        this.rol = rol;
        this.variable = variable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}
