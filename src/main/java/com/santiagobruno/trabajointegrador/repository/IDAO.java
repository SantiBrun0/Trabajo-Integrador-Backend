package com.santiagobruno.trabajointegrador.repository;

import java.util.List;

public interface IDAO<T> {

    void agregar(T t);
    void modificar(String nombre, String apellido, String t);
    void eliminar(String matricula);
    T buscar(String matricula);
    List<T> listar();

}
