package com.santiagobruno.trabajointegrador.controller;


import com.santiagobruno.trabajointegrador.entity.Paciente;
import com.santiagobruno.trabajointegrador.exceptions.PacienteEmptyException;
import com.santiagobruno.trabajointegrador.exceptions.PacienteRepeteadException;
import com.santiagobruno.trabajointegrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@CrossOrigin(origins="*",exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class PacienteController {

    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);
    private final PacienteService service;

    @PostMapping("/paciente")
    public ResponseEntity<String> agregarPaciente(@RequestBody Paciente paciente){

        try {
            service.agregarPaciente(paciente);
            return new ResponseEntity<>("Paciente agregado con éxito", null, HttpStatus.CREATED);
        } catch (PacienteRepeteadException | PacienteEmptyException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/paciente")
    public ResponseEntity<String> modificarPaciente(@RequestBody Paciente paciente) {
        if(Objects.isNull(service.buscarPaciente(paciente.getDni()))) return new ResponseEntity<>("El paciente a modificar no existe", null, HttpStatus.NOT_FOUND);

        service.modificarPaciente(paciente.getNombre(), paciente.getApellido(), paciente.getDni());
        return new ResponseEntity<>("Paciente modificado con éxito", null, HttpStatus.OK);
    }

    @DeleteMapping("/paciente/{dni}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable String dni) {
        if(Objects.isNull(service.buscarPaciente(dni))) return new ResponseEntity<>("El paciente a eliminar no existe", null, HttpStatus.NOT_FOUND);

        service.eliminarPaciente(dni);
        return new ResponseEntity<>("Paciente eliminado con éxito", null, HttpStatus.OK);
    }

    @GetMapping("/paciente/{dni}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable String dni) {
        if(Objects.isNull(service.buscarPaciente(dni))) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.buscarPaciente(dni), null, HttpStatus.OK);
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        if(service.listarPacientes().isEmpty()) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.listarPacientes(), null, HttpStatus.OK);
    }

}
