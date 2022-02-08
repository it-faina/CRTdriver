package org.faina.webdriver;

import org.faina.configuration.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverProvider {

    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    private static final String CHROMEDRIVER = "chromedriver.exe";

    private WebDriverProvider() {
    }

    public static void start() {

        System.setProperty("webdriver.chrome.driver", Configurator.getWebdriverDir() + CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Configurator.getImplicytyWait(), TimeUnit.SECONDS);
    }

    /**
     * Method to get WebDriver
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver;
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
