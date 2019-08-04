package dao.exception;

public class DAOException extends Exception {

    private final String mensaje;
    private final String detalles;

    public DAOException(String mensaje, Exception e) {
        this.mensaje = mensaje;
        this.detalles = e.getMessage();
    }

    public String getMensaje() {
        return this.mensaje + "\n" + detalles;
    }
}
