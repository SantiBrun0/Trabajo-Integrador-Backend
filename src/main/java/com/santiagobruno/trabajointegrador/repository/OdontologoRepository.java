package com.santiagobruno.trabajointegrador.repository;

import com.santiagobruno.trabajointegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, String> {

    Odontologo findByMatricula(String matricula);

    @Transactional
    void deleteByMatricula(String matricula);

}
