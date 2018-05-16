package hu.unideb.sleepysam.controller;

/*-
 * #%L
 * OrionTrail
 * %%
 * Copyright (C) 2017 University of Debrecen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * #L%
 */

import hu.unideb.sleepysam.model.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static hu.unideb.sleepysam.view.Main.logger;

/**
 * This class is used to generate new situations each time the Next button is pressed on an Outcome screen.
 */
public class SituationFactory {

    // private static

    private Game game;

    public SituationFactory(Game myGame) {
        this.game = myGame;
    }

    private static ArrayList<String> shipPrefixes = new ArrayList<>();;
    private static ArrayList<String> shipSuffixes = new ArrayList<>();;

    private Situation fightSituation = new Situation(
            new FlavorTextTemplate("A radar befogta a %s jelét. Izzítja a lézerágyúit, készülj a csatára!",
                    getRandomShipName()),
            new Option("Támadás!", "Sikeresen megtámadtad az ellenséges hajót.",
                    -2, -2, -2),
            new Option("Védekezés!", "Sikerült elkerülni az ellenséges hajó támadásait.",
                    -3, 0, 0),
            new Option("Menekülés!", "Sikeresen elmenekültél.",
                    -3, 0, 0));

    private String getRandomShipName() {
        logger.info("Ship prefixes: " + shipPrefixes.toString());
        logger.info("Ship suffixes: " + shipSuffixes.toString());
        int randomNum1 = ThreadLocalRandom.current().nextInt(0, shipPrefixes.size());
        int randomNum2 = ThreadLocalRandom.current().nextInt(0, shipSuffixes.size());
        String randomShipName = shipPrefixes.get(randomNum1) + " " + shipSuffixes.get(randomNum2);

        return randomShipName;
    }

    private static int index = 0;

    /**
     * Generates a new random {@link hu.unideb.sleepysam.model.Situation}.
     *
     * @return the random situation
     */
    public Situation getRandomSituation() {
        logger.info("Barmit");
        logger.info("Getrandom situation, game: " + game.toString());

        Situation situation = new Situation();

        logger.info("random ship: " + getRandomShipName());

        // NORMAL 3 szituacionkent fight, HARD 2 szituacionkent fight
        logger.info("Getrandom situation, game: " + game.toString());
        if (game.getDifficulty() == GameDifficulty.NORMAL) {

            // Create FIGHT situation
            if (game.getVictoryCounter() % 3 == 0) {
                situation = new Situation(fightSituation);
                FlavorTextTemplate flavorTextTemplate = new
                        FlavorTextTemplate(fightSituation.getFlavorTextTemplate().getPattern(),
                        getRandomShipName());
                situation.getFlavorText();
            }
            // Create STORY situation
            else {
                situation = Game.getSituationTemplates().get(index);
                index++;
            }
        } else if (game.getDifficulty() == GameDifficulty.HARD) {
            // Create FIGHT situation
            if (game.getVictoryCounter() % 2 == 0) {
                situation = new Situation(fightSituation);
                FlavorTextTemplate flavorTextTemplate = new
                        FlavorTextTemplate(fightSituation.getFlavorTextTemplate().getPattern(),
                        getRandomShipName());
                situation.getFlavorText();
            }
            // Create STORY situation
            else {
                situation = Game.getSituationTemplates().get(index);
                index++;
            }
        }
        return situation;
    }

    public static ArrayList<String> getShipPrefixes() {
        return shipPrefixes;
    }

    public static void setShipPrefixes(ArrayList<String> shipPrefixes) {
        SituationFactory.shipPrefixes = shipPrefixes;
        logger.info("Prefixes set!");
    }

    public static ArrayList<String> getShipSuffixes() {
        return shipSuffixes;
    }

    public static void setShipSuffixes(ArrayList<String> shipSuffixes) {
        SituationFactory.shipSuffixes = shipSuffixes;
    }
}

