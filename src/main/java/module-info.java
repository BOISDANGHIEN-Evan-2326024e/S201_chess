module com.s201_chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.s201_chess to javafx.fxml;
    exports com.s201_chess;
    exports com.s201_chess.Class;
    opens com.s201_chess.Class to javafx.fxml;

}