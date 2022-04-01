package pages;

import infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "error_icon")
    List<WebElement> errorIcons;

    @FindBy(css = "div.login_wrapper div.login_wrapper-inner div.form_column div.login-box form:nth-child(1) div.error-message-container.error:nth-child(3) > h3:nth-child(1)")
    WebElement errorMessage;

    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }

    public HomePage login(String username, String password) {
        sendKeys(this.username, username);
        sendKeys(this.password, password);
        click(loginButton);
        return new HomePage(getDriver());
    }

    public boolean errorMessageShowsUp(String error){
        return error.equals(getText(errorMessage));
    }

    public int countErrorIcons(){
        return errorIcons.size();
    }

}
