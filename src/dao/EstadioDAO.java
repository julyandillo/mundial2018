package dao;

import dao.exception.DAOException;
import modelos.ModeloEstadio;

import java.util.ArrayList;

public interface EstadioDAO extends DAO<ModeloEstadio, Integer> {
    @Override
    ModeloEstadio obtener(Integer id) throws DAOException;

    @Override
    ArrayList<ModeloEstadio> obtenerTodos() throws DAOException;
}
