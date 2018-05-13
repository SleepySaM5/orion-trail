package hu.unideb.sleepysam.model;

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

/**
 * Represents the Option object.
 */
public class Option {
    /**
     * The text of an option.
     */
    private final String optionText;

    /**
     * The text of the chosen options outcome.
     */
    private final String outcomeText;

    /**
     * The change in the {@link hu.unideb.sleepysam.controller.Game#fuel} resource based on the chosen option.
     */
    private final int outcomeFuelDiff;

    /**
     * The change in the {@link hu.unideb.sleepysam.controller.Game#food} resource based on the chosen option.
     */
    private final int outcomeFoodDiff;

    /**
     * The change in the {@link hu.unideb.sleepysam.controller.Game#crew} resource based on the chosen option.
     */
    private final int outcomeCrewDiff;

    public Option(Option copyOption) {
        if(copyOption == null){
            this.optionText = null;
            this.outcomeText = null;
            this.outcomeCrewDiff  = 0;
            this.outcomeFoodDiff = 0;
            this.outcomeFuelDiff = 0;
        } else {
            this.optionText = copyOption.getOptionText();
            this.outcomeText = copyOption.getOutcomeText();
            this.outcomeFuelDiff = copyOption.getOutcomeFuelDiff();
            this.outcomeFoodDiff = copyOption.getOutcomeFoodDiff();
            this.outcomeCrewDiff = copyOption.getOutcomeCrewDiff();
        }
    }

    /**
     * Constructor method of the Option class.
     * @param optionText the optionText
     * @param outcomeText the outcomeText
     * @param outcomeFuelDiff the outcomeFuelDiff
     * @param outcomeFoodDiff the outcomeFoodDiff
     * @param outcomeCrewDiff the outcomeCrewDiff
     */
    public Option(String optionText, String outcomeText, int outcomeFuelDiff, int outcomeFoodDiff, int outcomeCrewDiff) {
        this.optionText = optionText;
        this.outcomeText = outcomeText;
        this.outcomeFuelDiff = outcomeFuelDiff;
        this.outcomeFoodDiff = outcomeFoodDiff;
        this.outcomeCrewDiff = outcomeCrewDiff;
    }

    /**
     * Getter method for the optionText.
     * @return the optionText
     */
    public String getOptionText() {
        return optionText;
    }

    /**
     * Getter method for the outcomeText.
     * @return the outcomeText
     */
    public String getOutcomeText() {
        return outcomeText;
    }

    /**
     * Getter method for the outcomeFuelDiff.
     * @return the outcomeFuelDiff
     */
    public int getOutcomeFuelDiff() {
        return outcomeFuelDiff;
    }

    /**
     * Getter method for the outcomeFoodDiff.
     * @return the outcomeFoodDiff
     */
    public int getOutcomeFoodDiff() {
        return outcomeFoodDiff;
    }

    /**
     * Getter method for the outcomeCrewDiff.
     * @return the outcomeCrewDiff
     */
    public int getOutcomeCrewDiff() {
        return outcomeCrewDiff;
    }
}
