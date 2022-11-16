package com.santiagobruno.trabajointegrador.repository;

import com.santiagobruno.trabajointegrador.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.santiagobruno.trabajointegrador.repository.H2Helper.getConnection;

@Repository
public class OdontologoDAOH2 implements IDAO<Odontologo> {

    public OdontologoDAOH2() {
    }

    private static final Logger logger = LogManager.getLogger(OdontologoDAOH2.class);

    private static final String INSERT_ODONTOLOGO = "INSERT INTO odontologos (apellido, nombre, matricula) VALUES (?,?,?)";
    private static final String UPDATE_ODONTOLOGO = "UPDATE odontologos SET nombre = ?, apellido = ? WHERE matricula = ?";
    private static final String DELETE_ODONTOLOGO = "DELETE FROM odontologos WHERE matricula = ?";
    private static final String SELECT_ODONTOLOGO = "SELECT * FROM odontologos WHERE matricula = ?";
    private static final String SELECT_ALL_ODONTOLOGOS = "SELECT * FROM odontologos";


    @Override
    public void agregar(Odontologo odontologo) {

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(INSERT_ODONTOLOGO);
            pstmt.setString(1, odontologo.apellido());
            pstmt.setString(2, odontologo.nombre());
            pstmt.setString(3, odontologo.matricula());

            pstmt.execute();
            logger.info("Odontologo registrado con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

    }

    @Override
    public void modificar(String nombre, String apellido, String matricula) {

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(UPDATE_ODONTOLOGO);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, matricula);

            pstmt.execute();
            logger.info("Odontologo modificado con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

    }

    @Override
    public void eliminar(String matricula) {

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(DELETE_ODONTOLOGO);
            pstmt.setString(1, matricula);

            pstmt.execute();
            logger.info("Odontologo eliminado con éxito");


        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

    }

    @Override
    public Odontologo buscar(String matricula) {

        Odontologo odontologo = null;

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(SELECT_ODONTOLOGO);
            pstmt.setString(1, matricula);

            var resultado = pstmt.executeQuery();

            if (resultado.next()) {
                logger.info("Odontologo encontrado con éxito, matricula: " + matricula);
                odontologo = new Odontologo(resultado.getString(2), resultado.getString(3), resultado.getString(4));
            }

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

        return odontologo;

    }

    @Override
    public List<Odontologo> listar() {

        List<Odontologo> odontologos = new ArrayList<>();

        try (var connection = getConnection()) {
            var stmt = connection.createStatement();
            var resultado = stmt.executeQuery(SELECT_ALL_ODONTOLOGOS);


            while (resultado.next()) {
                odontologos.add(new Odontologo(resultado.getString(2), resultado.getString(3), resultado.getString(4)));
            }

            logger.info("Todos los odontologos listados con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

        return odontologos;

    }

}
