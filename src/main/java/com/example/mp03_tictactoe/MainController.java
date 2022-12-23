package com.example.mp03_tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    // ? Temas CSS
    String whiteTheme = this.getClass().getResource("white_theme.css").toExternalForm();
    String darkTheme = this.getClass().getResource("dark_theme.css").toExternalForm();

    Image whiteIcon = new Image(this.getClass().getResource("white_theme_icon.png").toExternalForm());
    ImageView whiteView = new ImageView(whiteIcon);
    Image darkIcon = new Image(this.getClass().getResource("dark_theme_icon.png").toExternalForm());
    ImageView darkView = new ImageView(darkIcon);

    @FXML
    private Button btnTheme;
    boolean theme;


    // ? Botón START
    @FXML
    private Button btnStart;
    @FXML
    private Button btnRestart;
    boolean started;


    // ? Turnos
    @FXML
    AnchorPane bordeTurno;
    boolean turno; // ? True - Jugador 1 / False - Jugador 2

    int modoJuego = 1; // ? 1-Player VS Player  / 2- Player VS PC / 3- PC VS PC

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

    List<Button> listBtn = new ArrayList<>(); // ? Lista de botones

    // ? Cosas del juego
    private int[] tablero = new int[9]; // ? Matriz del tablero
    // ? Variables para los jugadores
    private int jugador1 = 1;
    private int jugador2 = 2;
    private int jugadorActual = jugador1; // ? Variable para el jugador actual
    private int nTurno = 1; // ? Variable para el número de turno

    // ? Método cambio de tema
    public void changeTheme(ActionEvent event){
        if (theme){
            btnTheme.getScene().getStylesheets().remove(darkTheme);
            btnTheme.getScene().getStylesheets().add(whiteTheme);
            btnTheme.setGraphic(darkView);
            // btnTheme.setPadding(Insets.EMPTY);
            theme = false;
        } else {
            btnTheme.getScene().getStylesheets().remove(whiteTheme);
            btnTheme.getScene().getStylesheets().add(darkTheme);
            btnTheme.setGraphic(whiteView);
            theme = true;
        }
    }

    public void iniciarJuego(){
        addAllBtn();
        btnEnable();
        switch (modoJuego){
            case 1:
                playerVSplayer();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    // * Modos de juego
    private void playerVSplayer(){
        boolean ganador = false; // ? Creamos variable de ganador
        turno = true; // ? Ponemos el turno al jugador 1
        bordeTurno.setBackground(new Background(new BackgroundFill(Color.web("#3877ff"), CornerRadii.EMPTY, Insets.EMPTY)));
    }


    // * Métodos botones
    public void pulseBtn0(){
        btnPulsado(0);
    }
    public void pulseBtn1(){
        btnPulsado(1);
    }
    public void pulseBtn2(){
        btnPulsado(2);
    }
    public void pulseBtn3(){
        btnPulsado(3);
    }
    public void pulseBtn4(){
        btnPulsado(4);
    }
    public void pulseBtn5(){
        btnPulsado(5);
    }
    public void pulseBtn6(){
        btnPulsado(6);
    }
    public void pulseBtn7(){
        btnPulsado(7);
    }
    public void pulseBtn8(){
        btnPulsado(8);
    }
    public void btnPulsado(int nBtn){
        if (turno){
            System.out.println(jugador1);
        }else{
            System.out.println(jugador2);
        }
        cambiarTurno();
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


    private void cambiarTurno(){
        if (turno){
            bordeTurno.setBackground(new Background(new BackgroundFill(Color.web("#ff3838"), CornerRadii.EMPTY, Insets.EMPTY)));
            turno = false;
        } else if (!turno) {
            bordeTurno.setBackground(new Background(new BackgroundFill(Color.web("#3877ff"), CornerRadii.EMPTY, Insets.EMPTY)));
            turno = true;
        }
    } // ? Cambia los colores dependiendo del turno del jugador

    private void restartJuego(){
        if (started){
            System.out.println(tablero.toString());
            for (int tmpInt : tablero){tmpInt = 0;}
        }
    }

}