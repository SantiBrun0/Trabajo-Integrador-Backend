package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Paciente;
import com.santiagobruno.trabajointegrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public void agregarPaciente(Paciente paciente) {
        repository.save(paciente);
    }

    public void modificarPaciente(String nombre, String apellido, String dni) {
        var pacienteExistente = repository.findByDni(dni);
        pacienteExistente.setNombre(nombre);
        pacienteExistente.setApellido(apellido);
        repository.save(pacienteExistente);
    }

    public void eliminarPaciente(String dni) {
        repository.deleteByDni(dni);
    }

    public Paciente buscarPaciente(String dni) {
        return repository.findByDni(dni);
    }

    public List<Paciente> listarPacientes() {
        return repository.findAll();
    }

}
