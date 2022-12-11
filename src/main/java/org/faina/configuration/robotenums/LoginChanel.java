package org.faina.configuration.robotenums;

/**
 * convert chanel to be login from config.properties to Enum entry
 */
public enum LoginChanel {

    HAMBURG("Logged in CRT Hamburg"),
    ROSTOCK("Logged in CRT Rostock"),
    DREIMASTER("Logged in CRT DreiMaster"),
    MYMO("Logged in CRT myMo"),
    KLIPPHAUSEN("Logged in CRT Klipphausen"),
    PLPTAKOUTLET("Logged in CRT PtakOutlet"),
    PLSCHMUDDELWEDDA("Logged in CRT Schmuddelwedda Ptakoutlet"),
    PLMYMO("Logged in CRT MyMo Ptakoutlet"),
    PLDREIMASTER("Logged in CRT DreiMaster Ptakoutlet"),
    NO_CHANEL("No chanel was setup to login");

    private final String chanelDescription;

    LoginChanel(String chanelDescription) {
        this.chanelDescription = chanelDescription;
    }

    public String getChanelDescription() {
        return chanelDescription;
    }
}