package com.phenix.scriptpokemon.choix;

import java.awt.event.KeyEvent;

/**
 * Touches possibles dans le jeu.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public enum Touche {

    /**
     * Touche pour "A".
     */
    A(KeyEvent.VK_W),
    /**
     * Touche pour "B".<br>
     * TODO : A définir.
     *
     * @deprecated
     */
    B(-666),
    /**
     * Touche pour "haut".
     */
    HAUT(KeyEvent.VK_UP),
    /**
     * Touche pour "bas".
     */
    BAS(KeyEvent.VK_DOWN),
    /**
     * Touche pour "gauche".
     */
    GAUCHE(KeyEvent.VK_LEFT),
    /**
     * Touche pour "droite".
     */
    DROITE(KeyEvent.VK_RIGHT),
    /**
     * Touche pour "start".<br>
     * TODO : à définir.
     *
     * @deprecated
     */
    START(-666),
    /**
     * Touche pour "Select".<br>
     * TODO : a définir.
     *
     * @deprecated
     */
    SELECT(-666);

    public final int valeur;

    private Touche(int valeur) {
        this.valeur = valeur;
    }
}
