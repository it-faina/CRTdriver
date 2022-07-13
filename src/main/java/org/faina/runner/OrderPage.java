package org.faina.runner;

import org.faina.configuration.robotenums.ShopChanelTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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
        sleepOrderPage(4000);
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


    boolean isNextOrderToPick() throws NoMoreOrdersException {
        try {
            log.info("-------------------------");
            WebDriverWait webDriverWait = new WebDriverWait(driver, 6);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='channel-order-number']")));
        } catch (TimeoutException e) {
            log.info("No new order to pick up at this time");
            throw new NoMoreOrdersException("no more orders found: ");
        }
        return true;
    }

    public void setupProperShopChanel(ShopChanelTitle titleEnum) throws InterruptedException {

        if (!isTheSameNameShopChannel(titleEnum)) {
            WebElement shopChanelButton = driver.findElement(By.xpath("//button[contains(@class,'v-app-bar__nav-icon')]"));
            shopChanelButton.click();
            sleepOrderPage(1000);

            WebElement switchStorePullDownElement = driver.findElement(By.xpath("//div[text()='Switch store']"));
            sleepOrderPage(1000);

            try {
                WebElement element = driver.findElement(By.xpath("//div[contains(@class,'v-list-group__header__append-icon')]/parent::div[contains(@class,'active')]"));
            } catch (Exception e) {
                switchStorePullDownElement.click();
                sleepOrderPage(1000);
            }


            List<WebElement> shopsToChose = switchStorePullDownElement.findElements(By.xpath("./following::div[@data-test='list-of-store']/child::a[contains(@class,'v-list-item')]"));
            for (WebElement webElement : shopsToChose) {
                WebElement shopToBeOperate = webElement.findElement(By.xpath(".//div/div"));
                String shopPosition = shopToBeOperate.getText();
                if (shopPosition.equals(titleEnum.getShopChanelTitle())) {
                    shopToBeOperate.click();
                    sleepOrderPage(1000);
                    break;
                }
            }
        }

        log.info("Shop to be operated: " + getCurrentShop());
        sleepOrderPage(2000);
    }


    private boolean isTheSameNameShopChannel(ShopChanelTitle title) throws InterruptedException {
        String currentShop = getCurrentShop();
        return currentShop.equals(title.getShopChanelTitle());
    }

    private String getCurrentShop() throws InterruptedException {
        sleepOrderPage(2000);
        WebElement storeTitle = driver.findElement(By.xpath("//div[@data-test='active-store-name']"));
        return storeTitle.getText();
    }

    public String getOrderIDtoPicking() throws InterruptedException, MyThrowableRepeatOrderException, NoMoreOrdersException {
        WebElement orderIDText = driver.findElement(By.xpath("//span[@class='channel-order-number']"));
        String orderedNow = orderIDText.getText().substring(6, 20);
        log.info("Run order: {}", orderedNow);

        try {
            List<WebElement> baseOrderID = driver.findElements(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::section[@class='py-2 px-0 flex-column order-line'] "));
            String eanToPick;

            for (WebElement element : baseOrderID) {
                WebElement ean = element.findElement(By.xpath("./descendant::div[text()='EAN: ']"));
                eanToPick = ean.getText();
                log.info("Picked {}", eanToPick);
                WebElement picked = element.findElement(By.xpath("./descendant::button[contains(@class,'order-line__pick__button')]"));
                String backgroundPickedButton = picked.getCssValue("background-color");
                String color = Color.fromString(backgroundPickedButton).asHex();
                log.info("picked button background {}", color);
                //check if button was marked (has a background green color)
                if (!color.equals("#43a047")) {
                    picked.click();
                }
            }

            WebElement printButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'documents-printing__button-print')]"));
            printButton.click();

            WebElement completeButton = driver.findElement(By.xpath("//span[text()='" + orderedNow + "']/ancestor::div[contains(@class,'v-card v-sheet theme--light')]/descendant::button[contains(@class,'order_fulfillment-button_complete')]"));
            completeButton.click();

        } catch (Exception exception) {
            log.error("error in complete after printing ", exception);
            throw new MyThrowableRepeatOrderException("repeat this order");

        } finally {
            sleepOrderPage(1000);
            driver.navigate().refresh();
            sleepOrderPage(3000);
        }
        return orderedNow;
    }

    public void sleepOrderPage(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public void logoutOrderPage() throws InterruptedException {
        WebElement shopChanelButton = driver.findElement(By.xpath("//button[contains(@class,'v-app-bar__nav-icon')]"));
        shopChanelButton.click();
        sleepOrderPage(1000);
        WebElement logoutButton = driver.findElement(By.xpath("//div[text()='Logout']"));
        logoutButton.click();
        log.info("Logged out from the shop service");
    }
}
