package tests;


import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.TestProperties;

public class LoginTest extends BaseTest {

    @Test
    @Description("This test tries to login with wrong credentials and expect that the UI throws an error message")
    public void testIncorrectLoginCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("THIS_IS_AN_INCORRECT_USERNAME","THIS_IS_AN_INCORRECT_PASSWORD");
        softAssertion.assertTrue(loginPage.errorMessageShowsUp("Epic sadface: Username and password do not match any user in this service"));
        softAssertion.assertEquals(loginPage.countErrorIcons(),2);
        softAssertion.assertAll();
    }

    @Test
    @Description("Happy path of login and validation that the cart is visible on home page. Also validate de URL after login")
    public void testCorrectLoginCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        String username= TestProperties.getInstance().getString("username");
        String password= TestProperties.getInstance().getString("password");
        HomePage homePage = loginPage.login(username,password);
        softAssertion.assertTrue(homePage.isCartVisible());
        softAssertion.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        softAssertion.assertAll();
    }

}
