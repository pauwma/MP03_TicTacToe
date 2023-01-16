package com.example.mp03_tictactoe;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {

    // ? Alerta mostrada al indicar que queremos abandonar la partida.
    public static Boolean abandonarPartida() {
        Boolean respuesta = null;
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setHeaderText("¿Deseas abandonar la partida?");
        alert.getButtonTypes().setAll(ButtonType.YES,ButtonType.NO);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.YES) {
            respuesta = true;
        }else{
            respuesta=false;
            alert.close();
        }
        return respuesta;
    }

    public static void faltaNombres() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("¡Debes introducir el nombre de los jugadores antes de iniciar partida!");
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();
    }
    public static void nombresIguales() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("¡Los nombres de los jugadores no pueden ser iguales!");
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();
    }
}
