package com.s201_chess;

import java.util.ArrayList;

// sous-classe de ArrayList pour redéfinir le toString de la classe
public class UserList extends ArrayList<User> {
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(User user : this){
            str.append(user.toString());
            str.append("\n");
        }
        return str.toString();
    }
}
