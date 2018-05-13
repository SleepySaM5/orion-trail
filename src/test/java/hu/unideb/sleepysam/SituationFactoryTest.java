package hu.unideb.sleepysam;

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

import hu.unideb.sleepysam.controller.Game;
import hu.unideb.sleepysam.controller.LoadManager;
import hu.unideb.sleepysam.controller.SituationFactory;
import hu.unideb.sleepysam.model.GameDifficulty;
import hu.unideb.sleepysam.model.Situation;
import hu.unideb.sleepysam.view.Main;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vtibi on 5/29/2017.
 */
public class SituationFactoryTest {

    public static Game game;
    @Test
    public void generatedSituationsAreValid() {
        Situation testSituation;
        LoadManager loadManager = new LoadManager();
        loadManager.loadShipNames();
        game = new Game();
        game.setDifficulty(GameDifficulty.NORMAL);
        loadManager.loadSituationsFromJson();

        SituationFactory factory = new SituationFactory(game);
        testSituation = factory.getRandomSituation();
        Assert.assertNotEquals(testSituation.getFlavorTextTemplate().getPattern().length(), 0);
        Assert.assertNotEquals(testSituation.getOption1().getOptionText().length(), 0);
        Assert.assertNotEquals(testSituation.getOption2().getOptionText().length(), 0);
        Assert.assertNotEquals(testSituation.getOption3().getOptionText().length(), 0);
    }
}
