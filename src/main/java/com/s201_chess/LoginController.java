package com.s201_chess;

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

    public void changeScene(Button button) {
        try {
            User user = new User(usernameField.getText(), firstNameField.getText(), lastNameField.getText());
            File file = new File(usernameField.getText()+firstNameField.getText()+lastNameField.getText()); //fichier spécifique à  1 joueur
            ArrayList<User> userArrayList = new ArrayList<>();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 777, 659));
            stage.show();
            try{
                FileManager.loadFile(file/*, user*/);
                FileManager.addUser(userArrayList, user);
                FileManager.saveUser(file, userArrayList);
//                FileManager.lineAlreadyExists(file, user);
            }catch (IOException e){
                e.printStackTrace();
            }
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