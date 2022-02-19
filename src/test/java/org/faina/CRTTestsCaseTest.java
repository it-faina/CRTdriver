package org.faina;

import org.faina.configuration.Configurator;
import org.faina.webdriver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * CRT test cases
 */
public class CRTTestsCaseTest {
    final static Logger log = LoggerFactory.getLogger(CRTTestsCaseTest.class);
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        WebDriverProvider.start();
        driver = WebDriverProvider.getDriver();
    }

    @Test()
    public void connectedRetailLandingPageIsAccessibleTest() {
        driver.navigate().to(Configurator.getLandingPage());
        driver.manage().timeouts().implicitlyWait(Configurator.getImplicytyWait(), TimeUnit.SECONDS);
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Sign In with"));
    }

    /**
     * CRT Log chanel testing
     */
    @Test
    public void logShouldAddChannelNameTest() {
        log.info("**Test log message for {} chanel**", Configurator.getLoginServicedChanel());
        assertTrue(true);
    }


    @Test(enabled = false)
    public void shouldAnswerWithTrueTest() {
        assertTrue(true);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
