package com.santiagobruno.trabajointegrador.repository;

import java.util.List;

public interface IDAO<T> {

    void agregar(T t);
    void modificar(String x, String y, String z);
    void eliminar(String t);
    T buscar(String t);
    List<T> listar();

}
