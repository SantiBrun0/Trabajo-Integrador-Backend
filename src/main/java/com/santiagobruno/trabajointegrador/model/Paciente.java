package com.santiagobruno.trabajointegrador.model;


import java.sql.Date;

public record Paciente(String apellido, String nombre, String domicilio, String dni, Date fechaAlta) {
}
