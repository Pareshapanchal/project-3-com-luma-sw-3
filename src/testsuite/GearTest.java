package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    @Test
    //1. userShouldAddProductSuccessFullyTo  ShoppinCart()
    public void userShouldAddProductSuccessFullyToShoppinCart()throws InterruptedException {
       // Mouse Hover on Gear Menu
       mouseHoverOn(By.xpath("//a[@id ='ui-id-6']"));
       //click on Bags
       clickOnElement(By.xpath("//a[@id='ui-id-25']"));
       // Click on Product Name ‘Overnight Duffle’
       clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
       // Verify the text ‘Overnight Duffle’
       verifyNavigatePageTitle(By.xpath("//span[contains(text(),'Overnight Duffle')]"),"Overnight Duffle");
      // Change Qty 3
       clickOnElement(By.xpath("//input[@id='qty']"));
       clearBox(By.xpath("//input[@id='qty']"));
       sendValue(By.xpath("//input[@id='qty']"),"3");
        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        //* Verify the text'You added Overnight Duffle to your shopping cart.’
        verifyNavigatePageTitle(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Overnight Duffle to your shopping cart.");
        //* Click on ‘shopping cart’ Link into message
        mouseHoverOnAndClick(By.xpath("//a[@class='action showcart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View and Edit Cart']"));
        //* Verify the product name ‘Cronus Yoga Pant’ Verify the Qty is ‘3’
        Thread.sleep(2000);
        String name =driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        verifyNavigatePageTitle(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),"Overnight Duffle");
        String qty =driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value");
        Assert.assertEquals("not Match","3",qty);
        //Verify the product price ‘$135.00’
        String price= driver.findElement(By.xpath("//span[@class='cart-price']")).getText();
         //* Change Qty to ‘5’
        clearBox(By.xpath("//input[@class='input-text qty']"));
        sendValue(By.xpath("//input[@class='input-text qty']"),"5");
        //* Click on ‘Update Shopping Cart’ button
        driver.findElement(By.xpath("//button[@class='action update']")).click();
        //* Verify the product price ‘$225.00’
        String price1 = driver.findElement(By.xpath("//td[@class='col subtotal']")).getText();
        Assert.assertEquals("Not Match",price1,"$135.00");
    }
    @After
    //closing browser
    public void tearDown(){
        closeBrowser();
    }
}
