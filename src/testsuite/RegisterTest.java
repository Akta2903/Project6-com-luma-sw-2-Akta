package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest
{
    String baseUrl = "https://magento.softwaretestingboard.com";

    @Before

    public void setBaseUrl()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplayed()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")).click();
        String expectedMessage = "Create New Customer Account";
        WebElement actualMessage = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessageText = actualMessage.getText();

        Assert.assertEquals("User is not navigated to create an account",expectedMessage,actualMessageText);

    }
    //NZqjFg2X46k6Nui
    @Test
    public void userShouldRegisterAccountSuccessfully()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Akta");
        driver.findElement(By.id("lastname")).sendKeys("Patel");
        driver.findElement(By.name("is_subscribed")).click();
        driver.findElement(By.id("email_address")).sendKeys("akta123456@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Akta@123456");
        driver.findElement(By.id("password-confirmation")).sendKeys("Akta@123456");
        driver.findElement(By.xpath("//button[@class='action submit primary']//span[contains(text(),'Create an Account')]")).click();
        String expectedMessage = "Thank you for registering with Main Website Store.";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='message-success success message']"));
        String actualMessageText = actualMessage.getText();
        Assert.assertEquals("False",expectedMessage,actualMessageText);
        driver.findElement(By.xpath("//div[@class='panel header']//span[@class='customer-name']//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//div[@class='panel wrapper']//div[@class='customer-menu']//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String expectedMessage1= "You are signed out";
        WebElement actualMessage1= driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessageText1 = actualMessage1.getText();
        Assert.assertEquals("False",expectedMessage1,actualMessageText1);
        System.out.println(actualMessageText1);



    }



    @After

    public void tearDown()
    {
        closeBrowser();
    }

}
