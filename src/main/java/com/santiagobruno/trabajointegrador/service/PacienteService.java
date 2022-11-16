package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.model.Paciente;
import com.santiagobruno.trabajointegrador.repository.PacienteDAOH2;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteDAOH2 pacienteDAO;

    public void agregarPaciente(Paciente paciente) {
        pacienteDAO.agregar(paciente);
    }

    public void modificarPaciente(String nombre, String apellido, String dni) {
        pacienteDAO.modificar(nombre, apellido, dni);
    }

    public void eliminarPaciente(String dni) {
        pacienteDAO.eliminar(dni);
    }

    public Paciente buscarPaciente(String dni) {
        return pacienteDAO.buscar(dni);
    }

    public List<Paciente> listarPacientes() {
        return pacienteDAO.listar();
    }

}
