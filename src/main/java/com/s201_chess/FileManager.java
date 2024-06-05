package com.s201_chess;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final ArrayList<User> userArrayList = new ArrayList<>();
    private static final File FICHIER_UTILISATEURS = new File("users.txt");

    public static void loadFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
        }
        reader.close();
    }

    public static void saveUser(ArrayList<User> userArrayList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHIER_UTILISATEURS))) {
            oos.writeObject(userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(ArrayList<User> userArrayList, User user) {
        if (!userArrayList.contains(user)) {
            userArrayList.add(user);
        } else {
            System.out.println("This user already exists: " + user);
        }
    }

}
