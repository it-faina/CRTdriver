package org.faina.runner;

import org.faina.configuration.Configurator;
import org.faina.configuration.StoreUser;
import org.faina.configuration.robotenums.LoginChanel;
import org.faina.configuration.robotenums.ShopChanelTitle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.faina.configuration.robotenums.LoginChanel.HAMBURG;
import static org.faina.configuration.robotenums.LoginChanel.ROSTOCK;
import static org.faina.configuration.robotenums.LoginChanel.NO_CHANEL;

/**
 * Class Robot Loop
 * execute picking orders from CRT Store ordering interface chanel
 * (c) Marek Wozniak 2022.02
 */
public class RobotLoop {
    final static Logger log = LoggerFactory.getLogger(RobotLoop.class);
    private static int orderCounter = 0;
    private static final long orderAmount = Configurator.getAmountPickedOrders();

    public static void main(String[] args) throws InterruptedException {
        log.info("----CRT robot started----");
        Enum<LoginChanel> currentCRTchannel = NO_CHANEL;
        if (Configurator.getLoginServicedChanel().equals("HAMBURG")) {
            currentCRTchannel = HAMBURG;
        }
        if (Configurator.getLoginServicedChanel().equals("ROSTOCK")) {
            currentCRTchannel = ROSTOCK;
        }

        if (currentCRTchannel != NO_CHANEL) {
            serviceShopChanel(currentCRTchannel);
        }
        log.info("###-CRT robot stopped-###");
    }

    private static void serviceShopChanel(Enum<LoginChanel> storeChanelEnum) throws InterruptedException {
        log.info("Ordering for {}", storeChanelEnum.name());
        LoginPage loggedPage = new LoginPage();
        StoreUser userStoreUser = new StoreUser(storeChanelEnum);
        OrderPage orderPage = loggedPage.loginAsUser(userStoreUser);
        orderPage.clickOkCookies();
        ArrayList<ShopChanelTitle> shopingSequence = new ArrayList<>();
        shopingSequence.add(ShopChanelTitle.SHOP_CHANEL2);
        shopingSequence.add(ShopChanelTitle.SHOP_CHANEL1);
        shopingSequence.add(ShopChanelTitle.SHOP_CHANEL3);

        for (ShopChanelTitle title : shopingSequence) {
            orderPage.setupProperShopChanel(title);
            while (continueLoop(orderPage)) {

                System.out.println(orderPage.getOrderIDtoPicking());
            }
        }


        loggedPage.quitLoginPage();
    }


    private static boolean continueLoop(OrderPage orderPage) {
        if (Configurator.getServiceToTheEndMode()) {
            return orderPage.isNextOrderToPick();
        } else {
            return orderPickingCounter();
        }

    }

    /**
     * use this method if you want pick orderManualCount objects
     *
     * @return true - continue pickling; false stop picking
     */
    private static boolean orderPickingCounter() {
        boolean pickNext = false;
        orderCounter++;
        if (orderCounter != (orderAmount + 1)) {
            pickNext = true;
            log.info("-------------------------");
            log.info("processing {} / {}", orderCounter, orderAmount);
        }
        return pickNext;
    }
}
