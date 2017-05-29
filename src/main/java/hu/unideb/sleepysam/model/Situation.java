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

