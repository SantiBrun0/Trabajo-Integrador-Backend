package com.santiagobruno.trabajointegrador.controller;

import com.santiagobruno.trabajointegrador.entity.Turno;
import com.santiagobruno.trabajointegrador.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class TurnoController {

    private final TurnoService service;

    @PostMapping("/turno")
    public ResponseEntity<String> agregarTurno(@RequestBody Turno turno){
        if (Objects.nonNull(service.buscarTurno(turno.getCodigo()))) return new ResponseEntity<>("El turno que intenta agregar ya existe", null, HttpStatus.BAD_REQUEST);
        if (Objects.isNull(turno.getOdontologo()) || Objects.isNull(turno.getPaciente()) || Objects.isNull(turno.getFecha())) return new ResponseEntity<>("Error al agregar el turno, ingrese datos correctos", null, HttpStatus.BAD_REQUEST);

        service.agregarTurno(turno);
        return new ResponseEntity<>("Turno agregado con éxito", null, HttpStatus.CREATED);
    }

    @PutMapping("/turno")
    public ResponseEntity<String> modificarTurno(@RequestBody Turno turno) {
        if(Objects.isNull(service.buscarTurno(turno.getCodigo()))) return new ResponseEntity<>("El turno a modificar no existe", null, HttpStatus.NOT_FOUND);

        service.modificarTurno(turno.getFecha(), turno.getCodigo());
        return new ResponseEntity<>("Turno modificado con éxito", null, HttpStatus.OK);
    }

    @DeleteMapping("/turno/{codigo}")
    public ResponseEntity<String> eliminarTurno(@PathVariable String codigo) {
        if(Objects.isNull(service.buscarTurno(codigo))) return new ResponseEntity<>("El turno a eliminar no existe", null, HttpStatus.NOT_FOUND);

        service.eliminarTurno(codigo);
        return new ResponseEntity<>("Turno eliminado con éxito", null, HttpStatus.OK);
    }

    @GetMapping("/turno/{codigo}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable String codigo) {
        if(Objects.isNull(service.buscarTurno(codigo))) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.buscarTurno(codigo), null, HttpStatus.OK);
    }

    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> listarTurnos() {
        if(service.listarTurnos().isEmpty()) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.listarTurnos(), null, HttpStatus.OK);
    }

}
