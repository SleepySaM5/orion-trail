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

import hu.unideb.sleepysam.model.FlavorTextTemplate;
import hu.unideb.sleepysam.model.GameDifficulty;
import hu.unideb.sleepysam.model.Option;
import hu.unideb.sleepysam.model.Situation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static hu.unideb.sleepysam.view.Main.game;
import static hu.unideb.sleepysam.view.Main.logger;

/**
 * This class is used to generate new situations each time the Next button is pressed on an Outcome screen.
 */
public class SituationFactory {

    // private static

    private static ArrayList<String> shipPrefixes;
    private static ArrayList<String> shipSuffixes;

    //public Situation(FlavorTextTemplate flavorTextTemplate, Option option1, Option option2, Option option3) {

    private Situation fightSituation = new Situation(
            new FlavorTextTemplate("You have encountered the %s. It approaches with a frightening speed.",
                    getRandomShipName()),
            new Option("Attack!", "It atteck.",
                    1, 1, 1),
            new Option("Defend!", "It protecc.",
                    1, 1, 1),
            new Option("Flee!", "It also flee.",
                    1, 1, 1));

    private String getRandomShipName() {
        return null;
    }

    private static int index = 0;

    /**
     * Generates a new random {@link hu.unideb.sleepysam.model.Situation}.
     *
     * @return the random situation
     */
    public Situation getRandomSituation() {
        logger.info("Getrandom situation, game: " + game.toString());

        Situation situation = new Situation();

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
    }

    public static ArrayList<String> getShipSuffixes() {
        return shipSuffixes;
    }

    public static void setShipSuffixes(ArrayList<String> shipSuffixes) {
        SituationFactory.shipSuffixes = shipSuffixes;
    }
}

