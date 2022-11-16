package com.santiagobruno.trabajointegrador.model;


import java.sql.Date;
import java.util.Objects;

public final class Paciente {
    private final String apellido;
    private final String nombre;
    private final String domicilio;
    private final String dni;
    private final Date fechaAlta;

    public Paciente(String apellido, String nombre, String domicilio, String dni, Date fechaAlta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public String apellido() {
        return apellido;
    }

    public String nombre() {
        return nombre;
    }

    public String domicilio() {
        return domicilio;
    }

    public String dni() {
        return dni;
    }

    public Date fechaAlta() {
        return fechaAlta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Paciente) obj;
        return Objects.equals(this.apellido, that.apellido) &&
                Objects.equals(this.nombre, that.nombre) &&
                Objects.equals(this.domicilio, that.domicilio) &&
                Objects.equals(this.dni, that.dni) &&
                Objects.equals(this.fechaAlta, that.fechaAlta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, nombre, domicilio, dni, fechaAlta);
    }

    @Override
    public String toString() {
        return "Paciente[" +
                "apellido=" + apellido + ", " +
                "nombre=" + nombre + ", " +
                "domicilio=" + domicilio + ", " +
                "dni=" + dni + ", " +
                "fechaAlta=" + fechaAlta + ']';
    }

}
