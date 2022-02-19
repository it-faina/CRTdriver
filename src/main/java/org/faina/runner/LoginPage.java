package org.faina.runner;

import org.faina.configuration.Configurator;
import org.faina.configuration.StoreUser;
import org.faina.webdriver.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Login Page
 * serve login services
 */
public class LoginPage {
    final static Logger log = LoggerFactory.getLogger(LoginPage.class);

    public OrderPage loginAsUser(StoreUser loggedCRTStoreUser) {
        WebDriverProvider.start();
        WebDriver driver = WebDriverProvider.getDriver();
        WebDriver.Timeouts timeouts = WebDriverProvider.getTimeouts();
        driver.navigate().to(Configurator.getLandingPage());
        WebElement userName = driver.findElement(By.xpath("//input[@id='1-email']"));
        userName.sendKeys(loggedCRTStoreUser.getLogin());
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(loggedCRTStoreUser.getPassword());
        WebElement button = driver.findElement(By.xpath("//*[@id='auth0-lock-container-1']/div/div[2]/form/div/div/div/button"));
        button.click();
        log.info("Logged {} channel.", loggedCRTStoreUser.getConnectedRetailInfo());
        return new OrderPage(driver, timeouts);
    }

    void quitLoginPage() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverProvider.quit();
    }
}
