package com.santiagobruno.trabajointegrador.controller;


import com.santiagobruno.trabajointegrador.model.Odontologo;
import com.santiagobruno.trabajointegrador.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@AllArgsConstructor
public class OdontologoController {

    private final OdontologoService service;

    @PostMapping("/odontologo")
    public ResponseEntity<String> agregarOdontologo(@RequestBody Odontologo odontologo) {
        if (service.listarOdontologos().contains(odontologo)) return new ResponseEntity<>("El odontologo que intenta agregar ya existe", null, HttpStatus.BAD_REQUEST);
        if (odontologo.matricula().isEmpty() || odontologo.nombre().isEmpty() || odontologo.apellido().isEmpty()) return new ResponseEntity<>("Error al agregar el odontologo, ingrese datos correctos", null, HttpStatus.BAD_REQUEST);

        service.agregarOdontologo(odontologo);
        return new ResponseEntity<>("Odontologo agregado con éxito", null, HttpStatus.CREATED);
    }

    @PutMapping("/odontologo")
    public ResponseEntity<String> modificarOdontologo(@RequestBody Odontologo odontologo) {
        if(Objects.isNull(service.buscarOdontologo(odontologo.matricula()))) return new ResponseEntity<>("El odontologo a modificar no existe", null, HttpStatus.NOT_FOUND);

        service.modificarOdontologo(odontologo.nombre(), odontologo.apellido(), odontologo.matricula());
        return new ResponseEntity<>("Odontologo modificado con éxito", null, HttpStatus.OK);
    }

    @DeleteMapping("/odontologo/{matricula}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable String matricula) {
        if(Objects.isNull(service.buscarOdontologo(matricula))) return new ResponseEntity<>("El odontologo a eliminar no existe", null, HttpStatus.NOT_FOUND);

        service.eliminarOdontologo(matricula);
        return new ResponseEntity<>("Odontologo eliminado con éxito", null, HttpStatus.OK);
    }

    @GetMapping("/odontologo/{matricula}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable String matricula) {
        if(Objects.isNull(service.buscarOdontologo(matricula))) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.buscarOdontologo(matricula), null, HttpStatus.OK);
    }

    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> listarOdontologos() {
        if(service.listarOdontologos().isEmpty()) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.listarOdontologos(), null, HttpStatus.OK);
    }

}
