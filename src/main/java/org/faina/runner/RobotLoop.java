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
import static org.faina.configuration.robotenums.ShopChanelTitle.*;

/**
 * Class Robot Loop
 * execute picking orders from CRT Store ordering interface chanel
 * (c) Marek Wozniak 2022.02
 */
public class RobotLoop {
    final static Logger log = LoggerFactory.getLogger(RobotLoop.class);
    private static int orderCounter = 0;
    private static final long orderAmount = Configurator.getAmountPickedOrders();

    public static void main(String[] args) throws InterruptedException, MyThrowableRepeatOrderException {
        log.info("----CRT robot started-v2-");
        Enum<LoginChanel> currentCRTchannel = NO_CHANEL;
        if (Configurator.getLoginServicedChanel().equals("HAMBURG")) {
            currentCRTchannel = HAMBURG;
        }
        if (Configurator.getLoginServicedChanel().equals("ROSTOCK")) {
            currentCRTchannel = ROSTOCK;
        }

        if (currentCRTchannel != NO_CHANEL) {
            serviceShopChanel(currentCRTchannel);  //entry to the service
        }
        log.info("###-CRT robot stopped-###");
    }

    private static void serviceShopChanel(Enum<LoginChanel> storeChanelEnum) throws InterruptedException, MyThrowableRepeatOrderException {
        log.info("Ordering for {}", storeChanelEnum.name());
        LoginPage loggedPage = new LoginPage();
        StoreUser userStoreUser = new StoreUser(storeChanelEnum);
        OrderPage orderPage = loggedPage.loginAsUser(userStoreUser);
        orderPage.clickOkCookies();
        ArrayList<ShopChanelTitle> shopingSequence = new ArrayList<>();

        if (!SHOP_CHANEL1.getShopChanelTitle().equals(SKIP_CHANEL.getShopChanelTitle())) {
            shopingSequence.add(SHOP_CHANEL1);
        }
        if (!SHOP_CHANEL2.getShopChanelTitle().equals(SKIP_CHANEL.getShopChanelTitle())) {
            shopingSequence.add(SHOP_CHANEL2);
        }
        if (!SHOP_CHANEL3.getShopChanelTitle().equals(SKIP_CHANEL.getShopChanelTitle())) {
            shopingSequence.add(SHOP_CHANEL3);
        }


        for (ShopChanelTitle title : shopingSequence) {
            try {
                orderPage.setupProperShopChanel(title);
                while (continueLoop(orderPage)) {
                    try {
                        String currentOrder = orderPage.getOrderIDtoPicking();
                        System.out.println(currentOrder);
                    } catch (MyThrowableRepeatOrderException myThrowableRepeatOrderException) {
                        String currentOrder = orderPage.getOrderIDtoPicking();
                        System.out.println("repeated " + currentOrder);
                    }

                }
            } catch (NoMoreOrdersException noMoreOrders) {
                log.info("No orders on this channel");
            }
        }
        loggedPage.quitLoginPage();
    }

    private static boolean continueLoop(OrderPage orderPage) throws NoMoreOrdersException {
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
        if (orderCounter < (orderAmount + 1)) {
            pickNext = true;
            log.info("-------------------------");
            log.info("Manual odrering: processing {} / {}", orderCounter, orderAmount);
        }
        return pickNext;
    }
}
