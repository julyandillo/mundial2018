package mysql.dao;

import dao.EquipoDAO;
import dao.exception.DAOException;
import modelos.ModeloEquipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLEquipoDAO implements EquipoDAO {

    private static final String OBTENER_EQUIPO = "SELECT nombre, seleccionador, bandera, grupo FROM equipo WHERE id_equipo = ?";
    private static final String OBTENER_TODOS = "SELECT id_equipo, seleccionador, bandera, nombre, grupo FROM equipo";

    @Override
    public ModeloEquipo obtener(Integer id) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ModeloEquipo equipo = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER_EQUIPO);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if(rs.next()) {
                equipo = new ModeloEquipo(id, rs.getString("nombre"), rs.getString("seleccionador"),
                        rs.getString("bandera"));
            }
        } catch(SQLException ex) {
            throw new DAOException("Error SQL al obtener el equipo", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return equipo;
    }

    @Override
    public List<ModeloEquipo> obtenerTodos() throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<ModeloEquipo> equipo = new ArrayList<>();


        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER_EQUIPO);

            rs = ps.executeQuery();

            while(rs.next()) {
                equipo.add(new ModeloEquipo(rs.getInt("id_equipo"), rs.getString("nombre"),
                        rs.getString("seleccionador"), rs.getString("bandera")));
            }
        } catch(SQLException ex) {
            throw new DAOException("Error SQL al obtener los equipos", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return equipo;
    }
}
