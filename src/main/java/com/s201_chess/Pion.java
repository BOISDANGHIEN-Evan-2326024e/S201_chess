package com.s201_chess;

import javafx.scene.image.ImageView;

public class Pion extends Piece{
    private String couleur="";
    public Pion(String nom, int position_h, int position_v, ImageView image,String couleur) {
        super(nom, position_h, position_v,image);
        this.couleur=couleur;
    }

    public boolean deplacementValide(int position_h, int position_v){
        if(this.getNom().equals("Pion Blanc")){
            if(position_h == this.getPosition_h() && position_v == this.getPosition_v() + 1){
                return true;
            }
        }else{
            if(position_h == this.getPosition_h() && position_v == this.getPosition_v() - 1){
                return true;
            }
        }
        return false;
    }
}
