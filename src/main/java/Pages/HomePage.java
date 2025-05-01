package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    By addTocart=By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]");
    By removeBack=By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)");
    By cart_link =By.xpath("//*[name()='path' and contains(@fill,'currentCol')]");
   By checkout_button= By.xpath("//a[@class='btn_action checkout_button']");
    String user_name="standard_user";
    String password="<PASSWORD>";
    By first_name_feild=By.id("first-name");
    By last_name_feild=By.id("last-name");
    By Zipcode_feild=By.id("postal-code");
    By continue_button=By.xpath("//input[@value='CONTINUE']");
    By finsh=By.xpath("//a[@class='btn_action cart_button']");
    By orderFinsh=By.xpath("//h2[@class='complete-header']");
    public HomePage(WebDriver driver) {
        this.driver = driver;

    }


    public void ClickAddToCart() {
        driver.findElement(addTocart).click();
    }

    public void verifyAddToCart() {
        driver.findElement(removeBack).isDisplayed();
    }

    public void clickCartLink() {
        driver.findElement(cart_link).click();
    }

    public void verifCartIsclicked(String redirectedURL) {
        Assert.assertEquals(redirectedURL, driver.getCurrentUrl());

    }

    public void clickCheckoutButton() {
        driver.findElement(checkout_button).click();
    }

    public void verifyCheckoutButton(String redirectedURL) {
        Assert.assertEquals(redirectedURL, driver.getCurrentUrl());
    }
    public void typeFirstName(String firstName){
        Assert.assertEquals(driver.findElement(first_name_feild).getAttribute("placeholder"),"First Name");
        driver.findElement(first_name_feild).sendKeys(firstName);
    }


    public void typeLastName(String lastName){
        Assert.assertEquals(driver.findElement(last_name_feild).getAttribute("placeholder"),"Last Name");
        driver.findElement(last_name_feild).sendKeys(lastName);


    }
    public void typeZipcode(String zipcode){
        Assert.assertEquals(driver.findElement(Zipcode_feild).getAttribute("placeholder"),"Zip/Postal Code");
        driver.findElement(Zipcode_feild).sendKeys(zipcode);
    }
    public void clickContinueButton(){
        driver.findElement(continue_button).click();
    }
    public void finishCeckout(){
        driver.findElement(finsh).click();
    }
    public void verefyCheckoutFinsh(){
        Assert.assertEquals(driver.findElement(orderFinsh).getText(),"THANK YOU FOR YOUR ORDER");
    }



}

