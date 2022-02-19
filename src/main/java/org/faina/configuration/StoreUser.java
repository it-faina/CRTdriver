package org.faina.configuration;

import org.faina.configuration.robotenums.LoginChanel;

import static org.faina.configuration.robotenums.LoginChanel.HAMBURG;
import static org.faina.configuration.robotenums.LoginChanel.ROSTOCK;

public class StoreUser {
    private final String login;
    private final String password;
    private final String connectedRetailInfo;

    public StoreUser(Enum<LoginChanel> crtChannel) {
        if (crtChannel == HAMBURG) {
            login = Configurator.getHamburgUser();
            password = Configurator.getHamburgPass();
            this.connectedRetailInfo = HAMBURG.getChanelDescription();
        } else {
            login = Configurator.getRostockUser();
            password = Configurator.getRostockPass();
            this.connectedRetailInfo = ROSTOCK.getChanelDescription();
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
