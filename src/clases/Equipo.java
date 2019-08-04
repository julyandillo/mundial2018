package clases;

import dao.DAOManager;
import dao.exception.DAOException;
import modelos.ModeloEquipo;
import modelos.ModeloEstadisticas;
import modelos.ModeloJugador;
import java.util.ArrayList;

public class Equipo extends ModeloEquipo {

    private ArrayList<ModeloJugador> jugadores;
    private ModeloEstadisticas estadisticas;

    public Equipo() {
        super();
        this.jugadores = new ArrayList<>();
        this.estadisticas = new ModeloEstadisticas();
    }

    public Equipo(Integer id) throws DAOException {
        super();

        ModeloEquipo equipo = DAOManager.getEquipoDAO().obtener(id);

        this.setBandera(equipo.getBandera());
        this.setIdEquipo(equipo.getIdEquipo());
        this.setNombre(equipo.getNombre());
        this.setSeleccionador(equipo.getSeleccionador());
        this.setGrupo(equipo.getGrupo());

        this.estadisticas = DAOManager.getEstadisticasDAO().getEstadisticas(id);

        this.jugadores = DAOManager.getJugadorDAO().obtenerTodosPorEquipo(id);
    }

    public ArrayList<ModeloJugador> getJugadores() {
        return this.jugadores;
    }

    public ModeloEstadisticas getEstadisticas() { return this.estadisticas; }
}
