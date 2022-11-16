package com.santiagobruno.trabajointegrador.service;


import com.santiagobruno.trabajointegrador.model.Odontologo;
import com.santiagobruno.trabajointegrador.repository.OdontologoDAOH2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDAOH2Test {

    @Test
    @DisplayName("WHEN un nuevo odontologo es registrado en el sistema THEN la base de datos debe persistir el mismo odontologo")
    void test1() {
        //GIVEN
        var odontologo = new Odontologo("cerati", "gustavo", "qrt789");
        var dao = new OdontologoDAOH2();

        //WHEN
        dao.agregar(odontologo);

        //THEN
        var select = dao.buscar("qrt789");

        assertEquals(odontologo, select);

    }


    @Test
    @DisplayName("WHEN se listan los odontologos registrados en el sistema THEN la base de datos debe devolver un array con todos ellos")
    void test2() {
        //GIVEN
        var odontologos = new ArrayList<Odontologo>();

        var odontologo = new Odontologo("cerati", "gustavo", "qrt789");
        var odontologo1 = new Odontologo("charly", "garcia", "vid213");
        var odontologo2 = new Odontologo("luis", "perez", "cod234");
        var odontologo3 = new Odontologo("nicolas", "lopez", "rtx456");

        odontologos.add(odontologo);
        odontologos.add(odontologo1);
        odontologos.add(odontologo2);
        odontologos.add(odontologo3);

        var dao = new OdontologoDAOH2();

        //WHEN
        dao.agregar(odontologo1);
        dao.agregar(odontologo2);
        dao.agregar(odontologo3);

        //THEN
        var select = dao.listar();

        assertEquals(odontologos, select);

    }


    @Test
    @DisplayName("WHEN se eliminan odontologos registrados en el sistema THEN la base de datos debe dejar de persistir sus datos")
    void test3() {
        //GIVEN
        var odontologos = new ArrayList<>();
        var dao = new OdontologoDAOH2();

        //WHEN
        dao.eliminar("qrt789");
        dao.eliminar("rtx456");
        dao.eliminar("cod234");
        dao.eliminar("vid213");

        //THEN
        var select = dao.listar();

        assertEquals(odontologos, select);

    }


}