package modelos;

import java.util.Date;

public class ModeloJugador {

    private Integer Id = null;

    private String nombre;

    private Posicion posicion;

    private Integer dorsal;

    private Date fechaNacimiento;

    public ModeloJugador(Integer id, String nombre, Posicion posicion, Integer dorsal, Date fechaNacimiento) {
        this.Id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.fechaNacimiento = fechaNacimiento;
        this.posicion = posicion;
    }

    public ModeloJugador() {
        this.Id = 0;
        this.nombre = null;
        this.dorsal = 0;
        this.fechaNacimiento = null;
        this.posicion = null;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}
