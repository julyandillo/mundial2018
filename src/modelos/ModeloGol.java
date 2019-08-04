package modelos;

public class ModeloGol {

    private Integer id_gol;
    private Integer minuto;
    private boolean penalti;
    private boolean falta;
    private boolean propia_meta;
    private Integer id_jugador;
    private Integer id_partido;

    public ModeloGol() {
        this.id_gol = null;
        this.minuto = null;
        this.penalti = false;
        this.falta = false;
        this.propia_meta = false;
        this.id_partido = null;
        this.id_jugador = null;
    }

    public ModeloGol(Integer id_gol, Integer minuto, boolean penalti, boolean falta, boolean propia_meta, Integer id_jugador, Integer id_partido) {
        this.id_gol = id_gol;
        this.minuto = minuto;
        this.penalti = penalti;
        this.falta = falta;
        this.propia_meta = propia_meta;
        this.id_jugador = id_jugador;
        this.id_partido = id_partido;
    }

    public Integer getId_gol() {
        return id_gol;
    }

    public void setId_gol(Integer id_gol) {
        this.id_gol = id_gol;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public boolean isPenalti() {
        return penalti;
    }

    public void setPenalti(boolean penalti) {
        this.penalti = penalti;
    }

    public boolean isFalta() {
        return falta;
    }

    public void setFalta(boolean falta) {
        this.falta = falta;
    }

    public boolean isPropia_meta() {
        return propia_meta;
    }

    public void setPropia_meta(boolean propia_meta) {
        this.propia_meta = propia_meta;
    }

    public Integer getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Integer id_jugador) {
        this.id_jugador = id_jugador;
    }

    public Integer getId_partido() {
        return id_partido;
    }

    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
    }
}
