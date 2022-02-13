package org.faina.configuration;

public enum StoreChanel {

    HAMBURG("CRT Hamburg"),
    ROSTOCK("CRT Rostock"),
    NO_CHANEL("No chanel was setup to robot service");

    private final String chanelDescription;

    StoreChanel(String chanelDescription) {
        this.chanelDescription = chanelDescription;
    }

    public String getChanelDescription() {
        return chanelDescription;
    }
}