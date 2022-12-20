package com.example.mp03_tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //private String whiteTheme = getClass().getResource("white_theme.css").toExternalForm();
    //private String darkTheme = getClass().getResource("dark_theme.css").toExternalForm();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // ? Creación del "sandwich"
        Group root = new Group();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Tic Tac Toe - pauwma");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }
}
