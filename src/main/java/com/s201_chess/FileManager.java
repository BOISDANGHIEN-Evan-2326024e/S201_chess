package com.s201_chess;

import java.io.*;
import java.util.*;

public class FileManager {

    // méthode censée charger le fichier qui fichier
    public static void loadFile(File file) throws IOException {
        // si le fichier n'existe pas, on le crée
        if (!file.exists()) {
            file.createNewFile();
        }else {
            /*
            Si une ligne du fichier existe déjà{
                la remplace ou l'efface;            // au choix, l'un ou l'autre en fonction de ce qu'on préfère
            }
            sinn{
                il va se faire voir;
            }
             */
        }
        //on lit le fichier
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
        }
        reader.close();
    }

    // méthode censée enregistrer des utilisateurs dans la liste
    public static void saveUser(File file, ArrayList<User> userArrayList) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(userArrayList.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // méthode censée ajouter des utilisateurs dans le fichier sélectionné
    public static void addUser(ArrayList<User> userArrayList, User user) throws IOException {
        if (!userArrayList.contains(user)) {
            userArrayList.add(user);
        }
    }
}
