package com.santiagobruno.trabajointegrador.model;


import java.sql.Date;
import java.util.Objects;

public class Paciente {
    private String apellido;
    private String nombre;
    private String domicilio;
    private String dni;
    private Date fechaAlta;

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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
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
