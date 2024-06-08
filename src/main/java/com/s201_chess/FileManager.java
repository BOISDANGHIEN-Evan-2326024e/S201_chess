package com.s201_chess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {

    // méthode d'enregistrement des utilisateurs
    public static void saveUser(Joueur joueur) throws IOException {
        String fileName = joueur.getPseudo() + joueur.getPrenom() + joueur.getNom() + ".txt"; // on définit quel nom devra avoir le fichier utilisateur
        File file = new File(fileName); // ensuite on crée le fichier avec le nom définit juste avant

        // ici, les infos de l'utilisateur sont enregistrées dans son propre fichier
        // et s'il rentre ses infos une seconde fois alors on ne réécrit pas ses infos.
        try{
            List<String> lines;
            if (file.exists()) {
                lines = Files.readAllLines(Paths.get(fileName));
                lines = lines.stream().filter(line -> !line.startsWith(joueur.toString())).collect(Collectors.toList());
            }else{
                lines = new ArrayList<>();
            }
            lines.add(joueur.toString());
            Files.write(Paths.get(fileName), lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
