package com.santiagobruno.trabajointegrador.service;

import com.santiagobruno.trabajointegrador.entity.Odontologo;

import com.santiagobruno.trabajointegrador.repository.OdontologoRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OdontologoServiceTest {

    @Test
    @DisplayName("WHEN se busca un odontologo THEN no se debe retornar un null")
    void test1() {
        //GIVEN
        var repository = mock(OdontologoRepository.class);
        var service = new OdontologoService(repository);

        var odontologo = new Odontologo();
        odontologo.setMatricula("101");
        odontologo.setNombre("test");
        odontologo.setApellido("uno");

        //WHEN
        when(repository.findByMatricula(odontologo.getMatricula())).thenReturn(odontologo);

        //THEN
        assertNotNull(service.buscarOdontologo(odontologo.getMatricula()));

    }

    @Test
    @DisplayName("WHEN se listan los odontologos THEN se debe retornar una List")
    void test2() {
        //GIVEN
        var repository = mock(OdontologoRepository.class);
        var service = new OdontologoService(repository);

        //WHEN
        given(repository.findAll()).willReturn(List.of());

        //THEN
        assertDoesNotThrow(service::listarOdontologos);

    }

}