package com.santiagobruno.trabajointegrador.model;


import java.time.LocalDate;
import java.util.Objects;

public class Turno {

    private String codigo;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;

    public Turno(String codigo, Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public String codigo() { return codigo; }

    public Paciente paciente() {
        return paciente;
    }

    public Odontologo odontologo() {
        return odontologo;
    }

    public LocalDate fecha() {
        return fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Turno) obj;
        return Objects.equals(this.paciente, that.paciente) &&
                Objects.equals(this.odontologo, that.odontologo) &&
                Objects.equals(this.fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paciente, odontologo, fecha);
    }

    @Override
    public String toString() {
        return "Turno[" +
                "paciente=" + paciente + ", " +
                "odontologo=" + odontologo + ", " +
                "fecha=" + fecha + ']';
    }

}
