package dao;

import mysql.dao.*;
import util.ReadIni;

public class DAOManager {

    private static TypeDAO tipo = TypeDAO.BLANK;

    private DAOManager() {
        throw new IllegalStateException("Utility class cannot be instanced");
    }

    private static void loadTypeDAO() {
        if (tipo == TypeDAO.BLANK) {
            tipo = ReadIni.getTypeDAO(ReadIni.FILENAME);
        }
    }

    static public TypeDAO getDAOType() {
        DAOManager.loadTypeDAO();

        return tipo;
    }

    static public JugadorDAO getJugadorDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL:
                return new MySQLJugadorDAO();
            case XML:
                return null;
            case MSSQL:
                return null;
            case BLANK:
                return null;
            default:
                return new MySQLJugadorDAO();
        }

    }

    static public EquipoDAO getEquipoDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL: return new MySQLEquipoDAO();
            case MSSQL: return null;
            default: return new MySQLEquipoDAO();
        }
    }

    static public EstadioDAO getEstadioDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL: return new MySQLEstadioDAO();
            case MSSQL: return null;
            default: return new MySQLEstadioDAO();
        }
    }

    static public EstadisticasDAO getEstadisticasDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL: return new MySQLEstadisticasDAO();
            case MSSQL: return null;
            default: return new MySQLEstadisticasDAO();
        }
    }

    static public GolDAO getGolDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL: return new MySQLGolDAO();
            case MSSQL: return null;
            default: return new MySQLGolDAO();
        }
    }

    static public PartidoDAO getPartidoDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL: return new MySQLPartidoDAO();
            case MSSQL: return null;
            default: return new MySQLPartidoDAO();
        }
    }

    static public GrupoDAO getGrupoDAO() {
        DAOManager.loadTypeDAO();

        switch (tipo) {
            case MYSQL: return new MySQLGrupoDAO();
            case MSSQL: return null;
            default: return new MySQLGrupoDAO();
        }
    }
}
