package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Turno;
import com.santiagobruno.trabajointegrador.entity.TurnoDTO;
import com.santiagobruno.trabajointegrador.repository.OdontologoRepository;
import com.santiagobruno.trabajointegrador.repository.PacienteRepository;
import com.santiagobruno.trabajointegrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        var turnosOdontologo = odontologo.getTurnos();
        turnosOdontologo.add(turno);

        var turnosPaciente = paciente.getTurnos();
        turnosPaciente.add(turno);

        repository.save(turno);
    }

    public void modificarTurno(TurnoDTO turnoDTO) {
        var turnoExistente = repository.findByCodigo(turnoDTO.getCodigo());
        turnoExistente.setFecha(turnoDTO.getFecha());
        turnoExistente.setOdontologo(odontologoRepository.findByMatricula(turnoDTO.getMatricula()));
        turnoExistente.setPaciente(pacienteRepository.findByDni(turnoDTO.getDni()));
        repository.save(turnoExistente);
    }

    public void eliminarTurno(String codigo) {
        repository.deleteByCodigo(codigo);
    }

    public Turno buscarTurno(String codigo) { return repository.findByCodigo(codigo); }

    public TurnoDTO buscarTurnoDTO(String codigo) {
        var turno = repository.findByCodigo(codigo);

        return new TurnoDTO(turno.getCodigo(), turno.getFecha(), turno.getOdontologo().getMatricula(), turno.getPaciente().getDni());
    }

    public List<TurnoDTO> listarTurnos() {
        var turnos = repository.findAll();
        var turnosDTO = new ArrayList<TurnoDTO>();

        for (Turno turno:turnos) {
            turnosDTO.add(new TurnoDTO(turno.getCodigo(), turno.getFecha(), turno.getOdontologo().getMatricula(), turno.getPaciente().getDni()));
        }

        return turnosDTO;
    }

}
