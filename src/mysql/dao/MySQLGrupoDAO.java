package mysql.dao;

import clases.Equipo;
import dao.GrupoDAO;
import dao.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLGrupoDAO implements GrupoDAO {

    private final String OBTENER = "SELECT id_equipo FROM equipo WHERE grupo = ?";

    @Override
    public ArrayList<Equipo> getGrupo(char idGrupo) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Equipo> grupo = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER);
            ps.setString(1, String.valueOf(idGrupo));
            rs = ps.executeQuery();

            while (rs.next()) {
                grupo.add(new Equipo(rs.getInt("id_equipo")));
            }

        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener el grupo", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return grupo;
    }
}
