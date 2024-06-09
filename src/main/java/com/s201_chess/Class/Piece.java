package com.s201_chess.Class;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Piece {
    private String nom;
    private int position_h;
    private int position_v;
    private ImageView image;
    private String couleur="";

    public Piece(String nom, int position_h, int position_v, ImageView image,String couleur) {
        this.nom = nom;
        this.position_h = position_h;
        this.position_v = position_v;
        this.image = image;
        this.couleur=couleur;
    }

    public int getPosition_h() {
        return position_h;
    }

    public void setPosition_h(int position_h) {
        this.position_h = position_h;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPosition_v() {
        return position_v;
    }

    public void setPosition_v(int position_v) {
        this.position_v = position_v;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    /**
     * Liste tout les déplacements possibles pour une pièce depuis sa position actuelle
     * @return deplacement_possible
     */
    public ArrayList<ArrayList<Integer>>  deplacement_possible() {
        ArrayList<ArrayList<Integer>> deplacement_possible = new ArrayList<ArrayList<Integer>>();
        return deplacement_possible;
    }
}
