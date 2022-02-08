package org.faina.runner;

import org.faina.configuration.Configurator;
import org.faina.configuration.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.faina.configuration.Mode.HAMBURG;
import static org.faina.configuration.Mode.ROSTOCK;


public class AppStartAsUser {
    final static Logger log = LoggerFactory.getLogger(AppStartAsUser.class);

    public static void main(String[] args) throws InterruptedException {
        log.info(".");
        log.info("CRT Service started");
        Enum currentCRTchannel;
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                currentCRTchannel = ROSTOCK;
            } else currentCRTchannel = HAMBURG;


            LoginPage loggedPage = new LoginPage();
            Credentials userCredentials = new Credentials(currentCRTchannel);
            OrderPage orderPage = loggedPage.loginAsUser(userCredentials);
            orderPage.clickOkCookies();

            if (Configurator.getServiceOrderMode()) {
                log.info("Realise order Mode on {}", currentCRTchannel.name());
//            secondPage.clickSearchButton(orderID);
//            orderPage.getOrderIDtoPicking();
            } else {
                log.info("Realise order Mode on {}", currentCRTchannel.name());
//            AllOrdersPage allOrdersPage = secondPage.clickAllOrders();
//            log.info(searchedOrderID);
//            allOrdersPage.clickSearchButton(searchedOrderID);
//            allOrdersPage.clickViewHistoryButton();
//            log.info(ean);
//            allOrdersPage.readEANfromSectionOrder(ean);
//            allOrdersPage.clickReturnButton();
//            allOrdersPage.returnReason("5. Arrived too late");
//            allOrdersPage.clickCancel();
            }

            loggedPage.stopWebDriver();
        }

        log.info("CRT service stopped");
    }
}
