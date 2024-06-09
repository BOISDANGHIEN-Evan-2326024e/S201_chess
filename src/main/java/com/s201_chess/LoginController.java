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

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LoginController extends GridPane {
    // initialisation des éléments de l'interface
    static Joueur joueur_actuelle;
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

//    ArrayList<User> userArrayList = new ArrayList<>();

    public void changeScene(Button button) {
        try {
            User user = new User(usernameField.getText(), firstNameField.getText(), lastNameField.getText());
            joueur_actuelle = new Joueur(user.getUsername(), user.getFirstName(), user.getLastName(),"Blanc");
            FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));

            Stage stage = (Stage) button.getScene().getWindow();
            Scene scene2 = new Scene(loader.load(), 777, 659);
            if (scene2 != null) {
                scene2.getStylesheets().add(getClass().getResource("hello-view.css").toExternalForm());
            }
            stage.setScene(scene2);
            stage.show();
            try{
                // si les champs TextField ne sont pas vides alors on enregistre l'utilisateur
                if (!usernameField.getText().isEmpty() && !firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()) {
                    FileManager.saveUser(joueur_actuelle);
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

    public static Joueur getJoueur_actuelle() {
        return joueur_actuelle;
    }

    public void setJoueur_actuelle(Joueur joueur_actuelle) {
        this.joueur_actuelle = joueur_actuelle;
    }
}