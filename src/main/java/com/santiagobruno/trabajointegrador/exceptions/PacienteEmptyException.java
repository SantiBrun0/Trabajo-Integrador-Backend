package com.santiagobruno.trabajointegrador.exceptions;

public class PacienteEmptyException extends Exception {

    public PacienteEmptyException() {
        super("Error al agregar el odontologo, ingrese datos correctos");
    }

}
