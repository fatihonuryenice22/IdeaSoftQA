package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public CartPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper=new ElementHelper(driver);
    }
    //Elements
    By amount= By.xpath("//div[1]/div[1]/input[1]");
    //Methods
    public String getAmountValue(){
        //Gets the Amount
        return driver.findElement(amount).getDomAttribute("value");
    }

    public void compareName() {
        //Compares Products name with the productNameTitle variable
        String storedProductName=System.getProperty("productNameTitle");
        elementHelper.checkVisible(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]//a[normalize-space()='"+storedProductName+"']"));
    }
}
