package mysql.dao;

import dao.exception.DAOException;
import util.ReadIni;

import java.sql.*;

public final class MySQLdb {

    private static Connection conn = null;

    private static final String ERROR = "Error SQL: ";

    private MySQLdb() {
        throw new IllegalStateException("Esta clase no se puede instanciar");
    }

    static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/mundial2018",
                        ReadIni.getDbUser(ReadIni.FILENAME), ReadIni.getDbPassword(ReadIni.FILENAME));
            } catch (SQLException e) {
                e.getMessage();
            }
        }

        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    static void closeResources(PreparedStatement ps, ResultSet rs) throws DAOException{
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new DAOException(ERROR, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new DAOException(ERROR, ex);
            }
        }
    }

    static void closePreparedStatement(PreparedStatement ps) throws DAOException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new DAOException(ERROR, ex);
            }
        }
    }
}
