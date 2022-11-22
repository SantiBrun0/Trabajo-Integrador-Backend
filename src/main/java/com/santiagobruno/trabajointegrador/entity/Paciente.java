package com.santiagobruno.trabajointegrador.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;


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
