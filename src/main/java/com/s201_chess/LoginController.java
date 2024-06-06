package com.s201_chess;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableList.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LoginController extends GridPane {
    @FXML
    VBox vb;
    @FXML
    TextField usernameField;
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    Button loginButton;

    // pour passer de Hello à Login UNIQUEMENT quand on appuie sur le loginButton
    public void changeScene(Button button) {
        try {
            File file = new File("users.txt");
            ObservableList<User> userObservableList = null;
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 777, 659));
            stage.show();
            {
                User user = new User(usernameField.getText(), firstNameField.getText(), lastNameField.getText());
                FileManager.loadFile(file);
                FileManager.addUser(userObservableList, user);
                FileManager.saveUser(userObservableList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loginClicked() {
        // TODO : permettre l'enregistrement des utilisateurs dans la liste ET le fichier quand on appuie sur le bouton
        loginButton.setOnMouseClicked(actionEvent -> {
            changeScene(loginButton);
        });
    }
}