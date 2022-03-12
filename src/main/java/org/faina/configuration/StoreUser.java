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
