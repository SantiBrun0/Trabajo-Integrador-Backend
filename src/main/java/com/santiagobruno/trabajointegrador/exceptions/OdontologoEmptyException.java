package com.santiagobruno.trabajointegrador.exceptions;

public class OdontologoEmptyException extends Exception {

    public OdontologoEmptyException() {
        super("Error al agregar el odontologo, ingrese datos correctos");
    }

}
