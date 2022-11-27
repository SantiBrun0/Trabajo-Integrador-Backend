package com.santiagobruno.trabajointegrador.controller;

import com.santiagobruno.trabajointegrador.entity.Turno;
import com.santiagobruno.trabajointegrador.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class TurnoController {

    private final TurnoService service;

    @PostMapping("/turno")
    public ResponseEntity<String> agregarTurno(@RequestBody String fechaString, @RequestBody String matricula, @RequestBody String dni) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        var fechaDate = formatter.parse(fechaString);

        if (Objects.isNull(fechaDate) || Objects.isNull(matricula) || Objects.isNull(dni)) return new ResponseEntity<>("Error al agregar el turno, ingrese datos correctos", null, HttpStatus.BAD_REQUEST);

        service.agregarTurno(dni, matricula, fechaDate);
        return new ResponseEntity<>("Turno agregado con éxito", null, HttpStatus.CREATED);
    }

    @PutMapping("/turno")
    public ResponseEntity<String> modificarTurno(@RequestBody Turno turno) {
        if(Objects.isNull(service.buscarTurno(turno.getId()))) return new ResponseEntity<>("El turno a modificar no existe", null, HttpStatus.NOT_FOUND);

        service.modificarTurno(turno.getFecha(), turno.getId());
        return new ResponseEntity<>("Turno modificado con éxito", null, HttpStatus.OK);
    }

    @DeleteMapping("/turno/{codigo}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) {
        if(Objects.isNull(service.buscarTurno(id))) return new ResponseEntity<>("El turno a eliminar no existe", null, HttpStatus.NOT_FOUND);

        service.eliminarTurno(id);
        return new ResponseEntity<>("Turno eliminado con éxito", null, HttpStatus.OK);
    }

    @GetMapping("/turno/{codigo}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id) {
        if(Objects.isNull(service.buscarTurno(id))) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.buscarTurno(id), null, HttpStatus.OK);
    }

    @GetMapping("/turnos")
    public ResponseEntity<List<Turno>> listarTurnos() {
        if(service.listarTurnos().isEmpty()) return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(service.listarTurnos(), null, HttpStatus.OK);
    }

}
