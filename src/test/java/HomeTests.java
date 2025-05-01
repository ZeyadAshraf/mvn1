import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeTests {
    WebDriver driver;
    HomePage home;
    LoginPage login;
//    String user_name=loadProperties.userData.getProperty("username");
//    String password=loadProperties.userData.getProperty("password");

//    @DataProvider(name = "loginData")
//    public Object[][] loginData() {
//        return new Object[][]{
//                {"standard_user","secret_sauce"},//               {"problem_user","secret_sauce"}
////,                {"locked_out_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}
//
//        };
//    }

@DataProvider(name = "loginData")
public Object[][] loginData() throws Exception {
    ExcelReader excelReader = new ExcelReader();
    return excelReader.getExcelData();

}



    @Test()
    public void addToCart() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        login.typeUsername("standard_user");
        login.verifyUsername("standard_user");
        login.typePassword("secret_sauce");
        login.verifyPassword("secret_sauce");
        login.clickLoginButton();
        login.verifyLoginButton("https://www.saucedemo.com/v1/inventory.html");
        home.ClickAddToCart();
        home.verifyAddToCart();
        home.clickCartLink();
        home.verifCartIsclicked("https://www.saucedemo.com/v1/cart.html");
        home.clickCheckoutButton();
        home.verifyCheckoutButton("https://www.saucedemo.com/v1/checkout-step-one.html");
        home.typeFirstName("mohamed");
        home.typeLastName("tal3at");
        home.typeZipcode("22512");

        home.clickContinueButton();
        home.finishCeckout();
        home.verefyCheckoutFinsh();

//        home.verifyCheckoutButton("https://www.saucedemo.com/v1/checkout-complete.html");

    }

    @AfterClass
    public void tearDown() {

          //  driver.quit();

    }
}