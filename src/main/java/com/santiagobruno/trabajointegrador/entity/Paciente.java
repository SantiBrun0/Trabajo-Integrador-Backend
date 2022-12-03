package com.santiagobruno.trabajointegrador.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @Column(nullable = false, unique = true)
    private String dni;

    @NonNull
    private String apellido;

    @NonNull
    private String nombre;

    private String domicilio;

    private LocalDate fechaAlta;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "paciente", orphanRemoval = true)
    //@JoinColumn(name = "paciente_dni")
    @JsonManagedReference("paciente")
    private Set<Turno> turnos = new HashSet<>();


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
