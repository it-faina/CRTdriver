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

    public OrderPage loginAsUser(StoreUser loggedCRTStoreUser) throws InterruptedException {
        WebDriverProvider.start();
        WebDriver driver = WebDriverProvider.getDriver();
        WebDriver.Timeouts timeouts = WebDriverProvider.getTimeouts();
        driver.navigate().to(Configurator.getLandingPage());
        WebElement userName = driver.findElement(By.xpath("//input[@id='input27']"));
        userName.sendKeys(loggedCRTStoreUser.getLogin());
        WebElement button = driver.findElement(By.xpath("//*[@id=\"form19\"]/div[2]/input"));
        button.click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("//input[@id='input59']"));
        password.sendKeys(loggedCRTStoreUser.getPassword());
        WebElement button_weryfikuj = driver.findElement(By.xpath("//*[@id=\"form51\"]/div[2]/input"));
        button_weryfikuj.click();
        log.info("{} channel.", loggedCRTStoreUser.getConnectedRetailInfo());
        return new OrderPage(driver, timeouts);
    }

    void quitLoginPage() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverProvider.quit();
    }
}
