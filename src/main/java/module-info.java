module com.example.mp03_tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.mp03_tictactoe to javafx.fxml;
    exports com.example.mp03_tictactoe;
}