package com.s201_chess;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends GridPane implements Initializable {
    @FXML
    VBox vb;
    @FXML
    Label username;
    @FXML
    Label password;
    @FXML
    TextField usernameField;
//    @FXML
//    PasswordField passwordField;
    @FXML
    Button loginButton;
    @FXML
    Button cancelButton;

    @FXML
    private void loginClicked() throws IOException {
        HelloController helloController = new HelloController();
        helloController.initialize();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        try {
            fxmlLoader.getClassLoader();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @FXML
//    private void cancelClicked() {
//    }
}