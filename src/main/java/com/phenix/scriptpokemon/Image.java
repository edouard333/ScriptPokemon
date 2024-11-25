package com.phenix.scriptpokemon;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public final class Image {

    /**
     *
     */
    private static final String DOSSIER = "C:\\_OUTPUT\\";

    /**
     *
     */
    private final SuperRobot robot;

    /**
     *
     * @param robot
     */
    public Image(SuperRobot robot) {
        this.robot = robot;
    }

    /**
     * Récupère une couleur d'un pixel.
     *
     * @param argb
     */
    public static void getRGB(int argb) {
        Color color = new Color(argb);

        //System.out.println(color.getAlpha() + ", " + color.getRed() + " " + color.getGreen() + " " + color.getBlue());
    }

    /**
     * Récupère l'image actuelle de l'écran.
     *
     * @param nom_image
     */
    public void getImage(String nom_image) {
        BufferedImage bi = this.robot.createScreenCapture(new Rectangle(1920, 1080));
        getRGB(bi.getRGB(0, 0));
        getRGB(bi.getRGB(500, 500));
        getRGB(bi.getRGB(1000, 1000));
        getRGB(bi.getRGB(485, 183));

        try {
            File outputfile = new File(DOSSIER + nom_image + ".png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            // handle exception
        }
    }
}
