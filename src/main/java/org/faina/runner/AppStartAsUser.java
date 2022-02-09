package org.faina.runner;

import org.faina.configuration.Configurator;
import org.faina.configuration.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.faina.configuration.Mode.*;


public class AppStartAsUser {
    final static Logger log = LoggerFactory.getLogger(AppStartAsUser.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("--------------###############--------------");
        log.info("CRT Service started");
        Enum currentCRTchannel = NO_CHANEL;
        if (Configurator.getServicedChanel().equals("HAMBURG")) {
            currentCRTchannel = HAMBURG;
        }
        if (Configurator.getServicedChanel().equals("ROSTOCK")) {
            currentCRTchannel = ROSTOCK;
        }

        if (currentCRTchannel != NO_CHANEL) {
            log.info("Order execution for {}", currentCRTchannel.name());

            LoginPage loggedPage = new LoginPage();
            Credentials userCredentials = new Credentials(currentCRTchannel);
            OrderPage orderPage = loggedPage.loginAsUser(userCredentials);
            orderPage.clickOkCookies();
            for (int i = 0; i < 3; i++) {
                String ordered = orderPage.getOrderIDtoPicking();
                System.out.println(ordered);
            }
            loggedPage.stopWebDriver();
        }
        log.info("CRT service stopped");
    }
}
