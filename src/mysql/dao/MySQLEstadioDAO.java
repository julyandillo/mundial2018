package mysql.dao;

import dao.EstadioDAO;
import dao.exception.DAOException;
import modelos.ModeloEstadio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLEstadioDAO implements EstadioDAO {

    private static final String OBTENER_TODOS = "SELECT id_estadio, nombre, ciudad, capacidad, imagen FROM estadio";
    private static final String OBTENER = "SELECT nombre, ciudad, capacidad, imagen FROM estadio WHERE id_estadio = ?";

    @Override
    public ModeloEstadio obtener(Integer id) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ModeloEstadio estadio = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if(rs.next()) {
                estadio = new ModeloEstadio(id, rs.getString("nombre"), rs.getString("capacidad"),
                        rs.getInt("capacidad"), rs.getString("imagen"));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener el estadio", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return estadio;
    }

    @Override
    public ArrayList<ModeloEstadio> obtenerTodos() throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ModeloEstadio> estadios = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER_TODOS);

            rs = ps.executeQuery();

            while (rs.next()) {
                estadios.add(new ModeloEstadio(rs.getInt("id_estadio"), rs.getString("nombre"),
                        rs.getString("capacidad"), rs.getInt("capacidad"),
                        rs.getString("imagen")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener los estadios", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return estadios;
    }
}
