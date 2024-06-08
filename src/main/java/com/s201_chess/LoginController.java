package com.s201_chess;

// import des classes et bibliothèques nécessaires au fonctionnement de la classe
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.io.IOException;

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
            Joueur joueur = new Joueur(usernameField.getText(), firstNameField.getText(), lastNameField.getText());
            FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 777, 659));
            stage.show();
            try{
                // si les champs TextField ne sont pas vides alors on enregistre l'utilisateur
                if (!usernameField.getText().isEmpty() && !firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()) {
                    FileManager.saveUser(joueur);
                } else { // sinon on envoit qu'il faut remplir tous les champs pour s'enregistrer
                    System.out.println("Veuillez remplir tous les champs.");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // méthode liée au FXML et qui fait appel à changeScene lorsqu'on appuie sur le bouton "Login"
    @FXML
    public void loginClicked() {
        loginButton.setOnMouseClicked(actionEvent -> {
            changeScene(loginButton);
        });
    }
}