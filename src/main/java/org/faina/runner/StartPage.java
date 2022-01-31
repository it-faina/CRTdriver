package org.faina.runner;

import org.faina.webdriver.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {

    public SecondPage loginAsAdmin() throws InterruptedException {
        WebDriverProvider.start(3000);
        WebDriver driver = WebDriverProvider.getDriver();

        driver.navigate().to("https://connected-retail.zalando.com/");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement userName = driver.findElement(By.xpath("//input[@id='1-email']"));
        //homeyer@motion-fashion.de
        //HanseaticRetailManagementGmbH123!
        //crt@tuffskull.de
        //UnitedFashionSalesGmbH123!
        userName.sendKeys("homeyer@motion-fashion.de");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("HanseaticRetailManagementGmbH123!");
        WebElement button = driver.findElement(By.xpath("//*[@id='auth0-lock-container-1']/div/div[2]/form/div/div/div/button"));
        button.click();
        return new SecondPage(driver);
    }


    void stopWebDriver() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverProvider.quit();
    }

}
