package com.s201_chess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileManager {

    // méthode censée charger le fichier qui fichier
    public static void loadFile(File file/*, User user*/) throws IOException {
        // si le fichier n'existe pas, on le crée
        if (!file.exists()) {
            file.createNewFile();
        }//else {       //ou alors méthode alreadyExists(){}
//            List<String> lines = Files.readAllLines(Paths.get(file.getName()));
//            boolean found = false;
//            for (int i = 0; i < lines.size(); i++) {
//                if (lines.get(i).startsWith(user.getUsername())) {
//                    lines.set(i, "User: username=" + user.getUsername() + ", firstName=" + user.getFirstName() + ", lastName=" + user.getLastName());
//                    found = true;
//                    break;
//                }
//            }
            /*
            Si une ligne du fichier existe déjà{
                la remplace ou l'efface;            // au choix, l'un ou l'autre en fonction de ce qu'on préfère
            }
            sinon{
                il va se faire voir;*/
//            }

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
