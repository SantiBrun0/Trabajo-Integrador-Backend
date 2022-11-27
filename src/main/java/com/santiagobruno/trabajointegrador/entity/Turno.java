package com.santiagobruno.trabajointegrador.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_dni", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologos_matricula", nullable = false)
    private Odontologo odontologo;

    @NonNull
    private Date fecha;


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
