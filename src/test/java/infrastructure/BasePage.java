package infrastructure;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        driver = pDriver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    protected void sendKeys(WebElement element, String keys) {
        getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    }

    protected void click(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected boolean isDisplayed(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected String getText(WebElement element) {
        try {
            return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return null;
        }
    }

}
