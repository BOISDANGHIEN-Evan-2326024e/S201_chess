package com.s201_chess;

// import des classes et bibliothèques nécessaires au fonctionnement de la classe
import com.s201_chess.Class.Joueur;
import com.s201_chess.Class.User;
import com.s201_chess.Class.FileManager;
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
import java.nio.file.Files;
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
            String directoryName = "players"; // Le répertoire où se trouvent les fichiers des joueurs
            String result = joueur_actuelle.getPseudo();

            System.out.println("Résultat: " + result);
            String fileName = directoryName + "/" + result + ".txt";
            File playerFile = new File(fileName);
            if (playerFile.exists()) {

                try {
                    List<String> lines = Files.readAllLines(playerFile.toPath());
                    int compteur=0;
                    for (String line : lines) {

                        if(compteur==3){

                            joueur_actuelle.setNbJoues(Integer.parseInt(line));
                        }
                        if(compteur==4){
                            joueur_actuelle.setNbVictoires(Integer.parseInt(line));
                        }
                        compteur++;
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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