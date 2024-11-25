package com.phenix.scriptpokemon;

import com.phenix.scriptpokemon.choix.Touche;

/**
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public class Deplacement {

    /**
     *
     */
    private final static int DELAIS_DEPLACEMENT = 200;

    /**
     *
     */
    private final SuperRobot robot;

    /**
     *
     * @param robot
     */
    public Deplacement(SuperRobot robot) {
        this.robot = robot;
    }

    /**
     * Déplace le personnage selon la liste de direction indiqué.
     *
     * @param liste_direction
     */
    public void deplacement(Touche[] liste_direction) {
        for (Touche direction : liste_direction) {
            this.robot.press(direction, 100);
            this.robot.delay(DELAIS_DEPLACEMENT);
        }
    }
}
