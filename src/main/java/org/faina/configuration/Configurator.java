package org.faina.configuration;

public class Configurator extends ConfigProperties {

    public Configurator() {
    }

    public static String getWebdriverDir() {
        return getProperty("webdriverDirectory", "default-webdriver-dir");
    }

    public static long getImplicytyWait() {
        return getProperty("implicityWaitTime", 0);
    }


    public static String getLandingPage() {
        return getProperty("landingPage", "http://www.faina-lifestyle.pl/");
    }

    public static String getServicedChanel() {
        return getProperty("servicedChanel", "ROSTOCK");
    }

    public static String getHamburgUser() {
        return getProperty("userHamburg", "demoUserHamburg");
    }

    public static String getHamburgPass() {
        return getProperty("passHamburg", "demoPasswordHamburg");
    }

    public static String getRostockUser() {
        return getProperty("userRostock", "demoUserRostock");
    }

    public static String getRostockPass() {
        return getProperty("passRostock", "demoPasswordRostock");
    }

    public static boolean getServiceOrderMode() {
        return getProperty("ServiceOrderMode", true);
    }
}
