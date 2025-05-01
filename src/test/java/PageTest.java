import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class PageTest extends BaseTest {

LoginPage login;
ProductsPage productsPage; /*Take instance from every Class*/


   @DataProvider(name="TestData")
   public static Object [][] credentials() throws IOException {
       ExcelReader excelReader = new ExcelReader();
       return excelReader.getExcelData();
   }

    @Test(priority = 0,dataProvider = "TestData") /*Login Page Test*/
    public void testLogin(String username,String password) {
        login.typeUsername(username);
        login.verifyUsername("standard_user");

        login.typePassword(password);
        login.verifyPassword("secret_sauce");

        login.clickLoginButton();
    }

}
