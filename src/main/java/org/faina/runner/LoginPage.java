package org.faina.runner;

import org.faina.configuration.Configurator;
import org.faina.configuration.Credentials;
import org.faina.webdriver.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    final static Logger log = LoggerFactory.getLogger(LoginPage.class);

    public OrderPage loginAsUser(Credentials loggedCRTCredentials) {
        WebDriverProvider.start();
        WebDriver driver = WebDriverProvider.getDriver();
        driver.navigate().to(Configurator.getLandingPage());
        WebElement userName = driver.findElement(By.xpath("//input[@id='1-email']"));
        userName.sendKeys(loggedCRTCredentials.getLogin());
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(loggedCRTCredentials.getPassword());
        WebElement button = driver.findElement(By.xpath("//*[@id='auth0-lock-container-1']/div/div[2]/form/div/div/div/button"));
        button.click();
        log.info("Logged {} channel.", loggedCRTCredentials.getConnectedRetailInfo());
        return new OrderPage(driver);
    }


    void stopWebDriver() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverProvider.quit();
    }
}
