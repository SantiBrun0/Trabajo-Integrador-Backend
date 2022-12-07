package com.santiagobruno.trabajointegrador.exceptions;

public class OdontologoRepeteadException extends Exception {

    public OdontologoRepeteadException() {
        super("El odontologo que intenta agregar ya existe en la base de datos");
    }

}
