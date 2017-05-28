package hu.unideb.sleepysam;

import hu.unideb.sleepysam.controller.Game;
import hu.unideb.sleepysam.model.Option;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SleepySam on 5/28/2017.
 */
public class GameTest {
    @Test
    public void applyChosenOptionTest() {
        Game test = new Game();
        test.applyChosenOption(new Option("Test", "Test", 1, 1, 1));
        Assert.assertEquals(1, test.getCrew());
        Assert.assertEquals(1, test.getFood());
        Assert.assertEquals(1, test.getFuel());
    }
}
