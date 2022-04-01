package pages;

import infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id="shopping_cart_container")
    WebElement cart;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement backpackButton;

    @FindBy(css="div.page_wrapper div.inventory_container div.inventory_list div.inventory_item:nth-child(1) div.inventory_item_description div.pricebar > div.inventory_item_price")
    WebElement backpackValue;

    public HomePage(WebDriver pDriver) {
        super(pDriver);
    }

    public boolean isCartVisible(){
        return isDisplayed(cart);
    }

    public CartPage addBackpackToCart(){
        click(backpackButton);
        click(cart);
        return new CartPage(getDriver());
    }

    public String getBackpackValue(){
        return getText(backpackValue);
    }


}
