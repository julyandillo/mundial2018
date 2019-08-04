package util;

import javafx.scene.control.Alert;

public class ErrorMessages {

    private static Alert mensaje = null;

    private ErrorMessages() {
        mensaje = new Alert(Alert.AlertType.NONE);
    }

    public static Alert mostrar(Alert.AlertType tipo, String texto) {
        if (mensaje == null) {
            new ErrorMessages();
        }

        mensaje.setTitle("Mundial Rusia 2018");
        mensaje.setAlertType(tipo);
        mensaje.setContentText(texto);

        return mensaje;
    }
}
