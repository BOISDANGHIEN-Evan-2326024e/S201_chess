package com.s201_chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Cavalier extends Piece{
    public Cavalier(String nom, int position_h, int position_v, ImageView image) {
        super(nom, position_h, position_v,image);
    }

    public ArrayList<ArrayList<Integer>> deplacement_possible(int position_h, int position_v){
        ArrayList<ArrayList<Integer>> deplacement_possible = new ArrayList<ArrayList<Integer>>();
        if(position_h+2<8){
            if(position_v+1<8){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h+2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v+1);
            }
            if(position_v-1>=0){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h+2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-1);
            }
        }
        if(position_h-2>=0){
            if(position_v+1<8){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v+1);
            }
            if(position_v-1>=0){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-1);
            }
        }
        if(position_v+2<8){
            if(position_h+1<8){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
            }
            if(position_h-1>=0){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
            }
        }
        if(position_v-2>=0){
            if(position_h+1<8){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
            }
            if(position_h-1>=0){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
            }
        }
        return deplacement_possible;
    }

}
