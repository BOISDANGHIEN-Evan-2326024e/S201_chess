package com.s201_chess;

import java.io.*;
import java.util.*;

public class FileManager {

    // méthode censée charger le fichier qui fichier
    public static void loadFile(File USERS_FILE) throws IOException {
        if (!USERS_FILE.exists()) {
            USERS_FILE.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
        }
        reader.close();
    }

    // méthode censée enregistrer des utilisateurs dans la liste
    public static void saveUser(ArrayList<User> userArrayList) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(String.valueOf(userArrayList));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // méthode censée ajouter des utilisateurs dans la liste
    public static void addUser(ArrayList<User> userArrayList, User user) throws IOException {
        if (!userArrayList.contains(user)) {
            userArrayList.add(user);
        }
    }
}
