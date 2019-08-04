package dao;

import dao.exception.DAOException;
import modelos.ModeloGol;

import java.util.ArrayList;

public interface GolDAO  {

    boolean guardar(ModeloGol gol) throws DAOException;

    ArrayList<ModeloGol> getGolesPorPartido(Integer id_partido) throws DAOException;

    ArrayList<ModeloGol> getGolesPorJugador(Integer id_jugador) throws DAOException;

    ArrayList<ModeloGol> getGolesPorPartidoEquipo(Integer id_equipo, Integer id_partido) throws DAOException;
}
