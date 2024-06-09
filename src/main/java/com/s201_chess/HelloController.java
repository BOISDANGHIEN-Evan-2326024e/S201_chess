package com.s201_chess;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class HelloController {
    private Piece selectedPiece = null;
    private ArrayList<ArrayList<Integer>> mvt_possible;
    private Partie partie;
    private Joueur joueur1;
    private Joueur joueur2;
    @FXML
    private ImageView blackPP;
    @FXML
    private Label pseudoBlanc;
    @FXML
    private Label pseudoNoir;
    @FXML
    private ImageView whitePP;
    @FXML
    private GridPane grid;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label tpsRestantBlanc;
    @FXML
    private Label tpsRestantNoir;
    @FXML
    private Button bouton1;

    @FXML
    private Button bouton2;
    @FXML
    private Button boutonArreter;
    private Timeline timerNoir;
    private Timeline timerBlanc;
    private int tempsRestantNoir = 10 * 60; // 10 minutes en secondes
    private int tempsRestantBlanc = 10 * 60; // 10 minutes en secondes
    private boolean isDeplacementAutorise = false;




    public void initialize() {
        joueur1=LoginController.getJoueur_actuelle();
        pseudoBlanc.setText(joueur1.getPseudo());
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
        partie = new Partie(joueur1, joueur2);
        affichage_plateau(partie);
        choiceBox.getItems().add("5 Minutes");
        choiceBox.getItems().add("10 Minutes");
        choiceBox.getItems().add("15 Minutes");

        // Sélection par défaut
        choiceBox.getSelectionModel().selectFirst();

        // Ajoutez un écouteur pour gérer les événements de sélection d'éléments
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                    System.out.println("Selected item: " + newValue);
            // Ajoutez ici le code pour gérer la sélection d'un nouvel élément
        });

        // Initialisation des minuteurs pour les deux joueurs
        timerNoir = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer(tpsRestantNoir, true)));
        timerNoir.setCycleCount(Timeline.INDEFINITE);

        timerBlanc = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer(tpsRestantBlanc, false)));
        timerBlanc.setCycleCount(Timeline.INDEFINITE);

        bouton1.setOnAction(event -> promptPlayerSelection());
        bouton2.setOnAction(event -> jouerContreOrdinateur());
        boutonArreter.setOnAction(event -> stopTimers());
        File monRepertoire=new File("images");
        File[] f = monRepertoire.listFiles();
        System.out.print(Arrays.toString(f));

    }
    private void jouerContreOrdinateur() {
        joueur2.setHuman(false);
        System.out.println("Jouer contre l'ordinateur");
        startTimers();

    }
    private void promptPlayerSelection() {
        List<String> choices = new ArrayList<>();
        Path dir = Paths.get("players");
        try (Stream<Path> paths = Files.walk(dir)) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            String pseudo = Files.lines(path).findFirst().orElse("");
                            choices.add(pseudo);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        choices.add("Invité");
        File monRepertoire=new File("images");
        File[] f = monRepertoire.listFiles();
        System.out.print(Arrays.toString(f));

// Ici, x vaut le nombre de fichiers contenus dans monRepertoire.


        ChoiceDialog<String> dialog = new ChoiceDialog<>("Invité", choices);
        dialog.setTitle("Sélection du joueur");
        //dialog.setHeaderText("Sélectionnez contre qui vous voulez jouer");
        dialog.setContentText("Choisissez le joueur:");

        String directoryName = "players"; // Le répertoire où se trouvent les fichiers des joueurs
        joueur2= new Joueur("Joueur2", "Prenom2", "Nom2", "Noir");
        Optional<String> result = dialog.showAndWait();
        System.out.println("Résultat: " + result);
        String nom=result.get();
            String fileName = directoryName + "/" + nom + ".txt";
            File playerFile = new File(fileName);
            if (playerFile.exists()) {

                try {
                    List<String> lines = Files.readAllLines(playerFile.toPath());
                    int compteur=0;
                    for (String line : lines) {
                        if(compteur==0){
                            joueur2.setPseudo(line);
                        }
                        if(compteur==1){
                            joueur2.setPrenom(line);
                        }
                        if(compteur==2){
                            joueur2.setNom(line);
                        }
                        if(compteur==3){
                            joueur2.setCouleur("Noir");
                            joueur2.setNbJoues(Integer.parseInt(line));
                        }
                        if(compteur==4){
                            joueur2.setNbVictoires(Integer.parseInt(line));
                        }
                        compteur++;
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        // Si l'utilisateur a cliqué sur OK, alors on récupère le résultat
            pseudoNoir.setText(joueur2.getPseudo());
            startTimers();
        };



    private void startTimers() {
        // Lire la valeur sélectionnée dans la ChoiceBox
        String selectedTime = choiceBox.getSelectionModel().getSelectedItem();
        int initialTimeInSeconds;

        switch (selectedTime) {
            case "5 Minutes":
                initialTimeInSeconds = 5 * 60;
                break;
            case "10 Minutes":
                initialTimeInSeconds = 10 * 60;
                break;
            case "15 Minutes":
                initialTimeInSeconds = 15 * 60;
                break;
            default:
                initialTimeInSeconds = 10 * 60; // Valeur par défaut
        }

        // Réinitialiser les temps restants en fonction de la valeur sélectionnée
        tempsRestantNoir = initialTimeInSeconds;
        tempsRestantBlanc = initialTimeInSeconds;

        // Mettre à jour les labels pour afficher les temps initiaux
        updateTimerLabel(tpsRestantNoir, tempsRestantNoir);
        updateTimerLabel(tpsRestantBlanc, tempsRestantBlanc);

        // Démarrer uniquement le timer du joueur blanc au début
        timerBlanc.play();

        // Faire disparaître les boutons et la choiceBox
        bouton1.setVisible(false);
        bouton2.setVisible(false);
        choiceBox.setVisible(false);

        // Afficher le bouton "arrêter"
        boutonArreter.setVisible(true);
        // Autoriser les déplacements
        isDeplacementAutorise = true;
    }
    private void stopTimers() {
        // Mettre en pause les minuteurs
        timerNoir.stop();
        timerBlanc.stop();

        // Réinitialiser les temps restants
        tempsRestantNoir = 10 * 60;
        tempsRestantBlanc = 10 * 60;
        updateTimerLabel(tpsRestantNoir, tempsRestantNoir);
        updateTimerLabel(tpsRestantBlanc, tempsRestantBlanc);

        // Faire réapparaître les boutons et la choiceBox
        bouton1.setVisible(true);
        bouton2.setVisible(true);
        choiceBox.setVisible(true);

        // Cacher le bouton "arrêter"
        boutonArreter.setVisible(false);
          // Interdire les déplacements
        isDeplacementAutorise = false;
        partie = new Partie(joueur1, joueur2);
        affichage_plateau(partie);
    }

    private void updateTimer(Label label, boolean isBlackTimer) {
        String[] parts = label.getText().split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        if (seconds == 0) {
            if (minutes == 0) {
                // Arrêtez le jeu car le temps est écoulé
                stopTimers();
                return;
            } else {
                minutes--;
                seconds = 59;
            }
        } else {
            seconds--;
        }

        label.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private void updateTimerLabel(Label label, int tempsRestant) {
        int minutes = tempsRestant / 60;
        int secondes = tempsRestant % 60;
        label.setText(String.format("%02d:%02d", minutes, secondes));
    }

    public void showWinnerPopup(String winnerName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de la partie");
        alert.setHeaderText(null);
        alert.setContentText("Le joueur " + winnerName + " a gagné la partie!");

        alert.showAndWait();
    }

    public void affichage_plateau(Partie partietest) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Créer un rectangle pour représenter la case
                Rectangle rect = new Rectangle(65, 65);
                // Alternativement, définir la couleur du rectangle en noir ou blanc
                rect.setFill((i + j) % 2 == 0 ? Color.valueOf("ebecd0") : Color.valueOf("739552"));
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
        if (!isDeplacementAutorise) return;
            if(selectedPiece.getCouleur().equals("Noir") && !partie.getJoueurObjetParCouleur("Noir").isHuman()){
                selectedPiece = getRandomBlackPiece();
            }
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
        if (!isDeplacementAutorise) return;
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

                }


            }


        }





    public void deplacer_piece(int position_h_depart, int position_v_depart, int position_h_arrive, int position_v_arrive, Piece piece) {
        if(piece.getCouleur().equals("Blanc") || partie.getJoueurObjetParCouleur("Noir").isHuman()){
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
                    timerBlanc.stop();
                    timerNoir.play();
                    partie.setTourdeJeu(false);
                }
                else{
                    timerNoir.stop();
                    timerBlanc.play();
                    partie.setTourdeJeu(true);
                }
                partie.estEchec();
                if(partie.isRoiBEchec()){
                    partie.endgame("Blanc");
                    String pseudo = joueur2.getPseudo(); // Remplacez ceci par le pseudo du joueur
                    String directoryName = "players"; // Le répertoire où se trouvent les fichiers des joueurs
                    String fileName = directoryName + "/" + pseudo + ".txt"; // Le chemin du fichier du joueur

                    File playerFile = new File(fileName);
                    int lineNumber = 3;
                    int lineNumber2 = 4;// Remplacez ceci par le numéro de ligne que vous voulez modifier
                    String newLineContent = "Nouveau contenu"; // Remplacez ceci par le nouveau contenu de la ligne

                    try {
                        List<String> lines = Files.readAllLines(Paths.get(fileName));

                        // Vérifiez si le numéro de ligne est valide
                        if (lineNumber >= 0 && lineNumber < lines.size()) {
                            lines.set(lineNumber, newLineContent);
                            Files.write(Paths.get(fileName), lines);
                        } else {
                            System.out.println("Numéro de ligne invalide.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    showWinnerPopup("Noir");
                    stopTimers();

                }
                if(partie.isRoiNEchec()){
                    partie.endgame("Noir");
                    showWinnerPopup("Blanc");
                    stopTimers();
                }
            }
        }
        }
        else{
            Random rand = new Random();
            if (!mvt_possible.isEmpty()) {
                int randomIndex = rand.nextInt(mvt_possible.size());
                ArrayList<Integer> randomMove = mvt_possible.get(randomIndex);

                // Déplacer la pièce vers la nouvelle position
                int newPosition_h = randomMove.get(0);
                int newPosition_v = randomMove.get(1);
                partie.getPlateau().get(newPosition_h).set(newPosition_v, piece);
                piece.setPosition_h(newPosition_h);
                piece.setPosition_v(newPosition_v);
                partie.getPlateau().get(position_h_depart).set(position_v_depart, null);

                // Mettre à jour l'affichage
                grid.getChildren().remove(piece.getImage());  // Supprime l'image de l'ancienne position
                ImageView imageView = piece.getImage();
                imageView.setFitHeight(65);
                imageView.setFitWidth(65);
                grid.add(imageView, newPosition_v, newPosition_h);
                if(partie.isTourdeJeu()){
                    timerBlanc.stop();
                    timerNoir.play();
                    partie.setTourdeJeu(false);
                }
                else{
                    timerNoir.stop();
                    timerBlanc.play();
                    partie.setTourdeJeu(true);
                }
            }
        }
    }
    public Piece getRandomBlackPiece() {
        List<Piece> piecesNoires = new ArrayList<>();
        for(int i=0; i<partie.getPlateau().size(); i++){
            for(int j=0; j<partie.getPlateau().get(i).size(); j++){
                if(partie.getPlateau().get(i).get(j) != null && partie.getPlateau().get(i).get(j).getCouleur().equals("Noir")){
                    piecesNoires.add(partie.getPlateau().get(i).get(j));
                }
            }
        }
        Random rand = new Random();
        return piecesNoires.get(rand.nextInt(piecesNoires.size()));
    }

}