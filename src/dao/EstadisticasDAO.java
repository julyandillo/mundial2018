package dao;

import dao.exception.DAOException;
import modelos.ModeloEstadisticas;

public interface EstadisticasDAO {

    ModeloEstadisticas getEstadisticas(Integer id_equipo) throws DAOException;

    void actualizarEstadisticas(ModeloEstadisticas estadisticas) throws DAOException;
}
