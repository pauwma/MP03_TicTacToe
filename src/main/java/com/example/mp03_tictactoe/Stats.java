package com.example.mp03_tictactoe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stats {
    private TableView<Jugador> table;
    private ObservableList<Jugador> data;
    private TableColumn<Jugador, String> nameCol;
    private TableColumn<Jugador, Integer> winCol;
    private TableColumn<Jugador, Integer> lostCol;
    private TableColumn<Jugador, Integer> drawCol;

    public Stats(){
        // inicializar las variables aquí
    }

    // métodos y código aquí

    public void showTable(){
        Stage primaryStage = new Stage();
        // Crear columnas de la tabla
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

        data = FXCollections.observableArrayList(
                new Jugador("Jugador 1", 10, 5, 2),
                new Jugador("Jugador 2", 8, 7, 3),
                new Jugador("Jugador 3", 7, 8, 5)
        );

        // Crear tabla y añadir las columnas
        table = new TableView<>();
        table.setItems(data);
        table.getColumns().addAll(nameCol, winCol, lostCol, drawCol);

        primaryStage.setScene(new Scene(new VBox(table), 600, 400));
        primaryStage.show();
    }
}