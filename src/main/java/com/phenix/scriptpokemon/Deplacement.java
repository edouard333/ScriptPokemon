package com.phenix.scriptpokemon;

/**
 *
 * @author Edouard
 */
public class Deplacement {

    private final static int DELAIS_DEPLACEMENT = 200;

    private final SuperRobot robot;

    public Deplacement(SuperRobot robot) {
        this.robot = robot;
    }

    /**
     * Déplace le personnage selon la liste de direction indiqué.
     *
     * @param liste_direction
     */
    public void deplacement(int[] liste_direction) {
        for (int i = 0; i < liste_direction.length; i++) {
            this.robot.press(liste_direction[i], 100);
            this.robot.delay(DELAIS_DEPLACEMENT);
        }
    }
}
