package com.s201_chess;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginController extends GridPane {
    @FXML
    Label username;
    @FXML
    Label password;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton;
    @FXML
    Button cancelButton;

    @FXML
    private void okClicked() {
    }

    @FXML
    private void cancelClicked() {
    }
}