package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Turno;
import com.santiagobruno.trabajointegrador.repository.OdontologoRepository;
import com.santiagobruno.trabajointegrador.repository.PacienteRepository;
import com.santiagobruno.trabajointegrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Service
public class TurnoService {

    private final TurnoRepository repository;
    private final OdontologoRepository odontologoRepository;
    private final PacienteRepository pacienteRepository;

    public void agregarTurno(String dni, String matricula, Date fecha) {
        var turno = new Turno();
        turno.setFecha(fecha);

        var odontologo = odontologoRepository.findByMatricula(matricula);
        turno.setOdontologo(odontologo);

        var paciente = pacienteRepository.findByDni(dni);
        turno.setPaciente(paciente);

        repository.save(turno);
    }

    public void modificarTurno(Date fechaNueva, Long id) {
        var turnoExistente = repository.findById(id);
        turnoExistente.setFecha(fechaNueva);
        repository.save(turnoExistente);
    }

    public void eliminarTurno(Long id) {
        repository.deleteById(id);
    }

    public Turno buscarTurno(Long id) {
        return repository.findById(id);
    }

    public List<Turno> listarTurnos() {
        return repository.findAll();
    }

}
