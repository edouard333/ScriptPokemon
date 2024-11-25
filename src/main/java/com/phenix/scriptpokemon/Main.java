package com.phenix.scriptpokemon;

import com.phenix.scriptpokemon.choix.ChangementHeure;
import com.phenix.scriptpokemon.choix.Jour;
import com.phenix.scriptpokemon.choix.Touche;
import com.phenix.scriptpokemon.choix.Starter;
import com.phenix.scriptpokemon.choix.Sexe;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Script qui joue à Pokémon 2G (pour l'instant que depuis le début).
 *
 * @author <a href="mailto:edouard128@hotmail.com">Edouard Jeanjean</a>
 */
public class Main {

    /**
     * Lance le script.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Choix qu'on fait pour le jeu :
        Sexe sexe = Sexe.GARCON;
        int heure = 9;
        int minute = 20;
        String nom = "Jean";
        Jour jour = Jour.LUNDI;
        ChangementHeure changement_heure = ChangementHeure.ETE;
        Starter starter = Starter.HERICENDRE;

        try {
            SuperRobot robot = new SuperRobot();

            // Focus sur l'émulateur :
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_ALT);

            // Quand on a le focus sur l'émulateur, on attend 3sec : le temps de pouvoir exécuter une touche + début cinématique où on peut pas faire d'action.
            robot.delay(4000);

            if (true) {
                // "A" pendant cinématique :
                //robot.image.getImage("01_touche-a_pendant-cinematique");
                robot.press(Touche.A, 200, "pendant cinématique");

                robot.delay(2700);

                // "A" pendant menu "Pokémon" :
                //robot.image.getImage("02_touche-a_apres-cinematique");
                robot.press(Touche.A, 200, "menu Pokemon");

                robot.delay(1700);

                // "A" pour "NOUVEAU JEU" :
                robot.image.getImage("03_touche-a_nouveau-jeu");
                robot.press(Touche.A, 200, "NOUVEAU JEU");

                choixSexe(robot, sexe);

                choixDateHeure(robot, heure, minute);

                robot.dialogue.dialogue(new PasserTexteDTO[]{
                    new PasserTexteDTO(1400, "retard" /*, "12_touche-a_retard"*/),
                    new PasserTexteDTO(4300, "bonjour", "13_touche-a_bonjour"),
                    new PasserTexteDTO(2600, "bienvenue" /*, "14_touche-a_bienvenue"*/),
                    new PasserTexteDTO(1500, "chen" /*, "15_touche-a_chen"*/),
                    new PasserTexteDTO(1800, "professeur" /*, "16_touche-a_professeur"*/),
                    new PasserTexteDTO(2600, "un-pokemon-a" /*, "17_touche-a_un-pokemon-a"*/),
                    new PasserTexteDTO(1500, "un-pokemon-b" /*, "18_touche-a_un-pokemon-b"*/),
                    new PasserTexteDTO(2700, "humain-pokemon-a" /*, "19_touche-a_humain-pokemon-a"*/),
                    new PasserTexteDTO(1300, "humain-pokemon-b" /*, "20_touche-a_humain-pokemon-b"*/),
                    new PasserTexteDTO(2200, "joue-pokemon-a" /*, "21_touche-a_joue-pokemon-a"*/),
                    new PasserTexteDTO(1300, "joue-pokemon-b" /*, "21_touche-a_joue-pokemon-b"*/),
                    new PasserTexteDTO(1400, "joue-pokemon-c" /*, "21_touche-a_joue-pokemon-c"*/),
                    new PasserTexteDTO(4100, "apprendre-a" /*, "22_touche-a_apprendre-a"*/),
                    new PasserTexteDTO(1700, "apprendre-b" /*, "22_touche-a_apprendre-b"*/),
                    new PasserTexteDTO(1300, "apprendre-c" /*, "22_touche-a_apprendre-c"*/),
                    new PasserTexteDTO(2100, "mystere-a" /*, "23_touche-a_mystere-a"*/),
                    new PasserTexteDTO(1000, "mystere-b" /*, "23_touche-a_mystere-b"*/),
                    new PasserTexteDTO(1800, "etudie-a" /*, "24_touche-a_etudie-a"*/),
                    new PasserTexteDTO(1700, "etudie-b" /*, "24_touche-a_etudie-b"*/),
                    new PasserTexteDTO(800, "etudie-c", "24_touche-a_etudie-c")
                });

                // "A" pour "question-nom" :
                choixNom(robot, nom);

                robot.dialogue.dialogue(new PasserTexteDTO[]{
                    new PasserTexteDTO(2200, "aventure", "28_touche-a_aventure"),
                    new PasserTexteDTO(2000, "joies (b)", "29_touche-a_joies-b"),
                    new PasserTexteDTO(2000, "monde (a)", "30_touche-a_monde-a"),
                    new PasserTexteDTO(2000, "monde (b)", "31_touche-a_monde-b"),
                    new PasserTexteDTO(2000, "attendre", "32_touche-a_attendre")
                });

                // Animation de grand à petit.
                robot.delay(3600);

                // Sortir chambre :
                robot.deplacement.deplacement(new Touche[]{
                    Touche.DROITE, // Sprite vers la droite.
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.HAUT,// Sprite vers le haut.
                    Touche.HAUT,
                    Touche.HAUT,
                    // robot.image.getImage("33_chambre");
                    Touche.HAUT
                });

                robot.delay(300 + 700); // + Attente animation changement salle.

                robot.image.getImage("34_touche-bas_salon");

                // Aller vers maman :
                robot.deplacement.deplacement(new Touche[]{
                    Touche.BAS,
                    Touche.BAS,
                    Touche.BAS
                });

                robot.dialogue.dialogue(new PasserTexteDTO[]{
                    new PasserTexteDTO(3100, "cherche (a)", "35_touche-a_cherche-a"),
                    new PasserTexteDTO(2600, "cherche (b)"/*, "35_touche-a_cherche-b"*/),
                    new PasserTexteDTO(2200, "voulait que (a)"/*, "36_touche-a_voulait-a"*/),
                    new PasserTexteDTO(1600, "voulait que (b)", "36_touche-a_voulait-b"),
                    new PasserTexteDTO(1600, "oublier (a)"/*, "36_touche-a_oublier-a"*/),
                    new PasserTexteDTO(2200, "oublier (b)"/*, "36_touche-a_oublier-b"*/),
                    new PasserTexteDTO(2200, "oublier (c)"/*, "36_touche-a_oublier-c"*/),
                    new PasserTexteDTO(2200, "tiens"/*, "37_touche-a_tiens"*/),
                    new PasserTexteDTO(5000 + 1700, "matos pokemon (a)"/*, "38_touche-a_matos-pokemon-a"*/), // Son + Dialogue.
                    new PasserTexteDTO(1700, "matos pokemon (b)"/*, "38_touche-a_matos-pokemon-b"*/),
                    new PasserTexteDTO(2500, "matos pokemon (c)"/*, "38_touche-a_matos-pokemon-c"*/),
                    new PasserTexteDTO(1600, "matos pokemon (d)"/*, "38_touche-a_matos-pokemon-d"*/),
                    new PasserTexteDTO(2800, "jour-semaine (a)"/*, "39_touche-a_jour-semaine-a"*/),
                    new PasserTexteDTO(1000, "jour-semaine (b)"/*, "39_touche-a_jour-semaine-b"*/),
                    new PasserTexteDTO(1600, "jour-semaine (c)"/*, "39_touche-a_jour-semaine-c"*/)
                });

                choixJour(robot, jour, changement_heure);

                robot.dialogue.dialogue(new PasserTexteDTO[]{
                    new PasserTexteDTO(1700, "reviens maison (a)"/*, "45_touche-a_reviens-maison-a"*/),
                    new PasserTexteDTO(1700, "reviens maison (b)"/*,"45_touche-a_reviens-maison-b"*/),
                    new PasserTexteDTO(1900, "par-ailleurs (a)"/*, "46_touche-a_par-ailleurs-a"*/),
                    new PasserTexteDTO(1200, "par-ailleurs (b)"/*, "46_touche-a_par-ailleurs-b"*/),
                    new PasserTexteDTO(1300, "question-telephone (oui)"/*, "47_touche-a_question-telephone-oui"*/),
                    new PasserTexteDTO(1300, "question pokematos (a)"/*, "48_touche-a_question-pokematos-a"*/),
                    new PasserTexteDTO(1500, "question pokematos (b)"/*, "48_touche-a_question-pokematos-b"*/),
                    new PasserTexteDTO(1700, "numero (a)"/*, "49_touche-a_numero-a"*/),
                    new PasserTexteDTO(2000, "numero (b)"/*, "49_touche-a_numero-b"*/),
                    new PasserTexteDTO(2000, "numero (c)"/*, "49_touche-a_numero-c"*/),
                    new PasserTexteDTO(1400, "numero (d)"/*, "49_touche-a_numero-d"*/),
                    new PasserTexteDTO(800, "numero (e)"/*, "49_touche-a_numero-e"*/),
                    new PasserTexteDTO(2100, "compliquer"/*, "50_touche-a_compliquer"*/),});

                robot.delay(2000); // Maman assise.

                robot.image.getImage("51_maman_assise");
            }

            robot.deplacement.deplacement(new Touche[]{
                Touche.BAS, // Sprite vers le bas.
                Touche.BAS,
                Touche.BAS,
                Touche.BAS,
                Touche.GAUCHE, // Sprite vers la gauche.
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.BAS, // Sprite vers le bas.
                // robot.image.getImage("52_avant-sortir-maison");
                Touche.BAS
            });

            // Animation sortir.
            robot.delay(200 + 100);
            robot.image.getImage("52_hors-maison");
            // Sorti maison.

            // Aller jusque professeur Orme :
            robot.deplacement.deplacement(new Touche[]{
                Touche.GAUCHE, // Sprite à gauche.
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.HAUT, // Sprite à droite.
                Touche.HAUT,
                Touche.HAUT,
                Touche.HAUT
            });

            // Entre maison prof Orme + 1er dialogue
            robot.dialogue.dialogue(new PasserTexteDTO[]{
                new PasserTexteDTO(4500, "dialogue-prof-orme", "53_dialogue-prof-orme"), // Délais de maison prof Orme + 1er dialogue
                new PasserTexteDTO(1600, "service", "54_service"),
                new PasserTexteDTO(1800, "nouvelles recherches (a)", "55_nouvelles-recherches-a"),
                new PasserTexteDTO(1800, "nouvelles recherches (b)", "55_nouvelles-recherches-b"),
                new PasserTexteDTO(1800, "nouvelles recherches (c)", "55_nouvelles-recherches-c"),
                new PasserTexteDTO(1400, "vois-tu...", "56_vois-tu"),
                new PasserTexteDTO(1800, "article (a)", "57_article-a"),
                new PasserTexteDTO(1100, "article (b)", "57_article-b"), // Délais de maison prof Orme + 1er dialogue
                new PasserTexteDTO(1800, "certains (a)", "58_certains-a"),
                new PasserTexteDTO(1000, "certains (b)", "58_certains-b"),
                new PasserTexteDTO(600, "Donc!", "59_donc"),
                new PasserTexteDTO(1800, "J'aimerais (a)", "60_aimerai-a")
            });

            robot.dialogue.dialogue(new PasserTexteDTO[]{
                new PasserTexteDTO(1300, "J'aimerais (b) - OUI", "60_aimerai-b"),
                new PasserTexteDTO(1300, "merci", "61_merci"),
                new PasserTexteDTO(1300, "chic", "62_chic"), // Délais de maison prof Orme + 1er dialogue
                new PasserTexteDTO(1800, "63_recherches-a", "63_recherches-a"),
                new PasserTexteDTO(1800, "63_recherches-b", "63_recherches-b"),
                new PasserTexteDTO(1800, "63_recherches-c", "63_recherches-c"),
                new PasserTexteDTO(1800, "rien!", "64_rien"),
                new PasserTexteDTO(4000, "recu email", "65_email"), // Délais son + dialogue.
                new PasserTexteDTO(1800, "hmm oui", "66_hmm"),
                new PasserTexteDTO(1000, "OK...", "67_ok"),
                new PasserTexteDTO(1300, "Ecoute voir", "68_ecoute"),
                new PasserTexteDTO(2200, "ami Monsieur", "69_ami"),
                new PasserTexteDTO(2200, "decouvre (a)", "70_decouvre-a"),
                new PasserTexteDTO(800, "decouvre (b)", "70_decouvre-b"),
                new PasserTexteDTO(2000, "envoyer email (a)", "71_envoyer-email-a"),
                new PasserTexteDTO(2000, "envoyer email (b)", "71_envoyer-email-b"),
                new PasserTexteDTO(700, "envoyer email (c)", "71_envoyer-email-c"),
                new PasserTexteDTO(1800, "tentant (a)", "72_tentant-a"),
                new PasserTexteDTO(1000, "tentant (b)", "72_tentant-b"),
                new PasserTexteDTO(1000, "Attends!", "73_attends"),
                new PasserTexteDTO(1000, "Je sais!", "74_sais"),
                new PasserTexteDTO(1400, "pour moi", "75_pour-moi"), // TODO DECONNE ici,
                new PasserTexteDTO(4500, "entrainer (a)", "76_entrainer-a"), // Déplacement + dialogue.
                new PasserTexteDTO(2200, "entrainer (b)", "76_entrainer-b"),
                new PasserTexteDTO(1800, "nouel ami (a)", "77_nouvel-ami-a"),
                new PasserTexteDTO(900, "nouel ami (b)", "77_nouvel-ami-b"),
                new PasserTexteDTO(1200, "choisis!", "78_choisis")
            });

            choixPokemon(robot, starter);

            robot.dialogue.dialogue(new PasserTexteDTO[]{
                new PasserTexteDTO(2000, "ville (a)", "84_ville-a"),
                new PasserTexteDTO(1600, "ville (b)", "84_ville-b"),
                new PasserTexteDTO(1800, "tout droit (a)", "85_tout-droit-a"),
                new PasserTexteDTO(700, "tout droit (b)", "85_tout-droit-b"),
                new PasserTexteDTO(1700, "sait jamais (a)", "86_sait-jamais-a"),
                new PasserTexteDTO(1700, "sait jamais (b)", "86_sait-jamais-b"),
                new PasserTexteDTO(1400, "sait jamais (c)", "86_sait-jamais-c"),
                new PasserTexteDTO(3500, "recoit-numero (a)", "87_recoit-numero-a"),
                new PasserTexteDTO(3500, "recoit-numero (b)", "87_recoit-numero-b"),
                new PasserTexteDTO(2100, "blesser (a)", "89_blesser-a"),
                new PasserTexteDTO(1300, "blesser (b)", "89_blesser-b"),
                new PasserTexteDTO(1700, "utiliser", "90_utiliser"),
                new PasserTexteDTO(2100, "compte sur toi", "91_compte-sur-toi")
            });

            robot.deplacement.deplacement(new Touche[]{
                Touche.BAS, // Sprite bas.
                Touche.BAS,
                Touche.BAS,
                Touche.BAS,
                Touche.BAS,
                Touche.BAS
            });

            robot.dialogue.dialogue(new PasserTexteDTO[]{
                new PasserTexteDTO(2600, "prends (a)", "92_prends-a"),
                new PasserTexteDTO(700, "prends (b)", "92_prends-b"),
                new PasserTexteDTO(4500, "potion", "93_potion"),
                new PasserTexteDTO(1600, "potion sac (a)", "94_potion-sac-a"),
                new PasserTexteDTO(1000, "potion sac (b)", "94_potion-sac-b"),
                new PasserTexteDTO(1800, "seulement deux (a)", "95_seulement-deux-a"),
                new PasserTexteDTO(1600, "seulement deux (b)", "95_seulement-deux-b")
            });

            robot.delay(2000); // Délais animation.

            // Après scientifique.
            // == ICI : LIBRE !!! ==
            // Sort maison Orme :
            robot.deplacement.deplacement(new Touche[]{
                Touche.BAS,
                Touche.BAS,
                Touche.BAS,
                Touche.BAS
            });

            robot.delay(700); // Animation sortie salle.

            // De la maison Orme à la route 29 :
            robot.deplacement.deplacement(new Touche[]{
                Touche.BAS,
                Touche.BAS,
                Touche.BAS,
                Touche.GAUCHE, // Sprite à gauche.
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.BAS, // Sprite en bas.
                Touche.BAS,
                Touche.GAUCHE, // Sprite à gauche.
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE
            });

            // Aller dans les buissons.
            robot.deplacement.deplacement(new Touche[]{
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.GAUCHE,
                Touche.BAS, // Sprite.
                Touche.BAS
            });

            // A partir d'ici, on est dans l'aléatoire.
            //combat(robot);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Définit quel starter Pokémon on prend.
     *
     * @param robot Robot qui contrôle les actions.
     * @param starter Le starter Pokémon qu'on choisit.
     */
    private static void choixPokemon(SuperRobot robot, Starter starter) {

        // Prendre Pokémon (Héricendre) :
        switch (starter) {
            case HERICENDRE:
                robot.deplacement.deplacement(new Touche[]{
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.HAUT
                });
                break;

            case GERMIGNON:
                robot.deplacement.deplacement(new Touche[]{
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.HAUT
                });
                break;

            case KAIMINUS:
                robot.deplacement.deplacement(new Touche[]{
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.DROITE,
                    Touche.HAUT
                });
                break;
        }

        robot.delay(300);
        robot.press(Touche.A, 200, "Pokémon qu'on prend (" + starter + ")");

        robot.delay(2000);
        robot.image.getImage("79_question-pokemon-a");
        robot.press(Touche.A, 200, "question pokemon (a)");

        robot.delay(1800);
        robot.image.getImage("80_question-pokemon-oui");
        robot.press(Touche.A, 200, "question pokemon (oui)");

        robot.delay(2000);
        robot.image.getImage("81_bon-a");
        robot.press(Touche.A, 200, "bon-a");

        robot.delay(800);
        robot.image.getImage("81_bon-b");
        robot.press(Touche.A, 200, "bon-b");

        robot.delay(6000); // Dialogue + son.
        robot.image.getImage("82_recoit-pokemon");
        robot.press(Touche.A, 200, "recoit pokemon");

        robot.delay(2000);
        robot.image.getImage("83_surnom-a");
        robot.press(Touche.A, 200, "surnom (a)");

        robot.delay(1300);
        robot.press(Touche.BAS, 200, "surnom (non)");
        robot.image.getImage("83_surnom-non");
        robot.press(Touche.A, 200, "surnom (non)");
    }

    /**
     * Définit le sexe.
     *
     * @param robot Robot qui contrôle les actions.
     * @param sexe Le sexe qu'on choisit.
     */
    private static void choixSexe(SuperRobot robot, Sexe sexe) {
        robot.delay(3500);

        if (sexe == Sexe.FILLE) {
            robot.press(Touche.BAS, 200, "Pour prendre fille.");
        }

        // "A" pour "GARCON" :
        //robot.image.getImage("04_touche-a_gracon");
        robot.press(Touche.A, 200, "GARCON");
    }

    /**
     * Définit la date et heure du jeu.
     *
     * @param robot Robot qui contrôle les actions.
     * @param heure Heure qu'on veut.
     * @param minute Minute qu'on veut.
     */
    private static void choixDateHeure(SuperRobot robot, int heure, int minute) {
        robot.delay(3500);

        // "A" pour "..." :
        //robot.image.getImage("05_touche-a_noir");
        robot.press(Touche.A, 200, "...");

        robot.delay(3200);

        // "A" pour "Zzz" :
        //robot.image.getImage("06_touche-a_zzz");
        robot.press(Touche.A, 200, "Zzz");

        robot.delay(3000);

        // "A" pour "heure" :
        //robot.image.getImage("07_touche-a_heure");
        robot.press(Touche.A, 200, "heure");

        robot.delay(2500);

        // "A" pour "heure-question" :
        //robot.image.getImage("08_touche-a_heure-question");
        //robot.press(Touche.A, 200, "heure-question");
        robot.delay(2000);

        // Par défaut, l'heure est sur 10h.
        int decal_heure = 10 - heure;

        if (decal_heure > 0) {
            for (int i = 0; i < decal_heure + 1; i++) {
                robot.press(Touche.HAUT, 100, "Monter heure");
            }
        } else {
            for (int i = 0; i < Math.abs(decal_heure) + 1; i++) {
                robot.press(Touche.BAS, 100, "Descendre heure");
            }
        }

        // "A" pour "valider-heure" :
        //robot.image.getImage("09_touche-a_valider-heure");
        robot.press(Touche.A, 200, "valider-heure");

        robot.delay(1500);

        // "A" pour "minute-question" :
        //robot.image.getImage("10_touche-a_minute-question");
        // robot.press(Touche.A, 200, "minute-question");
        robot.delay(1500);

        // Minute par défaut sur 0:
        for (int i = 0; i < minute; i++) {
            robot.press(Touche.HAUT, 70, "Monter minute");
        }

        // "A" pour "valider-minute" :
        //robot.image.getImage("11_touche-a_valider-minute");
        robot.press(Touche.A, 200, "valider-minute");
    }

    /**
     * Permet de définir le nom du dresseur.
     *
     * @param robot Robot qui fait les actions.
     * @param nom Nom qu'on choisit.
     */
    private static void choixNom(SuperRobot robot, String nom) {
        robot.delay(5000);

        robot.image.getImage("25_touche-a_question-nom");
        robot.press(Touche.A, 200, "question-nom");

        robot.delay(1400);

        boolean nom_personnalise = true;

        switch (nom) {
            case "Jean":
                nom_personnalise = false;
                break;
            /*
            case "Jean": nom_personnalise= false;
            break;
            
            case "Jean": nom_personnalise= false;
            break;
            
            case "Jean": nom_personnalise= false;
            break;*/
        }

        // === Choix nom : ===
        // "DESCEND" pour "question-nom" :
        if (nom_personnalise) {
            robot.press(Touche.A, 200, "nom personnalisé");
        } else {
            //robot.image.getImage("26_touche-descend_choix-nom-01");
            robot.press(Touche.BAS, 200, "choix-nom-01");
            robot.delay(300);
            //robot.image.getImage("26_touche-descend_choix-nom-02");
            robot.press(Touche.BAS, 200, "choix-nom-02");
            robot.delay(300);
            //robot.image.getImage("26_touche-descend_choix-nom-03");
            robot.press(Touche.BAS, 200, "choix-nom-03");
            robot.delay(300);
            //robot.image.getImage("26_touche-descend_choix-nom-04");
            robot.press(Touche.BAS, 200, "choix-nom-04");
            robot.delay(300);
        }

        //robot.image.getImage("27_touche-a_valider-choix-a");
        robot.press(Touche.A, 200, "valider-choix-a");

        robot.delay(2200);

        robot.image.getImage("27_touche-a_valider-choix-b");
        robot.press(Touche.A, 200, "valider-choix-b");
    }

    /**
     * Définit le jour de la semaine.
     *
     * @param robot Robot qui contrôle les actions.
     * @param jour Jour de la semaine.
     * @param changement_heure Quel changement d'heure on est.
     */
    private static void choixJour(SuperRobot robot, Jour jour, ChangementHeure changement_heure) {
        robot.press(Touche.A, 1400, "question jour");

        // TODO : ici choix jour.
        robot.press(Touche.A, 1400, "valider jour"/*, "41_touche-a_valider-jour"*/);
        robot.press(Touche.A, 1000, "valider jour oui"/*, "42_touche-a_valider-jour-oui"*/);
        robot.press(Touche.A, 1900, "changement d'heure"/*, "43_touche-a_question-changement-heure"*/);

        // TODO : ici choix changement d'heure.
        robot.press(Touche.A, 1300, "valider changement d'heure"/*, "44_touche-a_valider-changement-heure"*/);
    }
}
