package mysql.dao;

import dao.JugadorDAO;
import dao.exception.DAOException;
import modelos.ModeloJugador;
import modelos.Posicion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLJugadorDAO  implements JugadorDAO {
    private static final String OBTENER = "SELECT nombre, dorsal, fecha_nacimiento, posicion FROM jugador WHERE id_jugador = ?";
    private static final String OBTENER_POR_EQUIPO = "SELECT id_jugador, nombre, dorsal, posicion, fecha_nacimiento FROM jugador WHERE id_equipo=?";
    private static final String OBTENER_TODOS = "SELECT nombre, dorsal, apodo, fecha_nacimiento FROM jugador;";

    @Override
    public ModeloJugador obtener(Integer id)  throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ModeloJugador jugador = null;

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                jugador = convertir(rs);
            }
        } catch(SQLException ex) {
            throw new DAOException("Error SQL al obtener el jugador", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return jugador;
    }

    @Override
    public ArrayList<ModeloJugador> obtenerTodosPorEquipo(Integer id)  throws DAOException{
        PreparedStatement ps = null;
        ResultSet data = null;

        ArrayList<ModeloJugador> jugadores = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER_POR_EQUIPO);
            ps.setInt(1, id);

            data = ps.executeQuery();

            while(data.next()) {
                jugadores.add(convertir(data));
            }
        } catch (SQLException e) {
            throw new DAOException("Error SQL al obtener los jugadores", e);
        } finally {
            MySQLdb.closeResources(ps, data);
        }

        return jugadores;
    }

    @Override
    public ArrayList<ModeloJugador> obtenerTodos() throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ModeloJugador> jugadores = new ArrayList<>();

        try {
            ps = MySQLdb.getConnection().prepareStatement(OBTENER_TODOS);
            rs = ps.executeQuery();

            while (rs.next()) {
                jugadores.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL al obtener todos los jugadores", ex);
        } finally {
            MySQLdb.closeResources(ps, rs);
        }

        return jugadores;
    }

    private ModeloJugador convertir(ResultSet data) throws SQLException {
        ModeloJugador jugador = new ModeloJugador();
        jugador.setId(data.getInt("id_jugador"));
        jugador.setDorsal(data.getInt("dorsal"));
        jugador.setNombre(data.getString("nombre"));
        jugador.setFechaNacimiento(data.getDate("fecha_nacimiento"));

        Integer posicion = data.getInt("posicion");
        if (posicion.equals(Posicion.DEFENSA.valor())) {
            jugador.setPosicion(Posicion.DEFENSA);
        }
        switch (data.getInt("posicion")) {
            case 1:
                jugador.setPosicion(Posicion.PORTERO);
                break;
            case 2:
                jugador.setPosicion(Posicion.DEFENSA);
                break;
            case 3:
                jugador.setPosicion(Posicion.CENTROCAMPISTA);
                break;
            case 4:
                jugador.setPosicion(Posicion.DELANTERO);
                break;
            default:
                jugador.setPosicion(Posicion.SIN_DEFINIR);
                break;
        }

        return jugador;
    }

}
