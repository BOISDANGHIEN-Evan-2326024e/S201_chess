package com.s201_chess;

import com.s201_chess.Class.Joueur;
import com.s201_chess.Class.Partie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    /**
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 777, 659);
        if (scene != null) {
            scene.getStylesheets().add(getClass().getResource("hello-view.css").toExternalForm());
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Joueur joueur=new Joueur("Joueur1","Prenom1","Nom1","Blanc");
        Joueur joueur2=new Joueur("Joueur2","Prenom2","Nom2","Noir");
        Partie partietest=new Partie(joueur,joueur2);
        for(int i=0;i<partietest.getPlateau().size();i++){
            for(int j=0;j<partietest.getPlateau().get(i).size();j++){
                if (partietest.getPlateau().get(i).get(j)==null){
                    System.out.print("null");
                }

                else{
                    System.out.print(partietest.getPlateau().get(i).get(j).getNom()+" ");
                }

            }
            System.out.println("");
        }
        System.out.println(partietest.getPlateau().get(0).get(0).deplacement_possible());
        System.out.println(partietest.getPlateau().get(1).get(1).deplacement_possible());
        System.out.println(partietest.getPlateau().get(6).get(6).deplacement_possible());
        System.out.println(partietest.getPlateau().get(0).get(3).getNom());
    }

    public static void main(String[] args) {
        launch();
    }
}
