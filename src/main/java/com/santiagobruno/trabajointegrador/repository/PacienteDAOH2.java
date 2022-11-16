package com.santiagobruno.trabajointegrador.repository;

import com.santiagobruno.trabajointegrador.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.santiagobruno.trabajointegrador.repository.H2Helper.getConnection;

@Repository
public class PacienteDAOH2 implements IDAO<Paciente> {

    public PacienteDAOH2() {
    }

    private static final Logger logger = LogManager.getLogger(PacienteDAOH2.class);

    private static final String INSERT_PACIENTE = "INSERT INTO pacientes (apellido, nombre, domicilio, dni, fechaAlta) VALUES (?,?,?,?,?)";
    private static final String UPDATE_PACIENTE = "UPDATE pacientes SET nombre = ?, apellido = ? WHERE dni = ?";
    private static final String DELETE_PACIENTE = "DELETE FROM pacientes WHERE dni = ?";
    private static final String SELECT_PACIENTE = "SELECT * FROM pacientes WHERE dni = ?";
    private static final String SELECT_ALL_PACIENTES = "SELECT * FROM pacientes";

    @Override
    public void agregar(Paciente paciente) {

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(INSERT_PACIENTE);
            pstmt.setString(1, paciente.apellido());
            pstmt.setString(2, paciente.nombre());
            pstmt.setString(3, paciente.domicilio());
            pstmt.setString(4, paciente.dni());
            pstmt.setDate(5, paciente.fechaAlta());

            pstmt.execute();
            logger.info("Paciente registrado con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

    }

    @Override
    public void modificar(String nombre, String apellido, String dni) {

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(UPDATE_PACIENTE);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, dni);

            pstmt.execute();
            logger.info("Paciente modificado con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

    }


    @Override
    public void eliminar(String dni) {

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(DELETE_PACIENTE);
            pstmt.setString(1, dni);

            pstmt.execute();
            logger.info("Paciente eliminado con éxito");


        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

    }

    @Override
    public Paciente buscar(String dni) {

        Paciente paciente = null;

        try (var connection = getConnection()) {
            var pstmt = connection.prepareStatement(SELECT_PACIENTE);
            pstmt.setString(1, dni);

            var resultado = pstmt.executeQuery();

            if (resultado.next()) {
                logger.info("Paciente encontrado con éxito, dni: " + dni);
                paciente = new Paciente(resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getDate(6));
            }

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

        return paciente;

    }

    @Override
    public List<Paciente> listar() {

        List<Paciente> pacientes = new ArrayList<>();

        try (var connection = getConnection()) {
            var stmt = connection.createStatement();
            var resultado = stmt.executeQuery(SELECT_ALL_PACIENTES);


            while (resultado.next()) {
                pacientes.add(new Paciente(resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getDate(6)));
            }

            logger.info("Todos los pacientes listados con éxito");

        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e);
        }

        return pacientes;

    }


}
