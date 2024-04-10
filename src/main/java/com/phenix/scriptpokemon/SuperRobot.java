package com.phenix.scriptpokemon;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * On veut ajouter des fonctionnalités (ou des raccourcis) pour Robot.
 *
 * @author Edouard
 */
public class SuperRobot extends Robot {

    public final Dialogue dialogue;

    public final Image image;

    public final Deplacement deplacement;

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
    public void press(int touche, int delais) {
        press(touche, delais, null);
    }

    /**
     * Appuie sur une touche.
     *
     * @param touche Touche à appuyer.
     * @param delais Temps où on reste appuyé sur la touche.
     * @param message Si on affiche un message par rapport à cette action.
     */
    public void press(int touche, int delais, String message) {
        if (message != null) {
            System.out.println(message + ", Press : " + touche);
        }
        this.keyPress(touche);
        this.delay(delais);
        this.keyRelease(touche);
    }
}
