package controllers;

import clases.Partido;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PartidoGrupoController implements Initializable {

    @FXML
    Label labelLocal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPartido(int partido) {
        this.labelLocal.setText("Local " + String.valueOf(partido));
    }

    @FXML
    public void detallesPartido() {

    }
}
