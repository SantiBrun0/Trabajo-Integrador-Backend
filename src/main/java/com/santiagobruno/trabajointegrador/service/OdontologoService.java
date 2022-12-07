package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Odontologo;
import com.santiagobruno.trabajointegrador.exceptions.OdontologoEmptyException;
import com.santiagobruno.trabajointegrador.exceptions.OdontologoRepeteadException;
import com.santiagobruno.trabajointegrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OdontologoService {

    private final OdontologoRepository repository;

    public void agregarOdontologo(Odontologo odontologo) throws OdontologoRepeteadException, OdontologoEmptyException {
        if (repository.exists(Example.of(odontologo))) throw new OdontologoRepeteadException();
        if (odontologo.getMatricula().isEmpty() || odontologo.getNombre().isEmpty() || odontologo.getApellido().isEmpty()) throw new OdontologoEmptyException();
        repository.save(odontologo);
    }

    public void modificarOdontologo(String nombre, String apellido, String matricula) {
        var odontologoExistente = repository.findByMatricula(matricula);
        odontologoExistente.setNombre(nombre);
        odontologoExistente.setApellido(apellido);
        repository.save(odontologoExistente);
    }

    public void eliminarOdontologo(String matricula) {
        repository.deleteByMatricula(matricula);
    }

    public Odontologo buscarOdontologo(String matricula) {
        return repository.findByMatricula(matricula);
    }

    public List<Odontologo> listarOdontologos() {
        return repository.findAll();
    }


}
