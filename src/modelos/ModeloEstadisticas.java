package modelos;

public class ModeloEstadisticas {

    private Integer id_equipo;
    private Integer puntos;
    private Integer jugados;
    private Integer goles_favor;
    private Integer goles_contra;

    public ModeloEstadisticas(Integer id_equipo, Integer puntos, Integer jugados, Integer goles_favor, Integer goles_contra) {
        this.id_equipo = id_equipo;
        this.puntos = puntos;
        this.jugados = jugados;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
    }

    public ModeloEstadisticas() {
        this.id_equipo = 0;
        this.puntos = 0;
        this.jugados = 0;
        this.goles_contra = 0;
        this.goles_favor = 0;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getJugados() {
        return jugados;
    }

    public void setJugados(Integer jugados) {
        this.jugados = jugados;
    }

    public Integer getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(Integer goles_favor) {
        this.goles_favor = goles_favor;
    }

    public Integer getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(Integer goles_contra) {
        this.goles_contra = goles_contra;
    }
}
