package com.santiagobruno.trabajointegrador.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    private String dni;
    private String apellido;
    private String nombre;
    private String domicilio;
    private Date fechaAlta;


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
