package com.phenix.scriptpokemon.choix;

/**
 * Choix des starters du jeu.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public enum Starter {

    HERICENDRE(0),
    GERMIGNON(1),
    KAIMINUS(2);

    public final int valeur;

    private Starter(int valeur) {
        this.valeur = valeur;
    }
}
