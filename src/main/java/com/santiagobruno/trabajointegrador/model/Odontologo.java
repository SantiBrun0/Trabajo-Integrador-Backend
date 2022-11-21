package com.santiagobruno.trabajointegrador.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "odontologos")
public class Odontologo {

    @Id
    private String matricula;
    private String apellido;
    private String nombre;


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
