module com.s201_chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.s201_chess to javafx.fxml;
    exports com.s201_chess;
}