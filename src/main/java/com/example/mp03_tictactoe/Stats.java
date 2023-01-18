package com.example.mp03_tictactoe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;

public class Stats {
    private boolean tableOpened = false;
    private TableView<Jugador> table;
    private Stage stage;
    private ObservableList<Jugador> data;
    private TableColumn<Jugador, String> nameCol;
    private TableColumn<Jugador, Integer> winCol;
    private TableColumn<Jugador, Integer> lostCol;
    private TableColumn<Jugador, Integer> drawCol;

    private String whiteTheme = this.getClass().getResource("white_theme.css").toExternalForm();
    private String darkTheme = this.getClass().getResource("dark_theme.css").toExternalForm();

    public Stats(){
        data = FXCollections.observableArrayList();
    }

    // ? Hace un update del jugador de la stat pasada por parámetros y si el jugador no existe la crea
    public void updatePlayerStat(String name, String stat, int value) {
        boolean exist = false;
        for (Jugador p : data) {
            if (p.getNombre().equals(name)) {
                exist = true;
                switch (stat) {
                    case "win":
                        p.setGanadas(p.getGanadas() + value);
                        break;
                    case "lost":
                        p.setPerdidas(p.getPerdidas() + value);
                        break;
                    case "draw":
                        p.setEmpatadas(p.getEmpatadas() + value);
                        break;
                    default:
                        System.out.println("La estadística especificada no es válida");
                }
                break;
            }
        }
        if(!exist) {
            Jugador newPlayer = new Jugador(name);
            switch (stat) {
                case "win":
                    newPlayer.setGanadas(value);
                    break;
                case "lost":
                    newPlayer.setPerdidas(value);
                    break;
                case "draw":
                    newPlayer.setEmpatadas(value);
                    break;
                default:
                    System.out.println("La estadística especificada no es válida");
            }
            data.add(newPlayer);
        }
    }

    // ? Crea un nuevo stage y una nueva tabla y introduce los datos de la lista de jugadores
    public void showTable(boolean theme){
        if(tableOpened){
            stage.close();
            tableOpened = false;
        }
        tableOpened = true;
        stage = new Stage();
        table = new TableView<>();
        table.setItems(this.data);

        // ? Ordenar la tabla según la cantidad de partidas ganadas
        data.sort(new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return Integer.compare(o2.getGanadas(), o1.getGanadas());
            }
        });

        // ? Crear columnas de la tabla
        nameCol = new TableColumn<>("Nombre");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        winCol = new TableColumn<>("Ganadas");
        winCol.setMinWidth(100);
        winCol.setCellValueFactory(new PropertyValueFactory<>("ganadas"));

        lostCol = new TableColumn<>("Perdidas");
        lostCol.setMinWidth(100);
        lostCol.setCellValueFactory(new PropertyValueFactory<>("perdidas"));

        drawCol = new TableColumn<>("Empatadas");
        drawCol.setMinWidth(100);
        drawCol.setCellValueFactory(new PropertyValueFactory<>("empatadas"));

        table.getColumns().addAll(nameCol, winCol, lostCol, drawCol);

        // Crear tabla y añadir las columnas
        table = new TableView<>();
        table.setItems(data);
        table.getColumns().addAll(nameCol, winCol, lostCol, drawCol);

        Scene scene = new Scene(new VBox(table), 502, 400);
        if (theme){
            scene.getStylesheets().remove(darkTheme);
            scene.getStylesheets().add(whiteTheme);
        } else {
            scene.getStylesheets().remove(whiteTheme);
            scene.getStylesheets().add(darkTheme);
        }
        stage.setScene(scene);
        stage.setTitle("Estadísticas de Jugadores");
        stage.setResizable(false);
        stage.show();
    }
}