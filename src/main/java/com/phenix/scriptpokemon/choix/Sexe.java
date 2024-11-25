package com.phenix.scriptpokemon.choix;

/**
 * Choix des sexe du jeu.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public enum Sexe {

    GARCON(0),
    FILLE(1);

    public final int valeur;

    private Sexe(int valeur) {
        this.valeur = valeur;
    }
}
