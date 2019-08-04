package modelos;

public class ModeloPartido {

    private Integer id_partido;
    private Integer id_equipo_local;
    private Integer id_equipo_visitante;
    private Integer goles_equipo_local;
    private Integer goles_equipo_visitante;
    private char fase; //grupo o fase del torneo al que pertence el partido
    private boolean penaltis; //si el partido se resuelve en la tanda de penaltis (true) o no (false)
    private Integer id_equipo_ganador;

    public ModeloPartido() {
        this.id_partido = null;
        this.id_equipo_local = null;
        this.id_equipo_visitante = null;
        this.goles_equipo_local = null;
        this.goles_equipo_visitante = null;
        this.fase = '-';
        this.penaltis = false;
    }

    public ModeloPartido(Integer id_partido, Integer id_equipo_local, Integer id_equipo_visitante,
                         Integer goles_equipo_local, Integer goles_equipo_visitante, char fase, boolean penaltis,
                         Integer id_equipo_ganador) {
        this.id_partido = id_partido;
        this.id_equipo_local = id_equipo_local;
        this.id_equipo_visitante = id_equipo_visitante;
        this.goles_equipo_local = goles_equipo_local;
        this.goles_equipo_visitante = goles_equipo_visitante;
        this.fase = fase;
        this.penaltis = penaltis;
        this.id_equipo_ganador = id_equipo_ganador;
    }

    public Integer getIdPartido() {
        return id_partido;
    }

    public void setIdPartido(Integer id_partido) {
        this.id_partido = id_partido;
    }

    public Integer getIdEquipoLocal() {
        return id_equipo_local;
    }

    public void setIdEquipoLocal(Integer id_equipo_local) {
        this.id_equipo_local = id_equipo_local;
    }

    public Integer getIdEquipoVisitante() {
        return id_equipo_visitante;
    }

    public void setIdEquipoVisitante(Integer id_equipo_visitante) {
        this.id_equipo_visitante = id_equipo_visitante;
    }

    public Integer getGolesEquipoLocal() {
        return goles_equipo_local;
    }

    public void setGolesEquipoLocal(Integer goles_equipo_local) {
        this.goles_equipo_local = goles_equipo_local;
    }

    public Integer getGolesEquipoVisitante() {
        return goles_equipo_visitante;
    }

    public void setGolesEquipoVisitante(Integer goles_equipo_visitante) {
        this.goles_equipo_visitante = goles_equipo_visitante;
    }

    public char getFase() {
        return fase;
    }

    public void setFase(char fase) {
        this.fase = fase;
    }

    public boolean isPenaltis() {
        return penaltis;
    }

    public void setPenaltis(boolean penaltis) {
        this.penaltis = penaltis;
    }

    public Integer getIdEquipoGanador() {
        return id_equipo_ganador;
    }

    public void setIdEquipoGanador(Integer id_equipo_ganador) {
        this.id_equipo_ganador = id_equipo_ganador;
    }
}
