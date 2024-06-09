package com.s201_chess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {

    // méthode d'enregistrement des utilisateurs
    public static void saveUser(Joueur joueur) throws IOException {
        String directoryName = "players"; // nom du répertoire pour stocker les fichiers des joueurs
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir(); // crée le répertoire s'il n'existe pas
        }

        String fileName = directoryName + "/" + joueur.getPseudo() + ".txt"; // chemin du fichier du joueur
 // on définit quel nom devra avoir le fichier utilisateur
        File file = new File(fileName); // ensuite on crée le fichier avec le nom définit juste avant

        // ici, les infos de l'utilisateur sont enregistrées dans son propre fichier
        // et s'il rentre ses infos une seconde fois alors on ne réécrit pas ses infos.
        try{
            List<String> lines;
            if (file.exists()) {
                lines = Files.readAllLines(Paths.get(fileName));
                lines = lines.stream().filter(line -> !line.startsWith(joueur.getPseudo())).collect(Collectors.toList());
            }else{
                lines = new ArrayList<>();
                lines.add(joueur.getPseudo());
                lines.add(joueur.getPrenom());
                lines.add(joueur.getNom());
                lines.add(toString(joueur.getNbJoues()));
                lines.add(toString(joueur.getNbVictoires()));
            }

            Files.write(Paths.get(fileName), lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private static String toString(int nbJoues) {
        return Integer.toString(nbJoues);
    }
    // méthodes inutilisées :

    // méthode censée charger le fichier qui fichier
//    public static void loadFile(File file) throws IOException {
//        // si le fichier n'existe pas, on le crée
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        // on lit le fichier
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            line.split(",");
//        }
//        reader.close();
//    }


    // méthode censée ajouter des utilisateurs dans le fichier sélectionné
//    public static void addUser(ArrayList<User> userArrayList, User user) throws IOException {
//        if (!userArrayList.contains(user)) {
//            userArrayList.add(user);
//        }
//    }

    // méthode qui vérifie si une ligne du fichier existe déjà
//    public static boolean lineAlreadyExists(File file, User user) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get(file.getName()));
//        boolean foundLine = false;
//        for (int i = 0; i < lines.size(); i++) {
//            if (lines.get(i).startsWith(user.getUsername())) {
//                lines.set(i, " ");
//                foundLine = true;
//                break;
//            }
//        }
//        return foundLine;
//    }
}
