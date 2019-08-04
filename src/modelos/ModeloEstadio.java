package modelos;

public class ModeloEstadio {

    private Integer id_estadio;
    private String nombre;
    private String ciudad;
    private Integer capacidad;
    private String imagen; //ruta de la imagen

    public ModeloEstadio() {
        this.id_estadio = 0;
        this.nombre = "";
        this.ciudad = "";
        this.capacidad = 0;
        this.imagen = "";
    }

    public ModeloEstadio(Integer id, String nombre, String ciudad, Integer capacidad, String imagen) {
        this.id_estadio = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.imagen = imagen;
        this.capacidad = capacidad;
    }

    public Integer getId_estadio() {
        return id_estadio;
    }

    public void setId_estadio(Integer id_estadio) {
        this.id_estadio = id_estadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
