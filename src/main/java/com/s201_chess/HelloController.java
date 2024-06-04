package com.s201_chess;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ImageView blackPP;
    @FXML
    private GridPane grid;
    public void initialize() {
        System.out.println("Initialisation du controlleur..");
        //welcomeText.setText("Welcome to JavaFX Application!");
        URL blackPPUrl = getClass().getResource("/images/blackPP.png");
        if (blackPPUrl != null) {
            blackPP.setImage(new Image(blackPPUrl.toExternalForm()));
        } else {
            System.err.println("Resource not found: aa images/blackPP.png");
            // Optionally, you can handle this case by setting a default image or taking other actions
        }
    Partie partietest = new Partie(new Joueur("Joueur1","a","a"), new Joueur("Joueur2","a","a"));
        affichage_plateau(partietest);
    }

    public void affichage_plateau(Partie partietest){
        for (int i= 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Créer un rectangle pour représenter la case
                Rectangle rect = new Rectangle(100, 100);
                // Alternativement, définir la couleur du rectangle en noir ou blanc
                rect.setFill((i + j) % 2 == 0 ? Color.GREEN : Color.WHITE);
                grid.add(rect, j, i);
                // Si une pièce d'échecs est présente à ces coordonnées
                Piece piece = partietest.getPlateau().get(i).get(j);
                if (piece != null) {
                    // Créer un ImageView avec l'image de la pièce
                    ImageView image=piece.getImage();
                    image.setFitHeight(100);
                    image.setFitWidth(100);

                    grid.add(image, j, i);
                }

                // Ajouter le rectangle à la cellule correspondante du GridPane
            }
        }
    }


}