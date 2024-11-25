package com.phenix.scriptpokemon;

import com.phenix.scriptpokemon.choix.Touche;
import java.awt.AWTException;
import java.awt.Robot;

/**
 * On veut ajouter des fonctionnalités (ou des raccourcis) pour Robot.
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public final class SuperRobot extends Robot {

    /**
     *
     */
    public final Dialogue dialogue;

    /**
     *
     */
    public final Image image;

    /**
     *
     */
    public final Deplacement deplacement;

    /**
     *
     * @throws AWTException
     */
    public SuperRobot() throws AWTException {
        super();

        this.dialogue = new Dialogue(this);
        this.image = new Image(this);
        this.deplacement = new Deplacement(this);
    }

    /**
     * Appuie sur une touche.
     *
     * @param touche
     * @param delais
     */
    public void press(Touche touche, int delais) {
        press(touche, delais, null);
    }

    /**
     * Appuie sur une touche.
     *
     * @param touche Touche à appuyer.
     * @param delais Temps où on reste appuyé sur la touche.
     * @param message Si on affiche un message par rapport à cette action.
     */
    public void press(Touche touche, int delais, String message) {
        if (message != null) {
            System.out.println(message + ", Press : " + touche);
        }
        this.keyPress(touche.valeur);
        this.delay(delais);
        this.keyRelease(touche.valeur);
    }
}
