package com.s201_chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getClassLoader().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 534, 360);
//        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("chess.com");
        stage.show();
    }
}
