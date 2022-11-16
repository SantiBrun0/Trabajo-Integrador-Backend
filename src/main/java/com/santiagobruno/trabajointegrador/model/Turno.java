package com.santiagobruno.trabajointegrador.model;

import java.sql.Date;
import java.sql.Time;

public record Turno(Paciente paciente, Odontologo odontologo, Date fecha, Time hora) {
}
