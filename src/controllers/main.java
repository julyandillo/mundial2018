package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import util.ErrorMessages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class main implements Initializable {

    @FXML
    private ImageView logo;

    @FXML
    private BorderPane mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.logo.setImage(new Image("file:resources/logo.png"));
    }

    @FXML
    public void cargarPanelGrupos() {
        try {
            mainPane.setCenter(FXMLLoader.load(getClass().getResource("/vistas/grupos.fxml")));
        } catch (IOException ex) {
            ErrorMessages.mostrar(Alert.AlertType.ERROR,"No se puede cargar el panel de grupos").showAndWait();
        }
    }

    @FXML
    public void cargarPanelEliminatorias() {
        URL url = getClass().getResource("/vistas/eliminatorias.fxml");
        if (url != null) {
            try {
                mainPane.setCenter(FXMLLoader.load(url));
            } catch (IOException ex) {
                ErrorMessages.mostrar(Alert.AlertType.ERROR, "No se puede cargar el panel de eliminatorias").showAndWait();
            }
        } else {
            ErrorMessages.mostrar(Alert.AlertType.ERROR, "No se puede cargar la ruta del fxml").showAndWait();
        }
    }
}
