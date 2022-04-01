package pages;

import infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id="checkout")
    WebElement checkoutButton;

    @FindBy(css="div.page_wrapper div.cart_contents_container div.cart_list div.cart_item div.cart_item_label div.item_pricebar:nth-child(3) > div.inventory_item_price")
    WebElement backpackValue;

    public CartPage(WebDriver pDriver) {
        super(pDriver);
    }

    public CheckoutInformationPage clickCheckout(){
        click(checkoutButton);
        return new CheckoutInformationPage(getDriver());
    }

    public String getBackpackValue(){
        return getText(backpackValue);
    }


}
