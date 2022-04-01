package pages;

import infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(id="finish")
    WebElement finishButton;

    @FindBy(css="div.page_wrapper div.checkout_summary_container div.cart_list div.cart_item div.cart_item_label div.item_pricebar:nth-child(3) > div.inventory_item_price")
    WebElement backpackValue;

    public CheckoutOverviewPage(WebDriver pDriver) {
        super(pDriver);
    }

    public CheckoutCompletePage finishOrder(){
        click(finishButton);
        return new CheckoutCompletePage(getDriver());
    }

    public String getBackpackValue(){
        return getText(backpackValue);
    }


}
