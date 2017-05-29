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
