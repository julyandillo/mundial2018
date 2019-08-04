package modelos;

public enum Posicion {

    PORTERO("Portero", 1),
    DEFENSA("Defensa", 2),
    CENTROCAMPISTA("Centrocampista", 3),
    DELANTERO("Delantero", 4),
    SIN_DEFINIR("-", 0);

    private final String nombre;
    private final Integer valor;

    Posicion(String nombre, Integer valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String nombre() {
        return this.nombre;
    }

    public Integer valor() {
        return this.valor;
    }

}
