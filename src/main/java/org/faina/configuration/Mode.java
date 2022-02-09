package org.faina.configuration;

public enum Mode {

    HAMBURG("CRT Hamburg"),
    ROSTOCK("CRT Rostock"),
    NO_CHANEL("No chanel was setup setup to automatised service");

    private final String text;

    Mode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}