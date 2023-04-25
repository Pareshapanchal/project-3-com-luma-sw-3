package testsuite;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
        @Test
         // 1. userShouldAddProductSuccessFullyTo ShoppinCart()
         public void userShouldAddProductSuccessFullyToShoppinCart(){
           //Mouse Hover on Men Menu
            mouseHoverOn(By.xpath("//a[@id='ui-id-5']"));
           // Mouse Hover on Bottoms
            mouseHoverOn(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
           // Click on Pants
            mouseHoverOnAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
          // Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
            mouseHoverOn(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
            mouseHoverOnAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
          //Mouse Hover on product name‘Cronus Yoga Pant’ and click on colourBlack.
            mouseHoverOn(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
            mouseHoverOnAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
          //Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
            mouseHoverOn(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
            mouseHoverOnAndClick(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
          // Verify the text‘You added Cronus Yoga Pant to your shopping cart.’
            verifyNavigatePageTitle(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Cronus Yoga Pant to your shopping cart.");
          // Click on ‘shopping cart’ Link into message
            mouseHoverOnAndClick(By.xpath("//a[@class='action showcart']"));
          // Verify the text ‘Shopping Cart.’
            mouseHoverOnAndClick(By.xpath("//span[normalize-space()='View and Edit Cart']"));
            verifyNavigatePageTitle(By.xpath("//span[@class='base']"),"Shopping Cart");
          // Verify the product name ‘Cronus Yoga Pant’
            verifyNavigatePageTitle(By.xpath("//strong[@class='product-item-name']"),                    "Cronus Yoga Pant");
          //Verify the product size ‘32’
            verifyNavigatePageTitle(By.xpath("//dd[contains(text(),'32')]"),"32");
          // Verify the product colour ‘Black’
            verifyNavigatePageTitle(By.xpath("//dd[contains(text(),'Black')]"),"Black");
    }

    @After
    //closing browser
    public void tearDown(){
        closeBrowser();
    }
}
