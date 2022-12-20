package com.example.mp03_tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class MainController {

    // ? Botones cambio de tema.
    @FXML
    private RadioButton whiteTheme;
    @FXML
    private RadioButton darkTheme;


    // ? Método cambio de tema
    public void changeTheme(ActionEvent event){
        if (whiteTheme.isSelected()){
            // TODO Añadir cambio de CSS
        } else if (darkTheme.isSelected()) {
            // TODO Añadir cambio de CSS
        }
    }



}