package dao;

import dao.exception.DAOException;

import java.util.List;

public interface DAO<T, K> {

    T obtener(K id) throws DAOException;

    List<T> obtenerTodos() throws DAOException;
}
