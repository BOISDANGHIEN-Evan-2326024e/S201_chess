package com.s201_chess;

import java.util.Objects;

public class Joueur {

        private String pseudo;
        private String prenom;
        private String nom;
        private String couleur;
        private int id;
        private int nbVictoires;
        private int nbJoues;
        private int dernierId=0;
        private boolean isHuman;

    // constructeur créé pour éviter un conflit direct avec LoginController dû à l'ajout de couleur
    public Joueur(String pseudo, String prenom, String nom){
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.nom = nom;
        nbVictoires=0;
        nbJoues=0;
        id=dernierId+1;
        dernierId++;
    }

    public Joueur(String pseudo, String prenom, String nom, String couleur) {
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.nom = nom;
        this.couleur = couleur;
        nbVictoires = 0;
        nbJoues = 0;
        id+=dernierId+1;
        dernierId++;
    }

    public String getPseudo() {
            return pseudo;
        }

    public void setPseudo(String pseudo) {
            this.pseudo = pseudo;
        }

    public String getPrenom() {
            return prenom;
        }

    public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

    public String getNom() {
            return nom;
        }

    public void setNom(String nom) {
            this.nom = nom;
        }

    public int getId() {
            return id;
        }

    public void setId(int id) {
            this.id = id;
        }

    public int getNbVictoires() {
            return nbVictoires;
        }

    public void setNbVictoires(int nbVictoires) {
            this.nbVictoires = nbVictoires;
        }

    public int getNbJoues() {
            return nbJoues;
        }

    public void setNbJoues(int nbJoues) {
            this.nbJoues = nbJoues;
        }

    public boolean isHuman() {return isHuman;}

    public void setHuman(boolean human) {isHuman = human;}

    // Redéfinition de equals et hashCode pour comparer les joueurs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur that = (Joueur) o;
        return Objects.equals(pseudo, that.pseudo) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo, prenom, nom);
    }

    // redéfinition du toString pour Joueur
    @Override
    public String toString() {
        return "Joueur: pseudo=" + pseudo + ", prenom=" + prenom + ", nom=" + nom;
    }

    public String getCouleur() {return couleur;}
}
