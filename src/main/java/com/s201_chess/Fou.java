package com.s201_chess;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Fou extends Piece{
    public Fou(String nom, int position_h, int position_v, ImageView image) {
        super(nom, position_h, position_v,image);
    }


    public ArrayList<ArrayList<Integer>> deplacement_possible() {
        ArrayList<ArrayList<Integer>> deplacement_possible = new ArrayList<ArrayList<Integer>>();
        for(int k=0;k<4;k++){
           int position_x=this.getPosition_h();
           int position_y=this.getPosition_v();
           while(position_x<8 && position_x>=0 && position_y<8 && position_y>=0){
               if (position_x != this.getPosition_h() || position_y != this.getPosition_v()){
                   deplacement_possible.add(new ArrayList<Integer>());
                   deplacement_possible.get(deplacement_possible.size()-1).add(position_x);
                   deplacement_possible.get(deplacement_possible.size()-1).add(position_y);
               }
               if(k==0){
                     position_x++;
                     position_y++;
               }
                if(k==1) {
                    position_x++;
                    position_y--;
                }
                if(k==2) {
                    position_x--;
                    position_y++;
                }
                if(k==3) {
                    position_x--;
                    position_y--;
                }

           }
        }
        return deplacement_possible;
    }
}
