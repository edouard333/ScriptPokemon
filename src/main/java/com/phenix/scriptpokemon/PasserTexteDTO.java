package com.phenix.scriptpokemon;

/**
 *
 * @author Edouard
 */
public class PasserTexteDTO {

    /**
     * Attend x mili-seconde avant de faire l'action.
     */
    public int delais;

    /**
     * Nom du fichier image qu'on veut.
     */
    public String image;

    /**
     * Message si on veut en afficher un.
     */
    public String message;

    /**
     * Quand on est dans un dialogue, on veut passer au texte suivant.
     *
     * @param delais Délais avant d'appuyer sur la touche.
     */
    public PasserTexteDTO(int delais) {
        this(delais, null, null);
    }

    /**
     * Quand on est dans un dialogue, on veut passer au texte suivant.
     *
     * @param delais Délais avant d'appuyer sur la touche.
     * @param message Si on veut afficher un message dans le débug.
     */
    public PasserTexteDTO(int delais, String message) {
        this(delais, message, null);
    }

    /**
     * Quand on est dans un dialogue, on veut passer au texte suivant.
     *
     * @param delais Délais avant d'appuyer sur la touche.
     * @param message Si on veut afficher un message dans le débug.
     * @param image Si on veut prendre une image du texte actuel.
     */
    public PasserTexteDTO(int delais, String message, String image) {
        this.delais = delais;
        this.message = message;
        this.image = image;
    }
}
