package org.faina.runner;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPage extends LoginPage {
    WebDriver driver;
    WebDriver.Timeouts timeouts;
    private int orderManualCount = 0;

    public OrderPage(WebDriver driver, WebDriver.Timeouts timeouts) {
        this.driver = driver;
        this.timeouts = timeouts;
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

    /**
     * use this method if you want pick orderManualCount-1 objects
     *
     * @return true - continue pickling; false stop picking
     */
    boolean isOrderToPick() {
        orderManualCount++;
        return orderManualCount != 4; // example if 4  then 3 orders will be picked
    }

    boolean isNextOrderToPick() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='order-header__order-number']")));
        } catch (TimeoutException e) {
            log.info("No fresh order to pick up");
            return false;
        }
        return true;
    }

    String getOrderIDtoPicking() throws InterruptedException {
        WebElement orderIDText = driver.findElement(By.xpath("//span[@class='order-header__order-number']")); //if no this object create exception
        String orderedNow = orderIDText.getText().substring(6, 20);
        log.info("------------------------");
        log.info("Run order: {}", orderedNow);
        List<WebElement> baseOrderID = driver.findElements(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::section[@class='order-line'] "));
        String eanToPick = "init";
        for (WebElement element : baseOrderID
        ) {
            WebElement ean = element.findElement(By.xpath("./descendant::div[text()='EAN: ']"));
            eanToPick = ean.getText();
            log.info("Picked {}", eanToPick);
            WebElement picked = element.findElement(By.xpath("./descendant::button[contains(@class,'order-line__pick__button')]"));
            picked.click();
        }
        WebElement completeButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'order_fulfillment-button_complete')]"));
        boolean isCompleteButtonEnabled = completeButton.isEnabled();
        if (isCompleteButtonEnabled) {
            try {
                completeButton.click();
            } catch (Exception e) {
                boolean isPupUpPresent = driver.findElement(By.xpath("//div[text()='Unselect picked?']")).isDisplayed();
                if (isPupUpPresent) {
                    log.info("pup up was shown at {}", eanToPick);
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
                log.info("Print Button not active");
            }
            try {
                completeButton.click();
            } catch (Exception e) {
                log.info("COMPLETE button not active");
            }
        }
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        return orderedNow;
    }
}
