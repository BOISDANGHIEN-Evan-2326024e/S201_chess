package com.s201_chess.Class;

public class NoeudTournoi {
    private Match match;
    private NoeudTournoi parent;
    private NoeudTournoi enfantGauche;
    private NoeudTournoi enfantDroit;

    public NoeudTournoi(Match match) {
        this.match = match;
    }

    public void setEnfants(NoeudTournoi enfantGauche, NoeudTournoi enfantDroit) {
        this.enfantGauche = enfantGauche;
        this.enfantDroit = enfantDroit;
    }

    public Joueur getGagnant() {
        return match.getGagnant();
    }
}