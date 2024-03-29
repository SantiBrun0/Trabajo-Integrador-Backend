package com.santiagobruno.trabajointegrador.repository;

import com.santiagobruno.trabajointegrador.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TurnoRepository extends JpaRepository<Turno, String> {

    Turno findByCodigo(String codigo);

    @Transactional
    void deleteByCodigo(String codigo);

}
