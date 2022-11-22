package com.santiagobruno.trabajointegrador.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private long id;

    @Column(name = "codigo_turno", nullable = false, unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "paciente_turno_fk"))
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "odontologo_turno_fk"))
    private Odontologo odontologo;

    @Column(name = "fecha_hora", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.S", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fecha;


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
