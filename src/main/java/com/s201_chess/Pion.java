package com.s201_chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Pion extends Piece{
    private String couleur="";
    public Pion(String nom, int position_h, int position_v, ImageView image,String couleur) {
        super(nom, position_h, position_v,image);
        this.couleur=couleur;
    }

    public ArrayList<ArrayList<Integer>> deplacement_possible() {
        ArrayList<ArrayList<Integer>> deplacement_possible = new ArrayList<ArrayList<Integer>>();
        int position_x=this.getPosition_h();
        int position_y=this.getPosition_v();
        if(this.couleur=="Blanc" && position_x==6){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_x-1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_x-2);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
        }
        if(this.couleur=="Noir" && position_x==1){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_x+1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_x+2);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
        }
        if(this.couleur=="Blanc" && position_x-1<=0){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_x-1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
        }
        if(this.couleur=="Noir" && position_x+1>7){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_x+1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
        }
        return deplacement_possible;
    }
}
