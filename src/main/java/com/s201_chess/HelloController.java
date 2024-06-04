package com.s201_chess;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController {
    private Piece selectedPiece = null;
    @FXML
    private ImageView blackPP;
    @FXML
    private ImageView whitePP;
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
        System.out.println("Initialisation du controlleur..");
        //welcomeText.setText("Welcome to JavaFX Application!");
        URL whitePPUrl = getClass().getResource("/images/whitePP.png");
        if (whitePPUrl != null) {
            whitePP.setImage(new Image(whitePPUrl.toExternalForm()));
        } else {
            System.err.println("Resource not found: aa images/whitePP.png");
            // Optionally, you can handle this case by setting a default image or taking other actions
        }
        Partie partietest = new Partie(new Joueur("Joueur1","a","a"), new Joueur("Joueur2","a","a"));
        affichage_plateau(partietest);
        grid.setOnMouseClicked(event -> {
            System.out.println("coucou");
            if (selectedPiece != null) {
                // Calculez la nouvelle position en fonction de la position du clic
                System.out.println("caca");
                int newPositionH = (int) (event.getY() / 100);
                int newPositionV = (int) (event.getX() / 100);
                ArrayList<ArrayList<Integer>> mvt_possible=partietest.mvt_possible(selectedPiece);
                // Déplacez la pièce dans le code
                partietest.deplacer_piece(selectedPiece.getPosition_h(), selectedPiece.getPosition_v(), newPositionH, newPositionV,mvt_possible,selectedPiece);

                // Déplacez la pièce dans l'interface graphique
                grid.getChildren().remove(selectedPiece.getImage());
                grid.add(selectedPiece.getImage(), newPositionV, newPositionH);

                // Réinitialisez la pièce sélectionnée
                selectedPiece = null;
            }
        });
    }

    public void affichage_plateau(Partie partietest) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Créer un rectangle pour représenter la case
                Rectangle rect = new Rectangle(65, 65);
                // Alternativement, définir la couleur du rectangle en noir ou blanc
                rect.setFill((i + j) % 2 == 0 ? Color.GREEN : Color.WHITE);
                grid.add(rect, j, i);
                // Si une pièce d'échecs est présente à ces coordonnées
                Piece piece = partietest.getPlateau().get(i).get(j);
                if (piece != null) {

                    // Créer un ImageView avec l'image de la pièce
                    ImageView image=piece.getImage();
                    image.setFitHeight(65);
                    image.setFitWidth(65);
                    // Ajoutez un gestionnaire d'événements à l'image
                    image.setOnMouseClicked(event -> {
                        System.out.println("yo");
                        // Enregistrez la pièce sélectionnée et attendez le prochain clic
                        // pour déplacer la pièce
                        // Vous pouvez stocker la pièce sélectionnée dans une variable d'instance
                        selectedPiece = piece;
                    });

                    grid.add(image, j, i);
                }

                // Ajouter le rectangle à la cellule correspondante du GridPane
            }
        }
    }


}