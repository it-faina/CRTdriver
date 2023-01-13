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

    public static String getLoginServicedChanel() {
        return getProperty("loginToChanel", "Default Login");
    }

    public static String getShopChanel1Title() {
        return getProperty("shopChanel1Title", "Default with logged user");
    }

    public static String getShopChanel2Title() {
        return getProperty("shopChanel2Title", "EMPTY");
    }

    public static String getShopChanel3Title() {
        return getProperty("shopChanel3Title", "EMPTY");
    }

    public static String getShopChanel4Title() {
        return getProperty("shopChanel4Title", "EMPTY");
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

    public static String getDreiMasterUser() {
        return getProperty("userDreiMaster", "demoUserDreiMaster");
    }

    public static String getDreiMasterPass() {
        return getProperty("passDreiMaster", "demoPasswordDreiMaster");
    }

    public static String getmyMoUser() {
        return getProperty("usermyMo", "demomyMo");
    }

    public static String getmyMoPass() {
        return getProperty("passmyMo", "demoPasswordmyMo");
    }

    public static String getKlipphausenUser() {
        return getProperty("userKlipphausen", "demoKlipphausen");
    }

    public static String getKlipphausenPass() {
        return getProperty("passKlipphausen", "demoKlipphausen");
    }

    public static String getPLPtakOutletUser() {
        return getProperty("userPLPtakOutlet", "demoPLPtakOutlet");
    }

    public static String getPLPtakOutletPass() {
        return getProperty("passPLPtakOutlet", "demoPasswordPLPtakOutlet");
    }

    public static String getPLSchmuddelweddaUser() {
        return getProperty("userPLSchmuddelwedda", "demoPLSchmuddelwedda");
    }

    public static String getPLSchmuddelweddaPass() {
        return getProperty("passPLSchmuddelwedda", "demoPasswordPLSchmuddelwedda");
    }

    public static String getPLMyMoUser() {
        return getProperty("userPLMyMo", "demoPLMyMo");
    }

    public static String getPLMyMoPass() {
        return getProperty("passPLMyMo", "demoPasswordPLMyMo");
    }

    public static String getPLDreiMasterUser() {
        return getProperty("userPLDreiMaster", "demoPLDreiMaster");
    }

    public static String getPLDreiMasterPass() {
        return getProperty("passPLDreiMaster", "demoPasswordPLDreiMaster");
    }

    public static boolean getServiceOrderMode() {
        return getProperty("ServiceOrderMode", true);
    }

    public static boolean getServiceToTheEndMode() {
        return getProperty("serviceToTheEnd", true);
    }

    public static long getAmountPickedOrders() {
        return getProperty("amountPickedOrders", 1);
    }
}
