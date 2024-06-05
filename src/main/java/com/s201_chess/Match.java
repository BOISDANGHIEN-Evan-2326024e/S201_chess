package com.s201_chess;

public class Match {
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur gagnant;

    public Match(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public void jouerMatch() {
        // Ajoutez ici la logique pour déterminer le gagnant
        // Pour cet exemple, nous choisissons un gagnant au hasard
        gagnant = Math.random() < 0.5 ? joueur1 : joueur2;
    }

    public Joueur getGagnant() {
        if (gagnant == null) {
            jouerMatch();
        }
        return gagnant;
    }
}
