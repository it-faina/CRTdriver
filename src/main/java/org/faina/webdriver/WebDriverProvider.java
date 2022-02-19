package org.faina.webdriver;

import org.faina.configuration.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


/**
 * Class Web Driver Provider - service Chrome Driver only
 */
public class WebDriverProvider {

    private static WebDriver driver;
    private static WebDriver.Timeouts timeouts;
    private static final String CHROMEDRIVER = "chromedriver.exe";

    private WebDriverProvider() {
    }

    public static void start() {
        System.setProperty("webdriver.chrome.driver", Configurator.getWebdriverDir() + CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Configurator.getImplicytyWait()));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    /**
     * Method to get WebDriver
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver.Timeouts getTimeouts() {
        return timeouts;
    }


    /**
     * Method to quit WebDriver
     */
    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
