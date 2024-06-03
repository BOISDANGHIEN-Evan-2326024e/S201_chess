package com.s201_chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Partie {
    private int id;
    private int dernierId=0;
    private ArrayList<ArrayList<Piece>> plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDernierId() {
        return dernierId;
    }

    public void setDernierId(int dernierId) {
        this.dernierId = dernierId;
    }

    public ArrayList<ArrayList<Piece>> getPlateau() {
        return plateau;
    }

    public void setPlateau(ArrayList<ArrayList<Piece>> plateau) {
        this.plateau = plateau;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.id=dernierId+1;
        dernierId++;
        this.joueur1=joueur1;
        this.joueur2=joueur2;
        Piece Pion_N1=new Pion("Pion",1,0,new ImageView("pieces/bb.png"), "Noir");
        /* créer un pion avec une image */
        Piece Pion_N2=new Pion("Pion",1,1,new ImageView("pieces/bb.png"),"Noir");
        Piece Pion_N3=new Pion("Pion",1,2,new ImageView(new Image("/pieces/bp.png")),"Noir");
        Piece Pion_N4=new Pion("Pion",1,3,new ImageView(""), "Noir");
        Piece Pion_N5=new Pion("Pion",1,4,new ImageView("src/main/resources/pieces/" + "bp.png"),"Noir");
        Piece Pion_N6=new Pion("Pion",1,5,new ImageView("src/main/resources/pieces/" + "bp.png"),"Noir");
        Piece Pion_N7=new Pion("Pion",1,6,new ImageView("src/main/resources/pieces/" + "bp.png"),"Noir");
        Piece Pion_N8=new Pion("Pion",1,7,new ImageView("src/main/resources/pieces/" + "bp.png"),"Noir");
        Piece Tour_N1=new Tour("Tour",0,0,new ImageView("src/main/resources/pieces/" + "br.png"));
        Piece Tour_N2=new Tour("Tour",0,7,new ImageView("src/main/resources/pieces/" + "br.png"));
        Piece Cavalier_N1=new Cavalier("Cavalier",0,1,new ImageView("src/main/resources/pieces/" + "bn.png"));
        Piece Cavalier_N2=new Cavalier("Cavalier",0,6,new ImageView("src/main/resources/pieces/" + "bn.png"));
        Piece Fou_N1=new Fou("Fou",0,2,new ImageView("src/main/resources/pieces/" + "bb.png"));
        Piece Fou_N2=new Fou("Fou",0,5,new ImageView("src/main/resources/pieces/" + "bb.png"));
        Piece Reine_N=new Reine("Reine",0,3,new ImageView("src/main/resources/pieces/" + "bq.png"));
        Piece Roi_N=new Roi("Roi",0,4,new ImageView("src/main/resources/pieces/" + "bk.png"));
        Piece Pion_B1=new Pion("Pion",6,0,new ImageView("src/main/resources/pieces/wp.png"),"Blanc");
        Piece Pion_B2=new Pion("Pion",6, 1,new ImageView("src/main/resources/pieces/" + "wp.png"),"Blanc");
        Piece Pion_B3=new Pion("Pion",6,2,new ImageView("src/main/resources/pieces/" + "wp.png"),"Blanc");
        Piece Pion_B4=new Pion("Pion",6,3,new ImageView("src/main/resources/pieces/" + "wp.png"),"Blanc");
        Piece Pion_B5=new Pion("Pion",6,4,new ImageView("src/main/resources/pieces/" + "wp.png"), "Blanc");
        Piece Pion_B6=new Pion("Pion",6,5,new ImageView("src/main/resources/pieces/" + "wp.png"),"Blanc");
        Piece Pion_B7=new Pion("Pion",6,6,new ImageView("src/main/resources/pieces/" + "wp.png"),"Blanc");
        Piece Pion_B8=new Pion("Pion",6,7,new ImageView("src/main/resources/pieces/" + "wp.png"), "Blanc");
        Piece Tour_B1=new Tour("Tour",7,0,new ImageView("src/main/resources/pieces/" + "wr.png"));
        Piece Tour_B2=new Tour("Tour",7,7,new ImageView("src/main/resources/pieces/" + "wr.png"));
        Piece Cavalier_B1=new Cavalier("Cavalier",7,1,new ImageView("src/main/resources/pieces/" + "wn.png"));
        Piece Cavalier_B2=new Cavalier("Cavalier",7,6,new ImageView("src/main/resources/pieces/" + "wn.png"));
        Piece Fou_B1=new Fou("Fou",7,2,new ImageView("src/main/resources/pieces/" + "wb.png"));
        Piece Fou_B2=new Fou("Fou",7,5,new ImageView("src/main/resources/pieces/" + "wb.png"));
        Piece Reine_B=new Reine("Reine",7,3,new ImageView("src/main/resources/pieces/" + "wq.png"));
        Piece Roi_B=new Roi("Roi",7,4,new ImageView("src/main/resources/pieces/" + "wk.png"));
        ArrayList<Piece> Pieces = new ArrayList<Piece>();
        Pieces.add(Pion_N1);
        Pieces.add(Pion_N2);
        Pieces.add(Pion_N3);
        Pieces.add(Pion_N4);
        Pieces.add(Pion_N5);
        Pieces.add(Pion_N6);
        Pieces.add(Pion_N7);
        Pieces.add(Pion_N8);
        Pieces.add(Tour_N1);
        Pieces.add(Tour_N2);
        Pieces.add(Cavalier_N1);
        Pieces.add(Cavalier_N2);
        Pieces.add(Fou_N1);
        Pieces.add(Fou_N2);
        Pieces.add(Reine_N);
        Pieces.add(Roi_N);
        Pieces.add(Pion_B1);
        Pieces.add(Pion_B2);
        Pieces.add(Pion_B3);
        Pieces.add(Pion_B4);
        Pieces.add(Pion_B5);
        Pieces.add(Pion_B6);
        Pieces.add(Pion_B7);
        Pieces.add(Pion_B8);
        Pieces.add(Tour_B1);
        Pieces.add(Tour_B2);
        Pieces.add(Cavalier_B1);
        Pieces.add(Cavalier_B2);
        Pieces.add(Fou_B1);
        Pieces.add(Fou_B2);
        Pieces.add(Reine_B);
        Pieces.add(Roi_B);
        this.plateau=new ArrayList<ArrayList<Piece>>();
        ArrayList<Piece> Ligne1 = new ArrayList<Piece>();
        creer_liste(Ligne1);
        plateau.add(Ligne1);
        ArrayList<Piece> Ligne2 = new ArrayList<Piece>();
        creer_liste(Ligne2);
        plateau.add(Ligne2);
        ArrayList<Piece> Ligne3 = new ArrayList<Piece>();
        creer_liste(Ligne3);
        plateau.add(Ligne3);
        ArrayList<Piece> Ligne4 = new ArrayList<Piece>();
        creer_liste(Ligne4);
        plateau.add(Ligne4);
        ArrayList<Piece> Ligne5 = new ArrayList<Piece>();
        creer_liste(Ligne5);
        plateau.add(Ligne5);
        ArrayList<Piece> Ligne6 = new ArrayList<Piece>();
        creer_liste(Ligne6);
        plateau.add(Ligne6);
        ArrayList<Piece> Ligne7 = new ArrayList<Piece>();
        creer_liste(Ligne7);
        plateau.add(Ligne7);
        ArrayList<Piece> Ligne8 = new ArrayList<Piece>();
        creer_liste(Ligne8);
        plateau.add(Ligne8);
        for (Piece piece : Pieces) {
            plateau.get(piece.getPosition_h()).set(piece.getPosition_v(), piece);
        }
    }

    public void creer_liste(ArrayList<Piece> list){
        while (list.size() < 8) {
            list.add(null);
        }
    }

}
