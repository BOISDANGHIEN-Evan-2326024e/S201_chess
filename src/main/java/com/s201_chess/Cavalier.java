package com.s201_chess;

import javafx.scene.image.ImageView;

public class Cavalier extends Piece{
    public Cavalier(String nom, int position_h, int position_v, ImageView image) {
        super(nom, position_h, position_v,image);
    }

    public boolean deplacementValide(int position_h, int position_v){
        if((Math.abs(position_h - this.getPosition_h()) == 2 && Math.abs(position_v - this.getPosition_v()) == 1) || (Math.abs(position_h - this.getPosition_h()) == 1 && Math.abs(position_v - this.getPosition_v()) == 2)){
            return true;
        }
        return false;
    }
}
