package mysql.dao;

import dao.EstadisticasDAO;
import dao.exception.DAOException;
import modelos.ModeloEstadisticas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLEstadisticasDAO implements EstadisticasDAO {

    private static final String OBTENER_POR_EQUIPO = "SELECT puntos, jugados, goles_favor, goles_contra FROM estadisticas WHERE id_equipo = ?";
    private static final String EXISTE = "SELECT * FROM estadisticas WHERE id_equipo = ?";
    private static final String GUARDAR = "INSERT INTO estadisticas (puntos, jugados, goles_favor, goles_contra, id_equipo) VALUES (?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE estadisticas SET puntos = ?, jugados = ?, goles_favor = ?, goles_contra = ? WHERE id_equipo = ?";


    @Override
    public ModeloEstadisticas getEstadisticas(Integer id_equipo) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ModeloEstadisticas estadisticas = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER_POR_EQUIPO);
            ps.setInt(1, id_equipo);

            rs = ps.executeQuery();

            if (rs.next()) {
                estadisticas = new ModeloEstadisticas(id_equipo, rs.getInt("puntos"), rs.getInt("jugados"),
                        rs.getInt("goles_favor"), rs.getInt("goles_contra"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener las estadisticas", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return estadisticas;
    }

    @Override
    public void actualizarEstadisticas(ModeloEstadisticas estadisticas) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        PreparedStatement actualizar = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(EXISTE);
            ps.setInt(1, estadisticas.getId_equipo());

            rs = ps.executeQuery();

            if (rs.next()) {
                actualizar = MySQLdb.getConnection().prepareStatement(ACTUALIZAR);

            } else {
                actualizar = MySQLdb.getConnection().prepareStatement(GUARDAR);
            }

            actualizar.setInt(1, estadisticas.getPuntos());
            actualizar.setInt(2, estadisticas.getJugados());
            actualizar.setInt(3, estadisticas.getGoles_favor());
            actualizar.setInt(3, estadisticas.getGoles_contra());

            actualizar.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Error SQL al actualizar las estadisticas", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
            MySQLdb.closePreparedStatement(actualizar);
        }
    }
}
