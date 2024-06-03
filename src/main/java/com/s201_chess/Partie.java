package com.s201_chess;

import java.util.ArrayList;

public class Partie {
    private int id;
    private int dernierId=0;
    private ArrayList<ArrayList<Piece>> plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.id=dernierId+1;
        dernierId++;
        this.joueur1=joueur1;
        this.joueur2=joueur2;
        Piece Pion_N1=new Piece("Pion",1,0);
        Piece Pion_N2=new Piece("Pion",1,1);
        Piece Pion_N3=new Piece("Pion",1,2);
        Piece Pion_N4=new Piece("Pion",1,3);
        Piece Pion_N5=new Piece("Pion",1,4);
        Piece Pion_N6=new Piece("Pion",1,5);
        Piece Pion_N7=new Piece("Pion",1,6);
        Piece Pion_N8=new Piece("Pion",1,7);
        Piece Tour_N1=new Piece("Tour",0,0);
        Piece Tour_N2=new Piece("Cavalier",0,7);
        Piece Cavalier_N1=new Piece("Cavalier",0,1);
        Piece Cavalier_N2=new Piece("Cavalier",1,6);
        Piece Fou_N1=new Piece("Fou",0,2);
        Piece Fou_N2=new Piece("Fou",0,5);
        Piece Reine_N=new Piece("Reine",0,3);
        Piece Roi_N=new Piece("Roi",0,4);
        Piece Pion_B1=new Piece("Pion",6,0);
        Piece Pion_B2=new Piece("Pion",6,1);
        Piece Pion_B3=new Piece("Pion",6,2);
        Piece Pion_B4=new Piece("Pion",6,3);
        Piece Pion_B5=new Piece("Pion",6,4);
        Piece Pion_B6=new Piece("Pion",6,5);
        Piece Pion_B7=new Piece("Pion",6,6);
        Piece Pion_B8=new Piece("Pion",6,7);
        Piece Tour_B1=new Piece("Tour",7,0);
        Piece Tour_B2=new Piece("Tour",7,7);
        Piece Cavalier_B1=new Piece("Cavalier",7,1);
        Piece Cavalier_B2=new Piece("Cavalier",7,6);
        Piece Fou_B1=new Piece("Fou",7,2);
        Piece Fou_B2=new Piece("Fou",7,5);
        Piece Reine_B=new Piece("Reine",7,3);
        Piece Roi_B=new Piece("Roi",7,4);
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
        ArrayList<ArrayList<Piece>> plateau=new ArrayList<ArrayList<Piece>>();
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
        while (list.size() < 7) {
            list.add(null);
        }
    }

}
