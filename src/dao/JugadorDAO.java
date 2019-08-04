package dao;

import dao.exception.DAOException;
import modelos.ModeloJugador;

import java.util.ArrayList;

public interface JugadorDAO extends DAO<ModeloJugador, Integer> {

    @Override
    ModeloJugador obtener(Integer id) throws DAOException;

    ArrayList<ModeloJugador> obtenerTodosPorEquipo(Integer id) throws DAOException;

}
