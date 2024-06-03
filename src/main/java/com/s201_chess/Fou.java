package com.s201_chess;

import javafx.scene.image.ImageView;

public class Fou extends Piece{
    public Fou(String nom, int position_h, int position_v, ImageView image) {
        super(nom, position_h, position_v,image);
    }

    public boolean deplacementValide(int position_h, int position_v){
        if(Math.abs(position_h - this.getPosition_h()) == Math.abs(position_v - this.getPosition_v())){
            return true;
        }
        return false;
    }
}
