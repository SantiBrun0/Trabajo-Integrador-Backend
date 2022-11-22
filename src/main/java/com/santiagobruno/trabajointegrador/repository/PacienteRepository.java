package com.santiagobruno.trabajointegrador.repository;

import com.santiagobruno.trabajointegrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    Paciente findByDni(String dni);

    @Transactional
    void deleteByDni(String dni);

}
