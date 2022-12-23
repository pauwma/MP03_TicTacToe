package com.example.mp03_tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class TresEnRayaFX extends Application {
    // Matriz del tablero
    private int[][] tablero = new int[3][3];

    // Variables para los jugadores
    private int jugador1 = 1;
    private int jugador2 = 2;

    // Variable para el jugador actual
    private int jugadorActual = jugador1;

    // Variable para el turno actual
    private int turno = 1;

    @Override
    public void start(Stage stage) {
        // Creamos el panel del tablero
        GridPane panelTablero = new GridPane();

        // Creamos los botones y los añadimos al panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int fila = i;
                final int columna = j;
                Button btn = new Button();
                btn.setPrefSize(100, 100);
                panelTablero.add(btn, j, i);

                // Añadimos el manejador del evento de pulsación del botón
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Si el juego ha terminado, no hacemos nada y salimos del método
                        if (juegoTerminado()) {
                            return;
                        }

                        // Actualizamos el valor de la celda correspondiente en la matriz del tablero
                        tablero[fila][columna] = jugadorActual;

                        // Cambiamos el color del botón según el jugador que lo ha pulsado
                        String color = (jugadorActual == jugador1) ? "blue" : "red";
                        btn.setStyle("-fx-background-color: " + color + ";");

                        // Deshabilitamos el botón para que no pueda ser pulsado más
                        btn.setDisable(true);

                        // Deshabilitamos el botón para que no pueda ser pulsado más
                        btn.setDisable(true);

                        // Cambiamos el valor de la variable jugadorActual para que sea el otro jugador
                        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;

                        // Incrementamos el valor de la variable turno
                        turno++;

                        // Comprobamos si hay un ganador o si ha habido un empate
                        int ganador = comprobarGanador();
                        if (ganador != 0) {
                            // Hay un ganador
                            String mensaje = "¡El jugador " + ganador + " ha ganado!";

                            // Deshabilitamos todos los botones
                            for (int fila = 0; fila < 3; fila++) {
                                for (int columna = 0; columna < 3; columna++) {
                                    panelTablero.getChildren().get(3 * fila + columna).setDisable(true);
                                }
                            }

                            // Mostramos un mensaje de alerta con el resultado
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Resultado");
                            alert.setHeaderText(null);
                            alert.setContentText(mensaje);
                            alert.showAndWait();
                        } else if (turno == 9) {
                            // Ha habido un empate
                            System.out.println("Empate!");

                            // Reiniciamos el juego
                            reiniciarJuego();
                        }
                    }
                });
            }
        }

        // Creamos la escena y añadimos el panel del tablero
        Scene scene = new Scene(panelTablero, 300, 300);

        // Mostramos la ventana
        stage.setScene(scene);
        stage.show();
    }

    // Método para reiniciar el juego
    private void reiniciarJuego() {
        // Reiniciamos la matriz del tablero
        tablero = new int[3][3];

        // Reiniciamos las variables de los jugadores y el turno
        jugadorActual = jugador1;
        turno = 1;
    }

    // Método para comprobar si el juego ha terminado o no
    private boolean juegoTerminado() {
        // Si hay un ganador, el juego ha terminado
        if (comprobarGanador() != 0) {
            return true;
        }

        // Si el turno es mayor que 9, ha habido un empate y el juego ha terminado
        if (turno > 9) {
            return true;
        }

        // Si no se ha cumplido ninguna de las condiciones anteriores, el juego no ha terminado
        return false;
    }

    // Método para comprobar si hay un ganador o no
    private int comprobarGanador() {
        // Revisamos las filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return tablero[i][0];
            }
        }

        // Revisamos las columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return tablero[0][j];
            }
        }

        /// Revisamos las diagonales
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return tablero[0][0];
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return tablero[0][2];
        }

        // Si no se ha cumplido ninguna de las condiciones anteriores, no hay ganador
        return 0;
    }

}