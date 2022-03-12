package org.faina.configuration.robotenums;

/**
 * convert chanel to be login from config.properties to Enum entry
 */
public enum LoginChanel {

    HAMBURG("Logged in CRT Hamburg"),
    ROSTOCK("Logged in CRT Rostock"),
    DREIMASTER("Logged in CRT DreiMaster"),
    MYMO("Logged in CRT myMo"),
    NO_CHANEL("No chanel was setup to login");

    private final String chanelDescription;

    LoginChanel(String chanelDescription) {
        this.chanelDescription = chanelDescription;
    }

    public String getChanelDescription() {
        return chanelDescription;
    }
}