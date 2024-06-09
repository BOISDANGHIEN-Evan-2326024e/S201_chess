package com.s201_chess.Class;

import java.util.List;

public class Tournoi {
    private NoeudTournoi racine;

    public Tournoi(List<Joueur> joueurs) {
        construireArbre(joueurs, 0, joueurs.size());
    }
    /**
     * Construit un arbre de tournoi à partir d'une liste de joueurs ( pas fini )
     * @param joueurs
     * @param debut
     * @param fin
     * @return
     */
    private NoeudTournoi construireArbre(List<Joueur> joueurs, int debut, int fin) {
        if (fin - debut == 2) {
            return new NoeudTournoi(new Match(joueurs.get(debut), joueurs.get(debut + 1)));
        } else {
            int milieu = debut + (fin - debut) / 2;
            NoeudTournoi gauche = construireArbre(joueurs, debut, milieu);
            NoeudTournoi droit = construireArbre(joueurs, milieu, fin);
            NoeudTournoi parent = new NoeudTournoi(new Match(gauche.getGagnant(), droit.getGagnant()));
            parent.setEnfants(gauche, droit);
            return parent;
        }
    }

    public Joueur getGagnant() {
        return racine.getGagnant();
    }
}