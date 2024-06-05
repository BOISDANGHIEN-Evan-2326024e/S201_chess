package com.s201_chess;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;

public class LoginController extends GridPane {
    @FXML
    VBox vb;
    @FXML
    Label username;
    @FXML
    Label password;
    @FXML
    TextField usernameField;
    @FXML
    Button loginButton;

    public void changeScene(Button button) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loginClicked() {
        loginButton.setOnMouseClicked(actionEvent -> {
            changeScene(loginButton);
        });
    }
}