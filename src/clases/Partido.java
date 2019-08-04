package clases;

import dao.DAOManager;
import dao.exception.DAOException;
import modelos.ModeloGol;
import modelos.ModeloPartido;

import java.util.ArrayList;

public class Partido extends ModeloPartido{

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Equipo ganador;
    private ArrayList<ModeloGol> golesLocal, golesVisitante;

    public Partido() {
        super();
        equipoVisitante = null;
        equipoLocal = null;
        ganador = null;
        golesVisitante = new ArrayList<>();
        golesLocal = new ArrayList<>();
    }

    public Partido(Integer id_partido) throws DAOException {
        super();

        ModeloPartido modeloPartido = DAOManager.getPartidoDAO().obtener(id_partido);
        this.setFase(modeloPartido.getFase());
        this.setGolesEquipoLocal(modeloPartido.getGolesEquipoLocal());
        this.setGolesEquipoVisitante(modeloPartido.getGolesEquipoVisitante());
        this.setIdEquipoGanador(modeloPartido.getIdEquipoGanador());
        this.setIdEquipoLocal(modeloPartido.getIdEquipoLocal());
        this.setIdEquipoVisitante(modeloPartido.getIdEquipoVisitante());
        this.setIdPartido(id_partido);
        this.setPenaltis(modeloPartido.isPenaltis());

        this.equipoLocal = new Equipo(this.getIdEquipoLocal());
        this.golesLocal = DAOManager.getGolDAO().getGolesPorPartidoEquipo(this.getIdEquipoLocal(), id_partido);

        this.equipoVisitante = new Equipo(this.getIdEquipoVisitante());
        this.golesVisitante = DAOManager.getGolDAO().getGolesPorPartidoEquipo(this.getIdEquipoVisitante(), id_partido);
    }

    public void setGanador(Equipo equipo) {
        this.ganador = equipo;
    }

    public void setPenaltis(boolean penaltis) {
        this.setPenaltis(penaltis);
    }

    public boolean guardar() throws DAOException {
        //las estadisticas se actualizan en el controlador al insertar el resultado
        DAOManager.getEstadisticasDAO().actualizarEstadisticas(this.equipoLocal.getEstadisticas());
        DAOManager.getEstadisticasDAO().actualizarEstadisticas(this.equipoVisitante.getEstadisticas());

        for (ModeloGol gol: golesLocal) {
            DAOManager.getGolDAO().guardar(gol);
        }

        for (ModeloGol gol: golesVisitante) {
            DAOManager.getGolDAO().guardar(gol);
        }

        ModeloPartido modeloPartido = new ModeloPartido(this.getIdPartido(), this.getIdEquipoLocal(), this.getIdEquipoVisitante(),
                this.golesLocal.size(), this.golesVisitante.size(), this.getFase(), this.isPenaltis(), this.ganador.getIdEquipo());

        DAOManager.getPartidoDAO().guardar(modeloPartido);

        return true;
    }

}
