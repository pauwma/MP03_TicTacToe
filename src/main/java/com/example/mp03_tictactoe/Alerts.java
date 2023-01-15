package com.example.mp03_tictactoe;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {

    // ? Alerta mostrada al indicar que queremos abandonar la partida.
    public static Boolean Abandonar_Partida() {
        Boolean respuesta = null;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Deseas abandonar la partida?");
        alert.setHeaderText("(Si abandonas la partida, obtendrás una derrota.\nY el otro jugador sumará una victoria).");
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
}
