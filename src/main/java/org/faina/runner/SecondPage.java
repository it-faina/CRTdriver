package org.faina.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondPage extends StartPage {
    WebDriver driver;

    public SecondPage(WebDriver driver) {
        this.driver = driver;
    }

    void showTopic() throws InterruptedException {
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println("TITLE: " + title);

    }

    void clickOkCookies() {
        WebElement cookies = driver.findElement(By.xpath("//*[@id='uc-btn-accept-banner']"));
        cookies.click();
    }


    AllOrdersPage clickAllOrders() throws InterruptedException {
        Thread.sleep(3000);
        WebElement allOrders = driver.findElement(By.xpath("//div[@class='v-tabs__div content__tab'][2]/a"));
        allOrders.click();
        return new AllOrdersPage(driver);
    }

    void clickSearchButton(String orderID) throws InterruptedException {
        Thread.sleep(3000);
        WebElement searchWebElement = driver.findElement(By.xpath("//div[@class='v-input__control']//input"));
        searchWebElement.sendKeys(orderID);

    }

    String getOrderIDtoPicking() throws InterruptedException {
        Thread.sleep(3000);
        WebElement orderIDText = driver.findElement(By.xpath("//span[@class='order-header__order-number']"));
        String orderedNow = orderIDText.getText();
        System.out.println("Pick uped: "+orderedNow);
//        orderedNow=orderedNow
        return orderedNow;
    }




    void pickAllEANPositions(String eanID) throws InterruptedException {
        String myORDER = getOrderIDtoPicking();
        WebElement eanPositionWebElement = driver.findElement(By.xpath(""));
        eanPositionWebElement.click();

    }


}
