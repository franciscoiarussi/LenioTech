package tests;

import infrastructure.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.TestProperties;

public abstract class BaseTest {

    protected final String BASE_URL= TestProperties.getInstance().getString("base.url");
    protected WebDriver driver;
    protected SoftAssert softAssertion = new SoftAssert();

    @BeforeClass
    public void setupBrowser(){
        driver = DriverManager.getWebDriver();
    }

    @BeforeMethod
    public void goToLogin(){
        driver.get(BASE_URL);
    }

    @AfterClass
    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}
