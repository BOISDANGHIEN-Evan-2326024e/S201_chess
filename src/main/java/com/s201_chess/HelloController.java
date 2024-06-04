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
        grid.setOnMouseClicked(event -> {
            System.out.println("coucou");
            if (selectedPiece != null) {
                // Calculez la nouvelle position en fonction de la position du clic
                System.out.println(selectedPiece.getNom());

                double grid_position=grid.getLayoutX();
                System.out.println(grid_position);
                System.out.println(event.getX());
                System.out.println(grid.getLayoutY());
                int caseX = (int) ((event.getY()) / 65);
                int caseY = (int) (event.getX() / 65);
                System.out.println(caseX+ " "+caseY);
                deplacer_piece(selectedPiece.getPosition_h(), selectedPiece.getPosition_v(), caseX, caseY,selectedPiece,caseX,caseY);





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
                        mvt_possible=partietest.mvt_possible(selectedPiece);
                        System.out.println(mvt_possible);
                        event.consume();
                    });

                    grid.add(image, j, i);
                }

                // Ajouter le rectangle à la cellule correspondante du GridPane
            }
        }
    }

    public void deplacer_piece(int position_h_depart, int position_v_depart,int position_h_arrive,int position_v_arrive,Piece piece,int caseX,int caseY){

        for(int k=0;k<mvt_possible.size();k++){
            System.out.println(" "+position_h_arrive+" "+mvt_possible.get(k).get(0)+" "+position_v_arrive+mvt_possible.get(k).get(1));
            if(position_h_arrive==mvt_possible.get(k).get(0) && position_v_arrive==mvt_possible.get(k).get(1)){
                partie.getPlateau().get(mvt_possible.get(k).get(0)).set(mvt_possible.get(k).get(1),piece);
                piece.setPosition_h(mvt_possible.get(k).get(0));
                piece.setPosition_v(mvt_possible.get(k).get(1));
                partie.getPlateau().get(position_h_depart).set(position_v_depart,null);
                System.out.println("aaa");
                grid.getChildren().remove(selectedPiece.getImage());
                grid.add(selectedPiece.getImage(), caseX, caseY);
            }
        }
    }

}