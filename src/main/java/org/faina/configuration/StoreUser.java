package org.faina.configuration;

import org.faina.configuration.robotenums.LoginChanel;

import static org.faina.configuration.robotenums.LoginChanel.*;

public class StoreUser {
    private String login = "";
    private String password = "";
    private String connectedRetailInfo = "";

    public StoreUser(LoginChanel crtChannel) {
        switch (crtChannel) {

            case HAMBURG:
                login = Configurator.getHamburgUser();
                password = Configurator.getHamburgPass();
                this.connectedRetailInfo = HAMBURG.getChanelDescription();
                break;

            case ROSTOCK:
                login = Configurator.getRostockUser();
                password = Configurator.getRostockPass();
                this.connectedRetailInfo = ROSTOCK.getChanelDescription();
                break;

            case DREIMASTER:
                login = Configurator.getDreiMasterUser();
                password = Configurator.getDreiMasterPass();
                this.connectedRetailInfo = DREIMASTER.getChanelDescription();
                break;

            case MYMO:
                login = Configurator.getmyMoUser();
                password = Configurator.getmyMoPass();
                this.connectedRetailInfo = MYMO.getChanelDescription();
                break;

            case KLIPPHAUSEN:
                login = Configurator.getKlipphausenUser();
                password = Configurator.getKlipphausenPass();
                this.connectedRetailInfo = KLIPPHAUSEN.getChanelDescription();
                break;

            case PLPTAKOUTLET:
                login = Configurator.getPLPtakOutletUser();
                password = Configurator.getPLPtakOutletPass();
                this.connectedRetailInfo = PLPTAKOUTLET.getChanelDescription();
                break;

            case PLSCHMUDDELWEDDA:
                login = Configurator.getPLSchmuddelweddaUser();
                password = Configurator.getPLSchmuddelweddaPass();
                this.connectedRetailInfo = PLSCHMUDDELWEDDA.getChanelDescription();
                break;

            case PLMYMO:
                login = Configurator.getPLMyMoUser();
                password = Configurator.getPLMyMoPass();
                this.connectedRetailInfo = PLMYMO.getChanelDescription();
                break;

            case PLDREIMASTER:
                login = Configurator.getPLDreiMasterUser();
                password = Configurator.getPLDreiMasterPass();
                this.connectedRetailInfo = PLDREIMASTER.getChanelDescription();
                break;

            default:
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConnectedRetailInfo() {
        return connectedRetailInfo;
    }
}
