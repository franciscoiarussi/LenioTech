package pages;

import infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(id="complete-header")
    WebElement finishButton;

    @FindBy(className="title")
    WebElement title;

    @FindBy(className="complete-header")
    WebElement header;

    public CheckoutCompletePage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getTitleText(){
        return getText(title);
    }

    public String getHeaderText(){
        return getText(header);
    }


}
