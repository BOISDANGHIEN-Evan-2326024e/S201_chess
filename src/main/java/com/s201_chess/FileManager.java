package com.s201_chess;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final ArrayList<User> userArrayList = new ArrayList<>();
    private static final File USERS_FILE = new File("users.txt");

    // méthode censée charger le fichier qui fichier
    public static void loadFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
        }
        reader.close();
    }

    // méthode censée enregistrer des utilisateurs dans la liste
    public static void saveUser(ArrayList<User> userArrayList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // méthode censée ajouter des utilisateurs dans la liste
    public static void addUser(ArrayList<User> userArrayList, User user) {
        if (!userArrayList.contains(user)) {
            userArrayList.add(user);
        } else {
            System.out.println("This user already exists: " + user);
        }
    }

}
