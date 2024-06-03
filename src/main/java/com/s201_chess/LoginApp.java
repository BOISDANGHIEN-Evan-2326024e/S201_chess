package com.s201_chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        URL fxmlLocation = getClass().getClassLoader().getResource("com.s201_chess/LoginView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(fxmlLoader.load(), 534, 360);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("chess.com");
        stage.show();
    }
}
