package com.s201_chess;

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
        Piece Pion_N1=new Pion("Pion",1,0,, "Noir");
        Piece Pion_N2=new Pion("Pion",1,1,,"Noir");
        Piece Pion_N3=new Pion("Pion",1,2,,"Noir");
        Piece Pion_N4=new Pion("Pion",1,3,, "Noir");
        Piece Pion_N5=new Pion("Pion",1,4,,"Noir");
        Piece Pion_N6=new Pion("Pion",1,5,,"Noir");
        Piece Pion_N7=new Pion("Pion",1,6,,"Noir");
        Piece Pion_N8=new Pion("Pion",1,7,,"Noir");
        Piece Tour_N1=new Pion("Tour",0,0);
        Piece Tour_N2=new Pion("Tour",0,7);
        Piece Cavalier_N1=new Cavalier("Cavalier",0,1);
        Piece Cavalier_N2=new Cavalier("Cavalier",0,6);
        Piece Fou_N1=new Fou("Fou",0,2);
        Piece Fou_N2=new Fou("Fou",0,5);
        Piece Reine_N=new Reine("Reine",0,3);
        Piece Roi_N=new Roi("Roi",0,4);
        Piece Pion_B1=new Pion("Pion",6,0,,"Blanc");
        Piece Pion_B2=new Pion("Pion",6,1,,"Blanc");
        Piece Pion_B3=new Pion("Pion",6,2,,"Blanc");
        Piece Pion_B4=new Pion("Pion",6,3,,"Blanc");
        Piece Pion_B5=new Pion("Pion",6,4,, "Blanc");
        Piece Pion_B6=new Pion("Pion",6,5,,"Blanc");
        Piece Pion_B7=new Pion("Pion",6,6,,"Blanc");
        Piece Pion_B8=new Pion("Pion",6,7,, "Blanc");
        Piece Tour_B1=new Tour("Tour",7,0);
        Piece Tour_B2=new Tour("Tour",7,7);
        Piece Cavalier_B1=new Cavalier("Cavalier",7,1);
        Piece Cavalier_B2=new Cavalier("Cavalier",7,6);
        Piece Fou_B1=new Fou("Fou",7,2);
        Piece Fou_B2=new Fou("Fou",7,5);
        Piece Reine_B=new Reine("Reine",7,3);
        Piece Roi_B=new Roi("Roi",7,4);
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
