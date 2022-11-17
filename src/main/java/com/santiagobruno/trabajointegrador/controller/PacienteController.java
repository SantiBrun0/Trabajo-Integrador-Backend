package com.santiagobruno.trabajointegrador.controller;


import com.santiagobruno.trabajointegrador.model.Paciente;
import com.santiagobruno.trabajointegrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @PostMapping("/paciente")
    public void agregarPaciente(@RequestBody Paciente paciente) throws Exception {
        if (paciente == null) throw new Exception();

        service.agregarPaciente(paciente);
    }

    @PutMapping("/paciente")
    public void modificarPaciente(@RequestBody Paciente paciente) throws Exception {
        if(service.buscarPaciente(paciente.dni()).dni().isEmpty()) throw new Exception();

        service.modificarPaciente(paciente.nombre(), paciente.apellido(), paciente.dni());
    }

    @DeleteMapping("/paciente/{dni}")
    public void eliminarPaciente(@PathVariable String dni) throws Exception {
        if(service.buscarPaciente(dni).dni().isEmpty()) throw new Exception();

        service.eliminarPaciente(dni);
    }

    @GetMapping("/paciente/{dni}")
    public Paciente buscarPaciente(@PathVariable String dni) throws Exception {
        if(service.buscarPaciente(dni).dni().isEmpty()) throw new Exception();

        return service.buscarPaciente(dni);

    }

    @GetMapping("/pacientes")
    public List<Paciente> listarPacientes() {
        return service.listarPacientes();
    }

}
