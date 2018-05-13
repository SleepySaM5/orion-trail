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


import java.text.MessageFormat;
import java.util.List;

/**
 * Represents the Situation object.
 */
public class Situation {

    private String flavorText;

    private FlavorTextTemplate flavorTextTemplate;

    private SituationType type;

    public SituationType getType() {
        return type;
    }

    public void setType(SituationType type) {
        this.type = type;
    }

    /**
     * The flavor text of a situation.
     */
    private String flavorMessage;

    /**
     * The text of the first option in a situation.
     */
    private Option option1;

    /**
     * The text of the second option in a situation.
     */
    private Option option2;

    /**
     * The text of the third option in a situation.
     */
    private Option option3;

    public Situation() {
    }

    public Situation(Situation copySituation) {
        this.flavorText = copySituation.getFlavorText();
        this.flavorTextTemplate = copySituation.getFlavorTextTemplate();
        this.option1 = new Option(copySituation.getOption1());
        this.option2 = new Option(copySituation.getOption2());
        this.option3 = new Option(copySituation.getOption3());
    }

    //todo get rid of this shit:
    public Situation(String flavorText, FlavorTextTemplate flavorTextTemplate, Option option1, Option option2, Option option3) {
        this.flavorText = flavorText;
        this.flavorTextTemplate = flavorTextTemplate;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public Situation(FlavorTextTemplate flavorTextTemplate, Option option1, Option option2, Option option3) {
        this.flavorText = flavorText;
        this.flavorTextTemplate = flavorTextTemplate;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }


    /**
     * The constructor method of the Situation class.
     *
     * @param flavorText the flavor text
     * @param option1    the first options text
     * @param option2    the second options text
     * @param option3    the third options text
     */
    public Situation(String flavorText, Option option1, Option option2, Option option3) {
        this.flavorText = flavorText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    public FlavorTextTemplate getFlavorTextTemplate() {
        return flavorTextTemplate;
    }

    /**
     * Getter method for the flavor text.
     *
     * @return the flavorText
     */
    public String getFlavorText() {
        return flavorText;
    }

    /**
     * Getter method for the first option.
     *
     * @return the option1
     */
    public Option getOption1() {
        return option1;
    }

    /**
     * Getter method for the second option.
     *
     * @return the option2
     */
    public Option getOption2() {
        return option2;
    }

    /**
     * Getter method for the third option.
     *
     * @return the option3
     */
    public Option getOption3() {
        return option3;
    }

    @Override
    public String toString() {
        return "Situation{" +
                "flavorText='" + flavorText + '\'' +
                ", flavorTextTemplates=" + flavorTextTemplate +
                ", flavorMessage='" + flavorMessage + '\'' +
                ", option1=" + option1 +
                ", option2=" + option2 +
                ", option3=" + option3 +
                '}';
    }
}

