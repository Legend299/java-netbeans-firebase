package com.firebasejava.entidades;

public class Estudiante {
    
    private String nombre;
    private int semestre;
    private String correo;
    
    public Estudiante(){
    }

    public Estudiante(String nombre, int semestre, String correo) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
}
