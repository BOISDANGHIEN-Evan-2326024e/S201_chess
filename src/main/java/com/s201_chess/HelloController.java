package com.s201_chess;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;

public class HelloController {
    private Piece selectedPiece = null;
    private ArrayList<ArrayList<Integer>> mvt_possible;
    private Partie partie;
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
        partie = new Partie(new Joueur("Joueur1","a","a"), new Joueur("Joueur2","a","a"));
        affichage_plateau(partie);
    }


    public void affichage_plateau(Partie partietest) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Créer un rectangle pour représenter la case
                Rectangle rect = new Rectangle(65, 65);
                // Alternativement, définir la couleur du rectangle en noir ou blanc
                rect.setFill((i + j) % 2 == 0 ? Color.GREEN : Color.WHITE);
                grid.add(rect, j, i);
                final int row=i;
                final  int col=j;
                rect.setOnMouseClicked(event -> handleMouseClick_rect(row,col));
                // Si une pièce d'échecs est présente à ces coordonnées
                Piece piece = partietest.getPlateau().get(i).get(j);
                if (piece != null) {

                    piece.getImage().setOnMouseClicked(event -> handleMouseClick(row,col));
                    ImageView imageView= piece.getImage();
                    imageView.setFitHeight(65);
                    imageView.setFitWidth(65);
                    grid.add(piece.getImage(), j, i);
                }

                // Ajouter le rectangle à la cellule correspondante du GridPane
            }
        }
    }

    private void handleMouseClick_rect(int row, int col) {
            System.out.println("coucou");
            if (selectedPiece != null) {
                System.out.println("Ligne cliquée : " + row + ", Colonne : " + col);
                deplacer_piece(selectedPiece.getPosition_h(), selectedPiece.getPosition_v(), row, col, selectedPiece);

                // Réinitialisez la pièce sélectionnée
                selectedPiece = null;
                for(int a=0;a<partie.getPlateau().size();a++){
                    for(int b=0;b<partie.getPlateau().get(a).size();b++){
                        if (partie.getPlateau().get(a).get(b)==null){
                            System.out.print("null");
                        }

                        else{
                            System.out.print(partie.getPlateau().get(a).get(b).getNom()+" ");
                        }

                    }
                    System.out.println("");
                }
            }
        }


    private void handleMouseClick(int row, int col) {
        Piece piecedejeu = partie.getPlateau().get(row).get(col);

        System.out.println(partie.isTourdeJeu());

            if (selectedPiece != null && partie.getPlateau().get(row).get(col) != null && !partie.getPlateau().get(row).get(col).getCouleur().equals(selectedPiece.getCouleur())) {
                handleMouseClick_rect(row, col);
            }

            selectedPiece = partie.getPlateau().get(row).get(col);
            System.out.println("Ligne cliquée : " + row + ", Colonne : " + col);

            if (selectedPiece != null) {
                if (selectedPiece.getCouleur().equals("Blanc") && partie.isTourdeJeu() || selectedPiece.getCouleur().equals("Noir") && !partie.isTourdeJeu()) {
                    mvt_possible = partie.mvt_possible(selectedPiece);
                    System.out.println(mvt_possible);
                }


            }


        }





    public void deplacer_piece(int position_h_depart, int position_v_depart, int position_h_arrive, int position_v_arrive, Piece piece) {
        for (int k = 0; k < mvt_possible.size(); k++) {
            if (position_h_arrive == mvt_possible.get(k).get(0) && position_v_arrive == mvt_possible.get(k).get(1)) {
                Piece pieceArrivee = partie.getPlateau().get(position_h_arrive).get(position_v_arrive);
                // Si une pièce est présente à la destination et que c'est une pièce de l'adversaire
                if (pieceArrivee != null && !piece.getCouleur().equals(pieceArrivee.getCouleur())) {
                    System.out.println("Capturing piece at: " + position_h_arrive + ", " + position_v_arrive);
                    grid.getChildren().remove(pieceArrivee.getImage());  // Supprime l'image de la pièce capturée de la grille
                    partie.getPlateau().get(position_h_arrive).set(position_v_arrive, null);  // Supprime la pièce du plateau
                }

                // Déplacer la pièce vers la nouvelle position
                partie.getPlateau().get(position_h_arrive).set(position_v_arrive, piece);
                piece.setPosition_h(position_h_arrive);
                piece.setPosition_v(position_v_arrive);
                partie.getPlateau().get(position_h_depart).set(position_v_depart, null);

                // Mettre à jour l'affichage
                grid.getChildren().remove(piece.getImage());  // Supprime l'image de l'ancienne position
                piece.getImage().setOnMouseClicked(event -> handleMouseClick(position_h_arrive, position_v_arrive));
                ImageView imageView = piece.getImage();
                imageView.setFitHeight(65);
                imageView.setFitWidth(65);
                grid.add(imageView, position_v_arrive, position_h_arrive);
                if(partie.isTourdeJeu()){
                    partie.setTourdeJeu(false);
                }
                else{
                    partie.setTourdeJeu(true);
                }
                partie.estEchec();
                System.out.println(partie.isRoiBEchec());
                System.out.println(partie.isRoiNEchec());
                break;
            }
        }
    }
}