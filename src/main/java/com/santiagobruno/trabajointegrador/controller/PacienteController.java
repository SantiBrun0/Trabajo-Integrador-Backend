package com.santiagobruno.trabajointegrador.controller;


import com.santiagobruno.trabajointegrador.entity.Paciente;
import com.santiagobruno.trabajointegrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@CrossOrigin(origins="*",exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class PacienteController {

    private final PacienteService service;

    @PostMapping("/paciente")
    public ResponseEntity<String> agregarPaciente(@RequestBody Paciente paciente){
        if (Objects.nonNull(service.buscarPaciente(paciente.getDni()))) return new ResponseEntity<>("El paciente que intenta agregar ya existe", null, HttpStatus.BAD_REQUEST);
        if (paciente.getDni().isEmpty() || paciente.getNombre().isEmpty() || paciente.getApellido().isEmpty()) return new ResponseEntity<>("Error al agregar el paciente, ingrese datos correctos", null, HttpStatus.BAD_REQUEST);

        service.agregarPaciente(paciente);
        return new ResponseEntity<>("Paciente agregado con éxito", null, HttpStatus.CREATED);
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
