package hu.unideb.sleepysam.model;

import hu.unideb.sleepysam.model.Option;

/**
 * Created by vtibi on 5/21/2017.
 */
public class Situation {
    private final String flavorText;
    private final Option option1;
    private final Option option2;
    private final Option option3;

    public Situation(String flavorText, Option option1, Option option2, Option option3) {
        this.flavorText = flavorText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public Option getOption1() {
        return option1;
    }

    public Option getOption2() {
        return option2;
    }

    public Option getOption3() {
        return option3;
    }
}

