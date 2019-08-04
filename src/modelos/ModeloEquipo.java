package modelos;

public class ModeloEquipo {

    private Integer idEquipo;
    private String nombre;
    private String seleccionador;
    private String bandera; //nombre de la imagen
    private char grupo;

    public ModeloEquipo(Integer idEquipo, String nombre, String seleccionador, String bandera) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.seleccionador = seleccionador;
        this.bandera = bandera;
    }

    public ModeloEquipo() {
        this.idEquipo = 0;
        this.nombre = "";
        this.seleccionador = "";
        this.bandera = "";
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeleccionador() {
        return seleccionador;
    }

    public void setSeleccionador(String seleccionador) {
        this.seleccionador = seleccionador;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }
}
