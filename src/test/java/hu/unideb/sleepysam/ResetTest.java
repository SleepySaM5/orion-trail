package hu.unideb.sleepysam;

import hu.unideb.sleepysam.controller.Game;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vtibi on 5/30/2017.
 */
public class ResetTest {
    @Test
    public void resetGameTest() {
        Game game = new Game();
        game.resetGame();
        Assert.assertEquals(game.getStartCrew(), game.getCrew());
        Assert.assertEquals(game.getStartFood(), game.getFood());
        Assert.assertEquals(game.getStartFuel(), game.getCrew());
    }
}
