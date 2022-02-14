package org.faina.runner;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Class Order Page
 * service order on CRT ordering page
 */
public class OrderPage extends LoginPage {
    final static Logger log = LoggerFactory.getLogger(OrderPage.class);

    WebDriver driver;
    WebDriver.Timeouts timeouts;


    public OrderPage(WebDriver driver, WebDriver.Timeouts timeouts) {
        this.driver = driver;
        this.timeouts = timeouts;
    }

    void clickOkCookies() throws InterruptedException {
        Thread.sleep(4000);
        WebElement cookies = driver.findElement(By.xpath("//*[@id='uc-btn-accept-banner']"));
        cookies.click();
    }

    AllOrdersPage clickAllOrders() {
        WebElement allOrders = driver.findElement(By.xpath("//div[@class='v-tabs__div content__tab'][2]/a"));
        allOrders.click();
        return new AllOrdersPage(driver, timeouts);
    }

    void clickSearchButton(String orderID) throws InterruptedException {
        WebElement searchWebElement = driver.findElement(By.xpath("//div[@class='v-input__control']//input"));
        searchWebElement.sendKeys(orderID);
    }



    boolean isNextOrderToPick() {
        try {
            log.info("-------------------------");
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='order-header__order-number']")));
        } catch (TimeoutException e) {
            log.info("No new order to pick up at this time");
            return false;
        }
        return true;
    }

    String getOrderIDtoPicking() throws InterruptedException {
        WebElement orderIDText = driver.findElement(By.xpath("//span[@class='order-header__order-number']")); //if no this object create exception
        String orderedNow = orderIDText.getText().substring(6, 20);

        log.info("Run order: {}", orderedNow);
        List<WebElement> baseOrderID = driver.findElements(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::section[@class='order-line'] "));
        String eanToPick = "init";
        for (WebElement element : baseOrderID
        ) {
            WebElement ean = element.findElement(By.xpath("./descendant::div[text()='EAN: ']"));
            eanToPick = ean.getText();
            log.info("Picked {}", eanToPick);
            WebElement picked = element.findElement(By.xpath("./descendant::button[contains(@class,'order-line__pick__button')]"));
            //check if button was markeded (has a green color)
            if (!picked.getAttribute("class").equals("order-line__pick__button v-btn v-btn--active v-btn--flat theme--light")){
                picked.click();
            }
        }
        WebElement completeButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'order_fulfillment-button_complete')]"));
        boolean isCompleteButtonEnabled = completeButton.isEnabled();
        if (isCompleteButtonEnabled) {
            try {
                completeButton.click();
            } catch (Exception e) {
                boolean isPupUpPresent = driver.findElement(By.xpath("//div[text()='Unselect picked?']")).isDisplayed();
                if (isPupUpPresent) {
                    log.error("COMPLITE button not active", e);
                    log.info("pup up at {} serviced", eanToPick);
                    WebElement cancelButtonOnPupUpWindow = driver.findElement(By.xpath("//div[text()='Cancel']"));
                    cancelButtonOnPupUpWindow.click();
                }
                Thread.sleep(2000);
                completeButton.click();
            }
        } else {
            WebElement printButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'documents-printing__button-print')]"));
            try {
                printButton.click();
            } catch (Exception e) {
                log.error("PRINT button not active", e);
            }
            try {
                completeButton.click();
            } catch (Exception e) {
                log.error("COMPLETE button not active", e);
            }
        }
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        return orderedNow;
    }
}
