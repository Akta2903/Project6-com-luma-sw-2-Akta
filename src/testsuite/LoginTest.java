package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest

{

    String baseUrl = "https://magento.softwaretestingboard.com";

    @Before

    public void setBaseUrl()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In ')]")).click();
        driver.findElement(By.id("email")).sendKeys("akta1234@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Akta@1234");
        driver.findElement(By.xpath("//button[@class='action login primary']//span[(contains(text(),'Sign In'))]")).click();
        String expectedMessage = "Welcome";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome, Akta Patel!')]"));
        String actualMessageText = actualMessage.getText().substring(0,7);
        Assert.assertEquals("False",expectedMessage,actualMessageText);
       // System.out.println(actualMessageText);


    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In ')]")).click();
        driver.findElement(By.id("email")).sendKeys("akta124@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Akta@124");
        driver.findElement(By.xpath("//button[@class='action login primary']//span[(contains(text(),'Sign In'))]")).click();
        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualMessage= driver.findElement(By.xpath("//div[@class='page messages']//div[@class='message-error error message'] //div"));
        String actualMessageText = actualMessage.getText();
      //  System.out.println(actualMessageText);
        Assert.assertEquals("User is not logged in successfully",expectedMessage,actualMessageText);
    }
    @Test
    public void  userShouldLogOutSuccessfully()
    {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In ')]")).click();
        driver.findElement(By.id("email")).sendKeys("akta1234@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Akta@1234");
        driver.findElement(By.xpath("//button[@class='action login primary']//span[(contains(text(),'Sign In'))]")).click();
        String expectedMessage = "Welcome";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome, Akta Patel!')]"));
        String actualMessageText = actualMessage.getText().substring(0,7);
        Assert.assertEquals("False",expectedMessage,actualMessageText);
        driver.findElement(By.xpath("//div[@class='panel header']//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//li[@class='customer-welcome active']//div[@class='customer-menu']//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String expectedMessage1 = "You are signed out";
        WebElement actualMessage1 = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessageText1 = actualMessage1.getText();
        Assert.assertEquals("You are Signed Out",expectedMessage1,actualMessageText1);


    }


    @After

    public void tearDown()
    {
        closeBrowser();
    }


}
