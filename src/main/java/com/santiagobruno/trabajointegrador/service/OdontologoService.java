package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.model.Odontologo;
import com.santiagobruno.trabajointegrador.repository.OdontologoDAOH2;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OdontologoService {

    private final OdontologoDAOH2 odontologoDAO;

    public void agregarOdontologo(Odontologo odontologo) {
        odontologoDAO.agregar(odontologo);
    }

    public void modificarOdontologo(String nombre, String apellido, String matricula) {
        odontologoDAO.modificar(nombre, apellido, matricula);
    }

    public void eliminarOdontologo(String matricula) {
        odontologoDAO.eliminar(matricula);
    }

    public Odontologo buscarOdontologo(String matricula) {
        return odontologoDAO.buscar(matricula);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoDAO.listar();
    }


}
