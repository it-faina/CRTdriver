package org.faina.webdriver;

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

    public static void start(long implicityTime) {

        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(implicityTime, TimeUnit.SECONDS);

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
