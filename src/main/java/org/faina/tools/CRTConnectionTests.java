package org.faina.tools;

import org.faina.configuration.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Connected Retail web driver services DEMO
 */
public class CRTConnectionTests {
    final static Logger log = LoggerFactory.getLogger(CRTConnectionTests.class);

    public static void pushInfoLogMessage() {
        log.info("Sandbox testing message");
        System.out.println(Configurator.getWebdriverDir());
        System.out.println(Configurator.getImplicytyWait());
    }
}
