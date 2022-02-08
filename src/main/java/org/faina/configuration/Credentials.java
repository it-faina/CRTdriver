package org.faina.configuration;

import static org.faina.configuration.Mode.HAMBURG;
import static org.faina.configuration.Mode.ROSTOCK;

public class Credentials {
    private String login;
    private String password;
    private String connectedRetailInfo;

    public Credentials(Enum crtChanell) {
        if (crtChanell == HAMBURG) {
            login = Configurator.getHamburgUser();
            password = Configurator.getHamburgPass();
            this.connectedRetailInfo = HAMBURG.getText();
        } else {
            login = Configurator.getRostockUser();
            password = Configurator.getRostockPass();
            this.connectedRetailInfo = ROSTOCK.getText();
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
