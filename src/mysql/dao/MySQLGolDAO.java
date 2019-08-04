package mysql.dao;

import dao.GolDAO;
import dao.exception.DAOException;
import modelos.ModeloGol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLGolDAO implements GolDAO {

    private static final String GUARDAR = "INSERT INTO gol (minuto, penalti, propia_meta, falta, id_jugador, id_partido) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GOLES_POR_JUGADOR = "SELECT id_gol, minuto, penalti, propia_meta, falta, id_partido WHERE id_jugador = ?";
    private static final String GOLES_POR_PARTIDO = "SELECT id_gol, minuto, penalti, propia_meta, falta, id_jugador WHERE id_partido = ?";
    private static final String GOLES_POR_EQUIPO_PARTIDO = "SELECT id_gol, minuto, penati, propia_meta, falta, id_jugador " +
            "WHERE id_partido = ? AND id_jugador IN (SELECT id_jugador FROM equipo WHERE id_equipo = ?)";

    @Override
    public boolean guardar(ModeloGol gol) throws DAOException {
        PreparedStatement ps = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(GUARDAR);
            ps.setInt(1, gol.getMinuto());
            ps.setBoolean(2, gol.isPenalti());
            ps.setBoolean(3, gol.isPropia_meta());
            ps.setBoolean(4, gol.isFalta());
            ps.setInt(5, gol.getId_jugador());
            ps.setInt(6, gol.getId_partido());

            if (ps.executeUpdate() == 0) {
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL al guardar el gol", ex);
        } finally {
            MySQLdb.closePreparedStatement(ps);
        }

        return true;
    }

    @Override
    public ArrayList<ModeloGol> getGolesPorPartido(Integer id_partido) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ModeloGol> goles = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(GOLES_POR_PARTIDO);
            ps.setInt(1, id_partido);

            rs = ps.executeQuery();

            while (rs.next()) {
                goles.add(new ModeloGol(rs.getInt("id_gol"), rs.getInt("minuto"),
                        rs.getBoolean("penalti"), rs.getBoolean("falta"), rs.getBoolean("propia_meta"),
                        rs.getInt("id_jugador"), id_partido));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener los goles del partido", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return goles;
    }

    @Override
    public ArrayList<ModeloGol> getGolesPorJugador(Integer id_jugador) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ModeloGol> goles = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(GOLES_POR_JUGADOR);
            ps.setInt(1, id_jugador);

            rs = ps.executeQuery();

            while (rs.next()) {
                goles.add(new ModeloGol(rs.getInt("id_gol"), rs.getInt("minuto"),
                        rs.getBoolean("penalti"), rs.getBoolean("falta"), rs.getBoolean("propia_meta"),
                        id_jugador, rs.getInt("id_partido")));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener los goles del partido", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return goles;
    }

    @Override
    public ArrayList<ModeloGol> getGolesPorPartidoEquipo(Integer id_equipo, Integer id_partido) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ModeloGol> goles = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(GOLES_POR_EQUIPO_PARTIDO);
            ps.setInt(1, id_partido);
            ps.setInt(2, id_equipo);

            rs = ps.executeQuery();

            while (rs.next()) {
                goles.add(new ModeloGol(rs.getInt("id_gol"), rs.getInt("minuto"),
                        rs.getBoolean("penalti"), rs.getBoolean("falta"), rs.getBoolean("propia_meta"),
                        rs.getInt("id_jugador"), id_partido));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener los goles del equipo", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return goles;
    }
}
