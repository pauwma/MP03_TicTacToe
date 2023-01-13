package com.example.mp03_tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static Partida partida = new Partida();

    // ? Botones de control de la partida
    @FXML
    Button btn_start;
    @FXML
    Button btn_stop;

    // ? Botones juego
    @FXML
    Button btn0;
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    Button btn4;
    @FXML
    Button btn5;
    @FXML
    Button btn6;
    @FXML
    Button btn7;
    @FXML
    Button btn8;
    @FXML
    Button tmpBtn;
    List<Button> listBtn = new ArrayList<>(); // ? Lista de botones

    // ? Temas CSS
    String whiteTheme = this.getClass().getResource("white_theme.css").toExternalForm();
    String darkTheme = this.getClass().getResource("dark_theme.css").toExternalForm();

    Image whiteIcon = new Image(this.getClass().getResource("white_theme_icon.png").toExternalForm());
    ImageView whiteView = new ImageView(whiteIcon);
    Image darkIcon = new Image(this.getClass().getResource("dark_theme_icon.png").toExternalForm());
    ImageView darkView = new ImageView(darkIcon);

    private String colorJugador1 = "#3877ff";
    private String colorJugador2 = "#ff3838";

    @FXML
    private Button btnTheme;
    boolean theme; // ? T-Dark F-White

    // ? Selección de modo de juego
    @FXML
    RadioButton btn_gamemode0;
    @FXML
    RadioButton btn_gamemode1;
    @FXML
    RadioButton btn_gamemode2;

    public void gamemodeSelector(){
        if (btn_gamemode0.isSelected()){
            System.out.println("GAMEMODE 1");
        } else if (btn_gamemode1.isSelected()){
            System.out.println("GAMEMODE 2");
        } else if (btn_gamemode2.isSelected()){
            System.out.println("GAMEMODE 3");
        }
    }

    // ? Método de inicio de la partida
    @FXML
    public void startGame(ActionEvent event){
        btn_start = (Button) event.getSource();
        addAllBtn();
        btnEnable();
        partida.setStarted(true);
        partida.setTurno(true);
        btn_start.setDisable(true);
        btn_stop.setDisable(false);
                partida.setTurno(true);

        // TODO Hacer funcionamiento
        System.out.println("START GAME");

    }

    // ? Método de finalización de la partida
    @FXML
    public void stopGame(ActionEvent event) {

        btn_stop = (Button) event.getSource();
        Boolean respuesta = Alerts.Abandonar_Partida();

        if(respuesta) {
            btn_stop.setDisable(true);
            btn_start.setDisable(false);
            //Partida.AbandonarPartida();
            //Restart();
            btnDisable();
        }
    }

    // ? Método de selección de botoń de juego
    public void btnSelected(ActionEvent event) throws InterruptedException {
        // ? Comprueba si la partida está iniciada
        if (Partida.getStarted()){
            tmpBtn = (Button) event.getSource();
            String bId = tmpBtn.getId().replaceAll("[btn]","");
            int idBtn =Integer.valueOf(bId);
            tmpBtn.setDisable(true);
            cambiarBotonJugador(idBtn);
            Partida.cambiarTurno();
        }
    }

    private void cambiarBotonJugador(int nBtn){
        switch (nBtn){
            case 0:
                if (partida.getTurno()){
                    btn0.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn0.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 1:
                if (partida.getTurno()){
                    btn1.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn1.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 2:
                if (partida.getTurno()){
                    btn2.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn2.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 3:
                if (partida.getTurno()){
                    btn3.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn3.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 4:
                if (partida.getTurno()){
                    btn4.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn4.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 5:
                if (partida.getTurno()){
                    btn5.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn5.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 6:
                if (partida.getTurno()){
                    btn6.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn6.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 7:
                if (partida.getTurno()){
                    btn7.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn7.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
            case 8:
                if (partida.getTurno()){
                    btn8.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    btn8.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                break;
        }
    }

    private void addAllBtn(){
        listBtn.add(btn0);
        listBtn.add(btn1);
        listBtn.add(btn2);
        listBtn.add(btn3);
        listBtn.add(btn4);
        listBtn.add(btn5);
        listBtn.add(btn6);
        listBtn.add(btn7);
        listBtn.add(btn8);
    } // ? Añade los botones a la lista de botones
    private void btnEnable(){
        for(Button tmpBtn : listBtn){
            tmpBtn.setDisable(false);
        }
    }// ? Habilita todos los botones
    public void btnDisable(){
        for(Button tmpBtn : listBtn){
            tmpBtn.setDisable(true);
        }
    } // ? Deshabilita todos los botones
    public void btnResetColor(){
        for(Button tmpBtn : listBtn){
            tmpBtn.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    } // ? Deshabilita todos los botones

    public void changeTheme(ActionEvent event){
        if (theme){
            btnTheme.getScene().getStylesheets().remove(darkTheme);
            btnTheme.getScene().getStylesheets().add(whiteTheme);
            btnTheme.setGraphic(darkView);
            theme = false;
        } else {
            btnTheme.getScene().getStylesheets().remove(whiteTheme);
            btnTheme.getScene().getStylesheets().add(darkTheme);
            btnTheme.setGraphic(whiteView);
            theme = true;
        }
    } // ? Método cambio de tema

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ? Pone la imagen del botón de cambio de tema.
        btnTheme.setGraphic(whiteView);
        theme = true;

        btn_stop.setDisable(true); // ? Deshabilita el botón de stop
    }
}