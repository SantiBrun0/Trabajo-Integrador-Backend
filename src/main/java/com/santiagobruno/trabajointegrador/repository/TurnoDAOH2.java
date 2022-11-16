package com.santiagobruno.trabajointegrador.repository;

import com.santiagobruno.trabajointegrador.model.Paciente;
import com.santiagobruno.trabajointegrador.model.Turno;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.santiagobruno.trabajointegrador.repository.H2Helper.getConnection;

public class TurnoDAOH2 implements IDAO<Turno> {


    @Override
    public void agregar(Turno turno) {

    }

    @Override
    public void modificar(String nombre, String apellido, String t) {

    }

    @Override
    public void eliminar(String t) {

    }

    @Override
    public Turno buscar(String t) {
        return null;
    }

    @Override
    public List<Turno> listar() {
        return null;
    }

}
