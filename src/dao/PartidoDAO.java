package dao;

import dao.exception.DAOException;
import modelos.ModeloPartido;

import java.util.ArrayList;

public interface PartidoDAO {

    ModeloPartido obtener(Integer id_partido) throws DAOException;

    ArrayList<ModeloPartido> obtenerPorFase(char fase) throws DAOException;

    boolean guardar(ModeloPartido partido) throws DAOException;

}
