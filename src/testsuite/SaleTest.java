package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com";
    @Before

    public void setBaseUrl()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage()
    {
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/sale.html']//span[contains(text(),'Sale')]")).click();
        driver.findElement(By.xpath("//div[@class='categories-menu']//li//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']")).click();
        String expectedMessage = "Jackets";
        WebElement actualMessage = driver.findElement(By.xpath("//h1[@class='page-title']//span[@class='base']"));
        String actualMessageText = actualMessage.getText();
        List <WebElement> count = driver.findElements(By.xpath("//Strong[@class='product name product-item-name']"));
        int totalNoOfProductsOnPage = count.size();
        System.out.println("Total No of products displayed on page:" + totalNoOfProductsOnPage);
        for (WebElement products:count) {
            System.out.println("product :" + products.getText());

        }
        int expectedProductOnPage = 12;
        Assert.assertEquals("12 Products are displayed",expectedProductOnPage,totalNoOfProductsOnPage);


    }

    @After

    public void tearDown()
    {
        closeBrowser();
    }

}
