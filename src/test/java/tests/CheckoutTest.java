package tests;


import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.*;
import utils.TestProperties;

public class CheckoutTest extends BaseTest {

    @Test
    @Description("Checkout complete flow with price validations between pages")
    public void testCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(TestProperties.getInstance().getString("username"),TestProperties.getInstance().getString("password"));
        String backpackValue = homePage.getBackpackValue();;
        CartPage cartPage = homePage.addBackpackToCart();
        softAssertion.assertEquals(backpackValue,cartPage.getBackpackValue());
        CheckoutInformationPage checkPage = cartPage.clickCheckout();
        CheckoutOverviewPage overviewPage = checkPage.completeInformation("Francisco", "iarussi", "7000");
        softAssertion.assertEquals(backpackValue,overviewPage.getBackpackValue());
        CheckoutCompletePage completeCheckoutPage = overviewPage.finishOrder();
        softAssertion.assertEquals(completeCheckoutPage.getTitleText(),"CHECKOUT: COMPLETE!");
        softAssertion.assertEquals(completeCheckoutPage.getHeaderText(),"THANK YOU FOR YOUR ORDER");
        softAssertion.assertAll();
    }

    @Test
    @Description("Checkout complete flow with price validations between pages")
    public void testCheckoutFail(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(TestProperties.getInstance().getString("username"),TestProperties.getInstance().getString("password"));
        String backpackValue = homePage.getBackpackValue();;
        CartPage cartPage = homePage.addBackpackToCart();
        softAssertion.assertEquals(backpackValue,cartPage.getBackpackValue());
        CheckoutInformationPage checkPage = cartPage.clickCheckout();
        CheckoutOverviewPage overviewPage = checkPage.completeInformation("Francisco", "iarussi", "7000");
        softAssertion.assertEquals(backpackValue,overviewPage.getBackpackValue());
        CheckoutCompletePage completeCheckoutPage = overviewPage.finishOrder();
        softAssertion.assertEquals(completeCheckoutPage.getTitleText(),"Finish");
        softAssertion.assertEquals(completeCheckoutPage.getHeaderText(),"THANK YOU FOR YOUR ORDER");
        softAssertion.assertAll();
    }




}
