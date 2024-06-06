module com.s201_chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens com.s201_chess to javafx.fxml;
    exports com.s201_chess;
}