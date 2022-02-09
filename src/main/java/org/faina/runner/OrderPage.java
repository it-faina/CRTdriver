package org.faina.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage extends LoginPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    void showTopic() throws InterruptedException {
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println("TITLE: " + title);

    }

    void clickOkCookies() throws InterruptedException {
        Thread.sleep(4000);
        WebElement cookies = driver.findElement(By.xpath("//*[@id='uc-btn-accept-banner']"));
        cookies.click();
        Thread.sleep(4000);
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
        String orderedNow = orderIDText.getText().substring(6, 20);
        log.info("----------------------------------");
        log.info("Run order: {}", orderedNow);
        List<WebElement> baseOrderID = driver.findElements(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::section[@class='order-line'] "));
        for (WebElement element : baseOrderID
        ) {
            WebElement ean = element.findElement(By.xpath("./descendant::div[text()='EAN: ']"));
            String eanToPick = ean.getText();
            log.info("Picked {}", eanToPick);
            WebElement picked = element.findElement(By.xpath("./descendant::button[contains(@class,'order-line__pick__button')]"));
            picked.click();
        }
        WebElement printButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'documents-printing__button-print')]"));
        printButton.click();
        WebElement completeButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'order_fulfillment-button_complete')]"));
        completeButton.click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        return orderedNow;
    }
}
