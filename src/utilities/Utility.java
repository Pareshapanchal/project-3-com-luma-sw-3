package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Utility extends BaseTest {
    String baseUrl ="https://magento.softwaretestingboard.com/";
    String browser ="Chrome";

    @Before
    public void setUp(){
        openBrowser(baseUrl,browser);
    }
    public void mouseHoverOn(By by){
        Actions actions = new Actions(driver);
        WebElement title = driver.findElement(by);
        actions.moveToElement(title).build().perform();
    }
    public void mouseHoverOnAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement titleToClick = driver.findElement(by);
        actions.moveToElement(titleToClick).click().build().perform();
    }
    public void selectFromDropDown(By by, String text){
        WebElement sortBy = driver.findElement(by);
        Select select = new Select(sortBy);
        select.selectByVisibleText(text);
    }
    public void storeListElement(By by){
        List<WebElement> productName = driver.findElements(by);
        List<String> list = new ArrayList<>();
        for ( WebElement element : productName){
            list.add(element.getText());
        }
    }
    public void verifyNavigatePageTitle(By by,String expectedMessage){
        String acctualMessage = driver.findElement(by).getText();
        Assert.assertEquals("Not Match",expectedMessage,acctualMessage);
    }
    public void sendValue(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public void clearBox(By by){
        WebElement element = driver.findElement(by);
        element.clear();
    }
    public void clickOnElement(By by){
        driver.findElement(by).click();

    }



 }
