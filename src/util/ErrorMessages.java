package util;

import javafx.scene.control.Alert;

public class ErrorMessages {

    private static Alert mensaje = null;

    /**
     * Añadiendo un constructor privado, se evita que java cree uno publico por defecto al no encontrar
     * ninguno definido en la clase
     */
    private ErrorMessages() {
        throw new IllegalStateException("Esta clase no se puede instanciar");
    }

    public static Alert mostrar(Alert.AlertType tipo, String texto) {
        if (mensaje == null) {
            mensaje = new Alert(Alert.AlertType.NONE);
        }

        mensaje.setTitle("Mundial Rusia 2018");
        mensaje.setAlertType(tipo);
        mensaje.setContentText(texto);

        return mensaje;
    }
}
