package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    @Test
    //1. verifyTheSortByProductNameFilter
    public void verifyTheSortByProductNameFilter()throws InterruptedException{
        // Mouse Hover on Women Menu
        mouseHoverOn(By.xpath(" //a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverOn(By.xpath("//a[@id='ui-id-9']"));
       // Click on Jackets
        Thread.sleep(2000);
        mouseHoverOnAndClick(By.xpath("//a[@id ='ui-id-11']"));
        // arrange the default products in alphabetical order to compare
        List<WebElement> productName = driver.findElements(By.xpath("//ol[@class='products list items product-items']//strong[@class='product name product-item-name']"));
        List<String> list = new ArrayList<>();
        for ( WebElement element : productName){
            list.add(element.getText());
        }
        Collections.sort(list);
        // Select Sort By filter “Product Name”
        selectFromDropDown(By.xpath("(//select[@id='sorter'])[1]"),"Product Name");
       // Verify the products name display in alphabetical order
        List<WebElement> productName1 = driver.findElements(By.xpath("//ol[@class='products list items product-items']//strong[@class='product name product-item-name']"));
        List<String> lista = new ArrayList<>();
        for ( WebElement element : productName1){
            lista.add(element.getText());
        }
        boolean message =list.equals(lista);
        Assert.assertTrue(message);
    }
    @Test
    //2. verifyTheSortByPriceFilter
    public void verifyTheSorByPriceFilter(){

        //Mouse Hover on Women Menu
        mouseHoverOn(By.xpath(" //a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverOn(By.xpath("//a[@id='ui-id-9']"));
        //click on Jackets
        mouseHoverOnAndClick(By.xpath("//a[@id ='ui-id-11']"));
        List<WebElement> productPrice = driver.findElements(By.xpath("//ol[@class='products list items product-items']//span[@class='price']"));
        List<String> price = new ArrayList<>();
        for ( WebElement element : productPrice){
            price.add(element.getText());
        }
        Collections.sort(price);
       storeListElement(By.xpath("//ol[@class='products list items product-items']//span[@class='price']"));
       // Select Sort By filter “Price”
        selectFromDropDown(By.xpath("(//select[@id='sorter'])[1]"),"Price");
       // Verify the products price display in Low to High
        List<WebElement> productPrice1 = driver.findElements(By.xpath("//ol[@class='products list items product-items']//span[@class='price']"));
        List<String> price1 = new ArrayList<>();
        for ( WebElement element : productPrice1){
            price1.add(element.getText());
        }
        boolean message = price.equals(price1);
       Assert.assertTrue(message);
   }

    @After
    //closing browser
    public void tearDown(){
        closeBrowser();
    }
}
