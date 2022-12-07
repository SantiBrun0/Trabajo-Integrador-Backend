package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Paciente;
import com.santiagobruno.trabajointegrador.exceptions.PacienteEmptyException;
import com.santiagobruno.trabajointegrador.exceptions.PacienteRepeteadException;
import com.santiagobruno.trabajointegrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public void agregarPaciente(Paciente paciente) throws PacienteRepeteadException, PacienteEmptyException {
        if (repository.exists(Example.of(paciente))) throw new PacienteRepeteadException();
        if (paciente.getDni().isEmpty() || paciente.getNombre().isEmpty() || paciente.getApellido().isEmpty()) throw new PacienteEmptyException();
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
