package org.faina.configuration.robotenums;

/**
 * convert chanel to be login from config.properties to Enum entry
 */
public enum LoginChanel {

    HAMBURG("Logged in CRT Hamburg"),
    ROSTOCK("Logged in CRT Rostock"),
    NO_CHANEL("No chanel was setup to login");

    private final String chanelDescription;

    LoginChanel(String chanelDescription) {
        this.chanelDescription = chanelDescription;
    }

    public String getChanelDescription() {
        return chanelDescription;
    }
}