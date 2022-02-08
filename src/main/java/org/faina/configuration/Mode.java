package org.faina.configuration;

public enum Mode {

    HAMBURG("CRT Hamburg"), ROSTOCK("CRT Rostock");
    private final String text;

    Mode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
