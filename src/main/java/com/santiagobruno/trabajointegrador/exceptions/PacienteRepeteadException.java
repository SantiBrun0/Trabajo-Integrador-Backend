package com.santiagobruno.trabajointegrador.exceptions;

public class PacienteRepeteadException extends Exception {

    public PacienteRepeteadException() {
        super("El paciente que intenta agregar ya existe en la base de datos");
    }

}
