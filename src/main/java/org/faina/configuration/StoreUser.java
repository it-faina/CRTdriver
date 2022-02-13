package org.faina.configuration;

import static org.faina.configuration.StoreChanel.HAMBURG;
import static org.faina.configuration.StoreChanel.ROSTOCK;

public class StoreUser {
    private final String login;
    private final String password;
    private final String connectedRetailInfo;

    public StoreUser(Enum<StoreChanel> crtChannel) {
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
