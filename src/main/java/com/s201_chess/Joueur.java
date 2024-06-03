package com.s201_chess;

public class Joueur {

        private String pseudo;
        private String prenom;
        private String nom;
        private int id;
        private  int nbVictoires;
        private  int nbJoues;
        private  int dernierId=0;

        public Joueur(String pseudo, String prenom, String nom){
            this.pseudo = pseudo;
            this.prenom = prenom;
            this.nom = nom;
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

}
