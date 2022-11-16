package com.santiagobruno.trabajointegrador.model;

import java.time.LocalDate;

public record Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha) {
}
