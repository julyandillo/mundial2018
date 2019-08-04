package dao;

import clases.Equipo;
import dao.exception.DAOException;

import java.util.ArrayList;

public interface GrupoDAO {

    ArrayList<Equipo> getGrupo(char grupo) throws DAOException;

}
