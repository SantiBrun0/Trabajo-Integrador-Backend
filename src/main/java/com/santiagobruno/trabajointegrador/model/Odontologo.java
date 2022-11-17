package com.santiagobruno.trabajointegrador.model;


import java.util.Objects;

public class Odontologo {
    private String apellido;
    private String nombre;
    private String matricula;

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String apellido() {
        return apellido;
    }

    public String nombre() {
        return nombre;
    }

    public String matricula() {
        return matricula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Odontologo) obj;
        return Objects.equals(this.apellido, that.apellido) &&
                Objects.equals(this.nombre, that.nombre) &&
                Objects.equals(this.matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, nombre, matricula);
    }

    @Override
    public String toString() {
        return "Odontologo[" +
                "apellido=" + apellido + ", " +
                "nombre=" + nombre + ", " +
                "matricula=" + matricula + ']';
    }

}
