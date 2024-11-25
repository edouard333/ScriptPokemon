package com.phenix.scriptpokemon.choix;

/**
 * Choix des noms par défaut dans le jeu.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public enum Nom {

    INC0(0),
    INC1(1),
    INC2(2),
    JEAN(3);

    public final int valeur;

    private Nom(int valeur) {
        this.valeur = valeur;
    }
}
