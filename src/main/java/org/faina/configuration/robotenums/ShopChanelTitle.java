package org.faina.configuration.robotenums;

import org.faina.configuration.Configurator;

/**
 * convert shop chanel title taken from config.properties to enum entry
 */
public enum ShopChanelTitle {

    SHOP_CHANEL1(Configurator.getShopChanel1Title()),
    SHOP_CHANEL2(Configurator.getShopChanel2Title()),
    SHOP_CHANEL3(Configurator.getShopChanel3Title());

    private final String title;

    ShopChanelTitle(String shopChanelTitle) {
        this.title = shopChanelTitle;
    }

    public String getShopChanelTitle() {
        return title;
    }
}
