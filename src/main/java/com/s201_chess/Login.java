package com.s201_chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    // lance l'application
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Login.fxml"));// pour accéder à la ressource fxml
        Scene scene = new Scene(fxmlLoader.load(), 534, 360); // pour utiliser la ressource
        stage.setScene(scene);
        stage.setResizable(false); // pour empêcher le redimensionnement de la page
        stage.setTitle("chess.com"); // donne un titre à la page
        stage.show();
    }
}
