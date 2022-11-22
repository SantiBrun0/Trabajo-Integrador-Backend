package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Turno;
import com.santiagobruno.trabajointegrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Service
public class TurnoService {

    private final TurnoRepository repository;

    public void agregarTurno(Turno turno) {
        repository.save(turno);
    }

    public void modificarTurno(LocalDateTime fechaNueva, String codigo) {
        var turnoExistente = repository.findByCodigo(codigo);
        turnoExistente.setFecha(fechaNueva);
        repository.save(turnoExistente);
    }

    public void eliminarTurno(String codigo) {
        repository.deleteByCodigo(codigo);
    }

    public Turno buscarTurno(String codigo) {
        return repository.findByCodigo(codigo);
    }

    public List<Turno> listarTurnos() {
        return repository.findAll();
    }

}
