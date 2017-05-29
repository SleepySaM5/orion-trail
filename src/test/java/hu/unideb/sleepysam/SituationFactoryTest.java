package hu.unideb.sleepysam;

import hu.unideb.sleepysam.controller.SituationFactory;
import hu.unideb.sleepysam.model.Situation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vtibi on 5/29/2017.
 */
public class SituationFactoryTest {
    @Test
    public void generatedSituationsAreValid() {
        Situation testSituation;
        testSituation = SituationFactory.getRandomSituation();
        Assert.assertNotEquals(0, testSituation.getFlavorText().length());
        Assert.assertNotEquals(0, testSituation.getOption1().getOptionText().length());
        Assert.assertNotEquals(0, testSituation.getOption2().getOptionText().length());
        Assert.assertNotEquals(0, testSituation.getOption3().getOptionText().length());

    }
}
