package hu.unideb.sleepysam.model;

import java.util.List;

public class FlavorTextTemplate {
    String pattern;
    String content;

    public FlavorTextTemplate(String pattern, String content) {
        this.pattern = pattern;
        this.content = content;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
