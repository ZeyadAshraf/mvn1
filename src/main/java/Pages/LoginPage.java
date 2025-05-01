package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    By username_field=By.id("user-name");
    By password_field=By.id("password");
    By login_button=By.id("login-button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void typeUsername(String username){
        driver.findElement(username_field).sendKeys(username);
    }
    public void typePassword(String password){
        driver.findElement(password_field).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(login_button).click();

    }
    public void verifyUsername( String username){
        Assert.assertEquals(username,driver.findElement(username_field).getAttribute("value"));

    }
    public void verifyPassword(String password){
        Assert.assertEquals(password,driver.findElement(password_field).getAttribute("value"));
    }
    public void verifyLoginButton(String redirectedURL){
        Assert.assertEquals(redirectedURL,driver.getCurrentUrl());

    }

}

