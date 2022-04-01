package pages;

import infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id="last-name")
    WebElement lastName;

    @FindBy(id="postal-code")
    WebElement postalCode;

    @FindBy(id="continue")
    WebElement continueButton;


    public CheckoutInformationPage(WebDriver pDriver) {
        super(pDriver);
    }

    public CheckoutOverviewPage completeInformation(String firstName, String lastName, String postalCode){
        sendKeys(this.firstName, firstName);
        sendKeys(this.lastName, lastName);
        sendKeys(this.postalCode, postalCode);
        click(continueButton);
        return new CheckoutOverviewPage(getDriver());
    }


}
