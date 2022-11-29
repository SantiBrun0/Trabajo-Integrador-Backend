package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Turno;
import com.santiagobruno.trabajointegrador.entity.TurnoDTO;
import com.santiagobruno.trabajointegrador.repository.OdontologoRepository;
import com.santiagobruno.trabajointegrador.repository.PacienteRepository;
import com.santiagobruno.trabajointegrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Service
public class TurnoService {

    private final TurnoRepository repository;
    private final OdontologoRepository odontologoRepository;
    private final PacienteRepository pacienteRepository;

    public void agregarTurno(TurnoDTO turnoDTO) {
        var turno = new Turno();
        turno.setCodigo(turnoDTO.getCodigo());
        turno.setFecha(turnoDTO.getFecha());

        var odontologo = odontologoRepository.findByMatricula(turnoDTO.getMatricula());
        turno.setOdontologo(odontologo);

        var paciente = pacienteRepository.findByDni(turnoDTO.getDni());
        turno.setPaciente(paciente);

        repository.save(turno);
    }

    public void modificarTurno(String codigo, LocalDateTime fechaNueva) {
        var turnoExistente = repository.findByCodigo(codigo);
        turnoExistente.setFecha(fechaNueva);
        repository.save(turnoExistente);
    }

    public void eliminarTurno(String codigo) {
        repository.deleteByCodigo(codigo);
    }

    public Turno buscarTurno(String codigo) { return repository.findByCodigo(codigo); }

    public List<Turno> listarTurnos() {
        return repository.findAll();
    }

}
