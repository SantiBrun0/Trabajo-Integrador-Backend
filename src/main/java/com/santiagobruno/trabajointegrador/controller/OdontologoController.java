package com.santiagobruno.trabajointegrador.controller;


import com.santiagobruno.trabajointegrador.entity.Odontologo;
import com.santiagobruno.trabajointegrador.exceptions.OdontologoEmptyException;
import com.santiagobruno.trabajointegrador.exceptions.OdontologoRepeteadException;
import com.santiagobruno.trabajointegrador.service.OdontologoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@CrossOrigin(origins="*",exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class OdontologoController {

    private static final Logger logger = LoggerFactory.getLogger(OdontologoController.class);
    private final OdontologoService service;

    @PostMapping("/odontologo")
    public ResponseEntity<String> agregarOdontologo(@RequestBody Odontologo odontologo) {

        try {
            service.agregarOdontologo(odontologo);
            return new ResponseEntity<>("Odontologo agregado con éxito", null, HttpStatus.CREATED);
        } catch (OdontologoRepeteadException | OdontologoEmptyException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/odontologo")
    public ResponseEntity<String> modificarOdontologo(@RequestBody Odontologo odontologo) {
        if(Objects.isNull(service.buscarOdontologo(odontologo.getMatricula()))) return new ResponseEntity<>("El odontologo a modificar no existe", null, HttpStatus.NOT_FOUND);

        service.modificarOdontologo(odontologo.getNombre(), odontologo.getApellido(), odontologo.getMatricula());
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
