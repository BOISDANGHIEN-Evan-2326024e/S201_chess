package com.s201_chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Objects;

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
        Pion Pion_N2=new Pion("Pion",1,1,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Pion Pion_N1=new Pion("Pion",1,0,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Pion Pion_N3=new Pion("Pion",1,2,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Pion Pion_N4=new Pion("Pion",1,3,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()), "Noir");
        Pion Pion_N5=new Pion("Pion",1,4,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Pion Pion_N6=new Pion("Pion",1,5,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Pion Pion_N7=new Pion("Pion",1,6,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Pion Pion_N8=new Pion("Pion",1,7,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bp.png")).toExternalForm()),"Noir");
        Tour Tour_N1=new Tour("Tour",0,0,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/br.png")).toExternalForm()),"Noir");
        Tour Tour_N2=new Tour("Tour",0,7,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/br.png")).toExternalForm()),"Noir");
        Cavalier Cavalier_N1=new Cavalier("Cavalier",0,1,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bn.png")).toExternalForm()),"Noir");
        Cavalier Cavalier_N2=new Cavalier("Cavalier",0,6,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bn.png")).toExternalForm()),"Noir");
        Fou Fou_N1=new Fou("Fou",0,2,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bb.png")).toExternalForm()),"Noir");
        Fou Fou_N2=new Fou("Fou",0,5,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bb.png")).toExternalForm()),"Noir");
        Reine Reine_N=new Reine("Reine",0,3,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bq.png")).toExternalForm()),"Noir");
        Roi Roi_N=new Roi("Roi",0,4,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/bk.png")).toExternalForm()),"Noir");
        Pion Pion_B1=new Pion("Pion",6,0,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()),"Blanc");
        Pion Pion_B2=new Pion("Pion",6, 1,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()),"Blanc");
        Pion Pion_B3=new Pion("Pion",6,2,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()),"Blanc");
        Pion Pion_B4=new Pion("Pion",6,3,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()),"Blanc");
        Pion Pion_B5=new Pion("Pion",6,4,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()), "Blanc");
        Pion Pion_B6=new Pion("Pion",6,5,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()),"Blanc");
        Pion Pion_B7=new Pion("Pion",6,6,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()),"Blanc");
        Pion Pion_B8=new Pion("Pion",6,7,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wp.png")).toExternalForm()), "Blanc");
        Tour Tour_B1=new Tour("Tour",7,0,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wr.png")).toExternalForm()),"Blanc");
        Tour Tour_B2=new Tour("Tour",7,7,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wr.png")).toExternalForm()),"Blanc");
        Cavalier Cavalier_B1=new Cavalier("Cavalier",7,1,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wn.png")).toExternalForm()),"Blanc");
        Cavalier Cavalier_B2=new Cavalier("Cavalier",7,6,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wn.png")).toExternalForm()),"Blanc");
        Fou Fou_B1=new Fou("Fou",7,2,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wb.png")).toExternalForm()),"Blanc");
        Fou Fou_B2=new Fou("Fou",7,5,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wb.png")).toExternalForm()),"Blanc");
        Reine Reine_B=new Reine("Reine",7,3,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wq.png")).toExternalForm()),"Blanc");
        Roi Roi_B=new Roi("Roi",7,4,new ImageView(Objects.requireNonNull(getClass().getResource("/pieces/wk.png")).toExternalForm()),"Blanc");
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

    public void deplacer_piece(int position_h_depart, int position_v_depart,int position_h_arrive,int position_v_arrive,ArrayList<ArrayList<Integer>> liste_mvt,Piece piece){
        for(int k=0;k<liste_mvt.size();k++){
            if(position_h_arrive==liste_mvt.get(k).get(0) && position_v_arrive==liste_mvt.get(k).get(1)){
                this.plateau.get(liste_mvt.get(k).get(0)).set(liste_mvt.get(k).get(1),piece);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> mvt_possible(Piece piece){
            ArrayList<ArrayList<Integer>> deplacement_theorique=piece.deplacement_possible();
            for(int n=0;n<deplacement_theorique.size();n++){
                if(plateau.get(deplacement_theorique.get(n).get(0)).get(deplacement_theorique.get(n).get(0))!=null){
                    deplacement_theorique.remove(n);
                }
            }
            return deplacement_theorique;
    }

}
