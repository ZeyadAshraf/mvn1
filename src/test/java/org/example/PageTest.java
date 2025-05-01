package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageTest extends BaseTest {
    private WebDriver driver;
    private LoginPage login;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "/src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com");
        login = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        login.typeUsername("standard_user");
        login.verifyUsername("standard_user");

        login.typePassword("secret_sauce");
        login.verifyPassword("secret_sauce");

        login.clickLoginButton();
        login.verifyLoginButton("https://www.saucedemo.com/v1/inventory.html");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
