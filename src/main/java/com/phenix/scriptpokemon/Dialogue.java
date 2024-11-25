package com.phenix.scriptpokemon;

import com.phenix.scriptpokemon.choix.Touche;

/**
 * Gestion des dialogues.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public final class Dialogue {

    /**
     *
     */
    private final static int DELAIS_TOUCHE = 200;

    /**
     * Le robot qui fait les actions.
     */
    private final SuperRobot robot;

    /**
     * Si on prend des images.
     */
    private final Image image;

    /**
     * Initialise pour l'automatisation des dialogue.
     *
     * @param robot
     */
    public Dialogue(SuperRobot robot) {
        this.robot = robot;

        this.image = new Image(robot);
    }

    /**
     * Automatise le passage de dialogue.
     *
     * @param texte Les actions pour ce dialogue.
     */
    public void dialogue(PasserTexteDTO[] texte) {
        for (PasserTexteDTO texte1 : texte) {
            robot.delay(texte1.delais);
            if (texte1.image != null) {
                this.image.getImage(texte1.image);
            }
            this.robot.press(Touche.A, DELAIS_TOUCHE, texte1.message);
        }
    }
}
