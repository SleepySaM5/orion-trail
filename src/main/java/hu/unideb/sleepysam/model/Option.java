package hu.unideb.sleepysam.model;

/**
 * Created by vtibi on 5/21/2017.
 */
public class Option {
    private final String optionText;
    private final String outcomeText;
    private final int outcomeFuelDiff;
    private final int outcomeFoodDiff;
    private final int outcomeCrewDiff;

    public Option(String optionText, String outcomeText, int outcomeFuelDiff, int outcomeFoodDiff, int outcomeCrewDiff) {
        this.optionText = optionText;
        this.outcomeText = outcomeText;
        this.outcomeFuelDiff = outcomeFuelDiff;
        this.outcomeFoodDiff = outcomeFoodDiff;
        this.outcomeCrewDiff = outcomeCrewDiff;
    }

    public String getOptionText() {
        return optionText;
    }

    public String getOutcomeText() {
        return outcomeText;
    }

    public int getOutcomeFuelDiff() {
        return outcomeFuelDiff;
    }

    public int getOutcomeFoodDiff() {
        return outcomeFoodDiff;
    }

    public int getOutcomeCrewDiff() {
        return outcomeCrewDiff;
    }
}
