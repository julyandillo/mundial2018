package controllers;

import clases.Equipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import util.ErrorMessages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GruposController implements Initializable {

    @FXML
    private ComboBox comboBoxGrupos;

    @FXML
    private FlowPane panelPartidos;

    @FXML
    private TableView tablaGrupo;

    @FXML
    private TableColumn<Equipo, String> equipo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaGrupo.setVisible(false);

        ObservableList<String> opciones = FXCollections.observableArrayList(
                "Grupo A", "Grupo B", "Grupo C", "Grupo D", "Grupo E", "Grupo F", "Grupo G", "Grupo H"
        );
        comboBoxGrupos.setItems(opciones);

        comboBoxGrupos.getSelectionModel().selectedItemProperty().addListener(((
                observable, oldValue, newValue) -> cargarGrupo(String.valueOf(newValue).charAt(6)))
        );
    }

    private void cargarGrupo(char grupo) {
        /*
        try {
            ArrayList<Equipo> equipos = DAOManager.getGrupoDAO().getGrupo(grupo);
            tablaGrupo.setVisible(true);
        } catch (DAOException ex) {
            ErrorMessages.mostrar(Alert.AlertType.ERROR, ex.getMensaje());
        }
        */
        tablaGrupo.setVisible(true);
        try {
            for(int i=0; i<8; i++) {
                FXMLLoader loaderPartido = new FXMLLoader();
                loaderPartido.setLocation(getClass().getResource("/vistas/partidoGrupo.fxml"));

                panelPartidos.getChildren().add(loaderPartido.load());
                PartidoGrupoController controller = loaderPartido.getController();
                controller.setPartido(i);
            }

        } catch (IOException ex) {
            ErrorMessages.mostrar(Alert.AlertType.ERROR, "No se pueden cargar los partidos del grupo.\n" + ex.getMessage());
        }
    }
}
