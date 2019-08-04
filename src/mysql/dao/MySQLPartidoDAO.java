package mysql.dao;

import dao.PartidoDAO;
import dao.exception.DAOException;
import modelos.ModeloPartido;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLPartidoDAO implements PartidoDAO {

    private static final String GUARDAR = "UPDATE partido SET id_equipo_local=?, id_equipo_visitante=?, goles_local=?," +
            "goles_visitante=?, ganador=?, penaltis=? WHERE id_partido = ?";

    @Override
    public ModeloPartido obtener(Integer id_partido) throws DAOException {
        return null;
    }

    @Override
    public ArrayList<ModeloPartido> obtenerPorFase(char fase) throws DAOException {
        return null;
    }

    @Override
    public boolean guardar(ModeloPartido partido) throws DAOException {
        PreparedStatement ps = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(GUARDAR);
            ps.setInt(1, partido.getIdEquipoLocal());
            ps.setInt(2, partido.getIdEquipoVisitante());
            ps.setInt(3, partido.getGolesEquipoLocal());
            ps.setInt(4, partido.getGolesEquipoVisitante());
            ps.setInt(5, partido.getIdEquipoGanador());
            ps.setBoolean(6, partido.isPenaltis());
            ps.setInt(7, partido.getIdPartido());

            if(ps.executeUpdate() != 1) {
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL guardando el partido", ex);
        } finally {
            MySQLdb.closePreparedStatement(ps);
        }

        return true;
    }
}
