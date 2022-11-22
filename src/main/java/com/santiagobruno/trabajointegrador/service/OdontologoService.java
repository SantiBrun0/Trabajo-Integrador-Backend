package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Odontologo;
import com.santiagobruno.trabajointegrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OdontologoService {

    private final OdontologoRepository repository;

    public void agregarOdontologo(Odontologo odontologo) {
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
