package org.faina;

import org.faina.configuration.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Connected Retail web driver services DEMO
 */
public class AppSandbox {
    final static Logger log = LoggerFactory.getLogger(AppSandbox.class);

    public static void main(String[] args) {
        log.info("Sandbox testing message");
        System.out.println(Configurator.getWebdriverDir());
        System.out.println(Configurator.getImplicytyWait());
    }
}
