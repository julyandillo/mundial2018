package dao;

import dao.exception.DAOException;
import modelos.ModeloEquipo;

import java.util.List;

public interface EquipoDAO extends DAO<ModeloEquipo, Integer> {
    @Override
     ModeloEquipo obtener(Integer id) throws DAOException;

    @Override
    List<ModeloEquipo> obtenerTodos() throws DAOException;
}
