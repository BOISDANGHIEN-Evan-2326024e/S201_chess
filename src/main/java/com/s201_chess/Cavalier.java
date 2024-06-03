package com.s201_chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Cavalier extends Piece{
    public Cavalier(String nom, int position_h, int position_v, ImageView image) {
        super(nom, position_h, position_v,image);
    }

    public ArrayList<ArrayList<Integer>> deplacement_possible(){
        ArrayList<ArrayList<Integer>> deplacement_possible = new ArrayList<ArrayList<Integer>>();
        int position_h=this.getPosition_h();
        int position_v=this.getPosition_v();
        if(position_h+2<8){
            System.out.println("position_h+2<8");
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
            System.out.println("caca");
            if(position_v+1<8){
                System.out.println("position_h-2>=0");
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v+1);
            }
            if(position_v-1>=0){
                System.out.println("position_h-2>=0!!!!");
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-2);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-1);
            }
        }
        if(position_v+2<8){
            System.out.println("pipi");
            if(position_h+1<8){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v+2);

            }
            if(position_h-1>=0){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v+2);

            }
        }
        if(position_v-2>=0){
            System.out.println("prout");
            if(position_h+1<8){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h+1);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-2);

            }
            if(position_h-1>=0){
                deplacement_possible.add(new ArrayList<Integer>());
                deplacement_possible.get(deplacement_possible.size()-1).add(position_h-1);
                deplacement_possible.get(deplacement_possible.size()-1).add(position_v-2);

            }
        }
        return deplacement_possible;
    }

}
