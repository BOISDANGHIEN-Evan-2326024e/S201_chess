package com.s201_chess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {

    // méthode censée charger le fichier qui fichier
    public static void loadFile(File file) throws IOException {
        // si le fichier n'existe pas, on le crée
        if (!file.exists()) {
            file.createNewFile();
        }
        // on lit le fichier
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            line.split(",");
        }
        reader.close();
    }

    // méthode censée enregistrer des utilisateurs dans la liste
    public static void saveUser(User user) throws IOException {
        String fileName = user.getUsername() + user.getFirstName() + user.getLastName() + ".txt";
        File file = new File(fileName);

        try{
            List<String> lines;
            if (file.exists()) {
                lines = Files.readAllLines(Paths.get(fileName));
                lines = lines.stream().filter(line -> !line.startsWith(user.toString())).collect(Collectors.toList());
            }else{
                lines = new ArrayList<>();
            }
            lines.add(user.toString());
            Files.write(Paths.get(fileName), lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // méthode censée ajouter des utilisateurs dans le fichier sélectionné
    public static void addUser(ArrayList<User> userArrayList, User user) throws IOException {
        if (!userArrayList.contains(user)) {
            userArrayList.add(user);
        }
    }

    // méthode qui vérifie si une ligne du fichier existe déjà
    public static boolean lineAlreadyExists(File file, User user) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file.getName()));
        boolean foundLine = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(user.getUsername())) {
                lines.set(i, " ");
                foundLine = true;
                break;
            }
        }
        return foundLine;
    }
}
