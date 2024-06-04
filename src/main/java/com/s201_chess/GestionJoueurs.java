package com.s201_chess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionJoueurs {
    private List<Joueur> joueurs;
    private final String fichier = "joueurs.csv";

    public GestionJoueurs() {
        joueurs = new ArrayList<>();
        lireFichier();
    }

    public void ajouterJoueur(Joueur joueur) {
        joueurs.add(joueur);
        sauvegarderFichier();
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public boolean pseudoExiste(String pseudo) {
        for (Joueur joueur : joueurs) {
            if (joueur.getPseudo().equalsIgnoreCase(pseudo)) {
                return true;
            }
        }
        return false;
    }

    private void sauvegarderFichier() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            for (Joueur joueur : joueurs) {
                writer.write(joueur.getId() + "," + joueur.getPseudo() + "," + joueur.getPrenom() + "," + joueur.getNom() + "," +
                        joueur.getNbVictoires() + "," + joueur.getNbJoues());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lireFichier() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(",");
                if (parts.length == 6) {
                    Joueur joueur = new Joueur(parts[1], parts[2], parts[3]);
                    joueur.setId(Integer.parseInt(parts[0]));
                    joueur.setNbVictoires(Integer.parseInt(parts[4]));
                    joueur.setNbJoues(Integer.parseInt(parts[5]));
                    joueurs.add(joueur);
                }
            }
        } catch (FileNotFoundException e) {
            // Fichier non trouvé, pas de souci, ce sera créé lors de la première sauvegarde
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}