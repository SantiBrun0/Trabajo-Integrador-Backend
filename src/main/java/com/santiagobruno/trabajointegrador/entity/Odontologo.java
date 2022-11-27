package com.santiagobruno.trabajointegrador.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "odontologos")
public class Odontologo {

    @Id
    @Column(nullable = false, unique = true)
    private String matricula;

    @NonNull
    private String apellido;

    @NonNull
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
