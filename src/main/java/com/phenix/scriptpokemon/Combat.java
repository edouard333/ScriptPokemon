package com.phenix.scriptpokemon;

import com.phenix.scriptpokemon.choix.Touche;

/**
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public final class Combat {

    /**
     * Numéro de combat, juste utile quand on veut faire des printscreens.
     */
    private int numero_combat;

    /**
     *
     */
    private final SuperRobot robot;

    /**
     *
     */
    private final Image image;

    /**
     *
     * @param robot
     */
    public Combat(SuperRobot robot) {
        this.robot = robot;
        this.numero_combat = 0;
        this.image = new Image(robot);
    }

    /**
     * Si on entre dans la fonction, c'est qu'on sait qu'il y a un combat.
     */
    public void combat() {
        this.robot.delay(9000); // Délais animation.

        numero_combat++;

        image.getImage("_combat_" + numero_combat + "_pokemon");
        // traitement image : Quel Pokémon adverse ?
        this.robot.press(Touche.A, 200, "apparait");

        this.robot.delay(4500); // Délais animation + son.

        for (int i = 0; i < 8; i++) {
            // traitement image : PV pokémon adverse + nous (savoir PP chez nous).

            // Choix : ATK, PKM, SAC, FUITE (curseur sur ATK).
            this.robot.press(Touche.A, 200, "ATK");
            this.robot.delay(700);
            this.robot.press(Touche.A, 200, "CHARGE");

            this.robot.delay(1900);
            this.robot.press(Touche.A, 200, "pokemon lance (a)");

            robot.delay(4400); // ATK, animation et dialogue réposte (s'il y a).
            this.robot.press(Touche.A, 200, "pokemon ennemi lance (a)");

            this.robot.delay(3300); // ATK ennemie + animation + son.
        }

        // Fin du combat :
        // Info PV + gain niveau + évolution...
    }
}
