package com.s201_chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Roi extends Piece{
    public Roi(String nom, int position_h, int position_v, ImageView image,String couleur) {
        super(nom, position_h, position_v,image,couleur);
    }

    public ArrayList<ArrayList<Integer>> deplacement_possible() {
        ArrayList<ArrayList<Integer>> deplacement_possible = new ArrayList<ArrayList<Integer>>();
        int position_h=this.getPosition_h();
        int position_v=this.getPosition_v();
        if(position_h+1<8){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v);
        }
        if(position_h-1>=0){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v);
        }
        if(position_v+1<8){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v+1);
        }
        if(position_v-1>=0){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v-1);
        }
        if(position_h+1<8 && position_v+1<8){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v+1);
        }
        if(position_h+1<8 && position_v-1>=0){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v-1);
        }
        if(position_h-1>=0 && position_v+1<8){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v+1);
        }
        if(position_h-1>=0 && position_v-1>=0){
            deplacement_possible.add(new ArrayList<Integer>());
            deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
            deplacement_possible.get(deplacement_possible.size()-1).add(position_v-1);
        }
        return deplacement_possible;
    }
}
