package com.example.mp03_tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static Partida partida = new Partida();
    private static Stats stats = new Stats();

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

    // ? Bordes Tablero
    @FXML
    AnchorPane innerBorder;
    @FXML
    AnchorPane turnoBorder;

    @FXML
    ToolBar toolBar;

    // ? Temas CSS
    String whiteTheme = this.getClass().getResource("white_theme.css").toExternalForm();
    String darkTheme = this.getClass().getResource("dark_theme.css").toExternalForm();

    Image whiteIcon = new Image(this.getClass().getResource("white_theme_icon.png").toExternalForm());
    ImageView whiteView = new ImageView(whiteIcon);
    Image darkIcon = new Image(this.getClass().getResource("dark_theme_icon.png").toExternalForm());
    ImageView darkView = new ImageView(darkIcon);

    Image darkStats = new Image(this.getClass().getResource("stats_icon_dark.png").toExternalForm());
    ImageView darkStatsView = new ImageView(darkStats);
    Image whiteStats = new Image(this.getClass().getResource("stats_icon_white.png").toExternalForm());
    ImageView whiteStatsView = new ImageView(whiteStats);

    private String colorJugador1 = "#3877ff";
    private String colorJugador2 = "#ec4b4b";

    @FXML
    private Button btnTheme;
    boolean theme; // ? T-Dark F-White

    // ? Selecci??n de modo de juego
    @FXML
    RadioButton btn_gamemode0;
    @FXML
    RadioButton btn_gamemode1;
    @FXML
    RadioButton btn_gamemode2;
    @FXML
    TextField textJugador1;
    @FXML
    TextField textJugador2;
    @FXML
    Button btnStats;

    // * ----------------------------------------

    public void gamemodeSelector(){
        if (btn_gamemode0.isSelected()){
            System.out.println("GAMEMODE 1");
            partida.setMode(1);
            textJugador1.setVisible(true);  // ? Habilita el campo de texto del jugador 1
            textJugador2.setVisible(true);  // ? Habilita el campo de texto del jugador 2
        } else if (btn_gamemode1.isSelected()){
            System.out.println("GAMEMODE 2");
            partida.setMode(2);
            textJugador1.setVisible(false);  // ? Deshabilita el campo de texto del jugador 1
            textJugador2.setVisible(false);  // ? Deshabilita el campo de texto del jugador 2
        } else if (btn_gamemode2.isSelected()){
            System.out.println("GAMEMODE 3");
            partida.setMode(3);
            textJugador1.setVisible(false);  // ? Deshabilita el campo de texto del jugador 1
            textJugador2.setVisible(false);  // ? Deshabilita el campo de texto del jugador 2
        }
    }   // ? Cambia el modo de juego
    @FXML
    public void startGame(ActionEvent event){
        boolean gameCorrecto = false;
        partida.restart();
        btn_start = (Button) event.getSource(); // ? Obtiene el bot??n del evento

        if (partida.getMode() == 1){
            if (textJugador1.getText().trim().isEmpty() || textJugador2.getText().trim().isEmpty()){
                Alerts.faltaNombres();
                textJugador1.clear();
                textJugador2.clear();
            } else if (textJugador1.getText().trim().equals(textJugador2.getText().trim())) {
                Alerts.nombresIguales();
            } else {
                gameCorrecto = true;
            }
        } else gameCorrecto = true;
        if (gameCorrecto){
            addAllBtn();
            btnEnable(); // ? Activa todos los botones
            switch (partida.getMode()){
                case 1:
                    partida.randomTurno();
                    enableModes(false);
                    break;
                case 2,3:
                    partida.setTurno(true);
                    break;
            }
            partida.setnTurno(0);
            btn_start.setDisable(true); // ? Desactiva el bot??n de iniciar
            btn_stop.setDisable(false); // ? Activa el bot??n de finalizar
            btnResetColor();    // ? Resetea los colores de los botones
            cambiarTurnoBorde(partida.getTurno());    // ? Pone el borde del color del turno
            enableModes(false); // ? Desactiva los botones de modos
            enableNames(false); // ? Desactiva los textos de jugadores

            switch (partida.getMode()){
                case 1:
                    System.out.println("START GAME - MODE PLAYER VS PLAYER");
                    break;
                case 2:
                    System.out.println("START GAME - MODE PLAYER VS MACHINE");
                    break;
                case 3:
                    System.out.println("START GAME - MODE MACHINE VS MACHINE");
                    machineVSmachine();
                    break;
            }
        }

    }   // ? M??todo de inicio de la partida
    @FXML
    public void stopGame(ActionEvent event) {

        btn_stop = (Button) event.getSource(); // ? Obtiene el bot??n del evento
        Boolean respuesta = Alerts.abandonarPartida(); // ? Muestra la alerta de finalizar partida

        if(respuesta) {
            btn_stop.setDisable(true); // ? Desactiva el bot??n de finalizar
            btn_start.setDisable(false); // ? Activa el bot??n de empezar
            enableModes(true); // ? Activa los botones de modos
            enableNames(true); // ? Activa los textos de los nombres
            //Partida.AbandonarPartida(); // ? Funci??n de acabar partida de la clase partida
            btnDisable(); // ? Desactiva todos los botones
            btnResetColor(); // ? Resetea todos los colores
            partida.restart();
            turnoBorder.setBackground(new Background(new BackgroundFill(Color.web("#807E7D"), CornerRadii.EMPTY, Insets.EMPTY))); // ? Color borde
            System.out.println("STOP GAME");
        }
    }   // ? M??todo de finalizaci??n de la partida
    public void btnSelected(ActionEvent event) throws InterruptedException {
        tmpBtn = (Button) event.getSource();        // ? Obtiene el bot??n del evento
        String bId = tmpBtn.getId().replaceAll("[btn]","");     // ? Obtiene el ID del bot??n y la transforma a integer
        int idBtn =Integer.valueOf(bId);
        tmpBtn.setDisable(true);        // ? Deshabilita el bot??n pulsado
        partida.marcar(idBtn);          // ? Transforma el contenido de la posici??n del bot??n seg??n el turno
        cambiarTurnoBoton(idBtn);       // ? Cambia el color del bot??n seg??n el turno
        cambiarTurnoBorde();            // ? Cambia el color del borde seg??n el turno
        partida.cambiarTurno();         // ? Cambia el turno
        partida.setnTurno(partida.getnTurno() + 1);     // ? Suma una posici??n al turno
        partida.mostrarTableroLog();
        comprobarGanador();

        if (partida.getMode() == 2 && partida.isGanador()){
            btnRandomGamemode2();
        }
    }   // ? M??todo de selecci??n de boto?? de juego
    public void btnRandomGamemode2(){
        int randomBtn = (int) ((Math.random() * (9 - 0)) + 0);
        if (partida.nTablero(randomBtn) == 0){
            listBtn.get(randomBtn).setDisable(true);        // ? Deshabilita el bot??n pulsado
            partida.marcar(randomBtn);          // ? Transforma el contenido de la posici??n del bot??n seg??n el turno
            cambiarTurnoBoton(randomBtn);       // ? Cambia el color del bot??n seg??n el turno
            cambiarTurnoBorde();            // ? Cambia el color del borde seg??n el turno
            partida.cambiarTurno();         // ? Cambia el turno
            partida.setnTurno(partida.getnTurno() + 1);     // ? Suma una posici??n al turno
            partida.mostrarTableroLog();
            comprobarGanador();
        } else btnRandomGamemode2();
    }
    public void btnRandomGamemode3(){
        int randomBtn = (int) ((Math.random() * (9 - 0)) + 0);
        if (partida.nTablero(randomBtn) == 0){
            listBtn.get(randomBtn).setDisable(true);
            partida.marcar(randomBtn);
            cambiarTurnoBoton(randomBtn);
            cambiarTurnoBorde();
            partida.cambiarTurno();
            partida.setnTurno(partida.getnTurno() + 1);
            comprobarGanador();
        } else btnRandomGamemode3();
    }
    public void machineVSmachine(){
        while (partida.getnTurno() !=9 && partida.comprobarGanador() == 0){
            btnRandomGamemode3();
            comprobarGanador();
        }
    }
    private void cambiarTurnoBoton(int nBtn){
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
    }   // ? Cambia el color del bot??n seg??n el turno
    private void cambiarTurnoBorde(){
        if (partida.getTurno()){
            turnoBorder.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            turnoBorder.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }   // ? Cambia el color del borde del tablero seg??n el turno
    private void cambiarTurnoBorde(boolean turno){
        if (turno){
            turnoBorder.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            turnoBorder.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }   // ? Cambia el color del borde del tablero seg??n el turno
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
    }   // ? A??ade los botones a la lista de botones
    private void btnEnable(){
        for(Button tmpBtn : listBtn){
            tmpBtn.setDisable(false);
        }
    }   // ? Habilita todos los botones
    public void btnDisable(){
        for(Button tmpBtn : listBtn){
            tmpBtn.setDisable(true);
        }
    }   // ? Deshabilita todos los botones
    public void btnResetColor(){
        for(Button tmpBtn : listBtn){
            tmpBtn.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }   // ? Deshabilita todos los botones
    public void enableModes(boolean active){
        if (!active){
            btn_gamemode0.setDisable(true);
            btn_gamemode1.setDisable(true);
            btn_gamemode2.setDisable(true);
        } else {
            btn_gamemode0.setDisable(false);
            btn_gamemode1.setDisable(false);
            btn_gamemode2.setDisable(false);
        }
    }   // ? Alterna la activaci??n de los botones de modos
    public void enableNames(boolean active){
        if (!active){
            textJugador1.setDisable(true);
            textJugador2.setDisable(true);
        } else {
            textJugador1.setDisable(false);
            textJugador2.setDisable(false);
        }
    }   // ? Alterna la activaci??n de los botones de modos
    @FXML
    public void changeTheme(ActionEvent event){
        if (theme){
            btnTheme.getScene().getStylesheets().remove(darkTheme);
            btnTheme.getScene().getStylesheets().add(whiteTheme);
            btnTheme.setGraphic(darkView);
            btnStats.setGraphic(whiteStatsView);
            theme = false;
        } else {
            btnTheme.getScene().getStylesheets().remove(whiteTheme);
            btnTheme.getScene().getStylesheets().add(darkTheme);
            btnTheme.setGraphic(whiteView);
            btnStats.setGraphic(darkStatsView);
            theme = true;
        }
    }   // ? M??todo cambio de tema
    public void comprobarGanador(){
        if (partida.comprobarGanador() == 1){
            setGanador(1);
        } else if (partida.comprobarGanador() == 2) {
            setGanador(2);
        } else if (partida.getnTurno() > 8 && partida.comprobarGanador() == 0){
            setGanador(0);
        }
    }   // ? Seg??n el ganador cambia la interfaz
    public void setGanador(int nGanador){
        btnDisable();
        switch (nGanador){
            case 0:
                turnoBorder.setBackground(new Background(new BackgroundFill(Color.web("#807E7D"), CornerRadii.EMPTY, Insets.EMPTY))); // ? Color borde
                System.out.println("EMPATE");
                if (partida.getMode() == 1){
                    stats.updatePlayerStat(textJugador1.getText(),"draw",1);
                    stats.updatePlayerStat(textJugador2.getText(),"draw",1);
                }
                break;
            case 1:
                turnoBorder.setBackground(new Background(new BackgroundFill(Color.web(colorJugador1), CornerRadii.EMPTY, Insets.EMPTY))); // ? Color borde
                System.out.println("GANADOR - Jugador 1");
                if (partida.getMode() == 1) {
                    stats.updatePlayerStat(textJugador1.getText(), "win", 1);
                    stats.updatePlayerStat(textJugador2.getText(), "lost", 1);
                }
                break;
            case 2:
                System.out.println("GANADOR - Jugador 2");
                turnoBorder.setBackground(new Background(new BackgroundFill(Color.web(colorJugador2), CornerRadii.EMPTY, Insets.EMPTY))); // ? Color borde
                if (partida.getMode() == 1){
                    stats.updatePlayerStat(textJugador1.getText(),"lost",1);
                    stats.updatePlayerStat(textJugador2.getText(),"win",1);
                }
                break;
        }
        partida.setGanador(true);
        btn_start.setDisable(false);
        btn_stop.setDisable(true);
        enableModes(true);
        enableNames(true);
    }   // ? Hace los cambios visuales dependiendo del ganador
    @FXML
    public void showStats(ActionEvent event){
        stats.showTable(theme);
    }   // ? Muestra la tabla de los stats
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ? Pone la imagen del bot??n de cambio de tema.
        btnTheme.setGraphic(whiteView);
        btnStats.setGraphic(darkStatsView);
        theme = true;

        btn_stop.setDisable(true); // ? Deshabilita el bot??n de stop
    }
}