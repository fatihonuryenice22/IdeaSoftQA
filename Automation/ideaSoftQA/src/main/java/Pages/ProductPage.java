package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper=new ElementHelper(driver);
    }
    //Elements - Public defined elements are also used in the test class
    By plusButton=By.xpath("//a[@aria-label='Increase Quantity']");
    By addToCartButton=By.xpath("//a[@class='add-to-cart-button']");
    By cartSpan=By.xpath("//span[normalize-space()='Sepet']");
    By titleHeader=By.xpath("//div[1]/h1[1]");
    public By productAddedNotification=By.xpath("//div[@class='shopping-information-cart-inside']");
    //Methods
    public void pickTheDesiredNumber(String itemCount) {
        //Selects the desired number of product, itemCount=5 in this case
        int count=Integer.parseInt(itemCount);
        for (int i=1;i<=count-1;i++){
            elementHelper.checkVisible(plusButton);
            elementHelper.Click(plusButton);
        }
    }

    public void clickAddToCartButton() {
        //Clicks to add to cart button
        elementHelper.checkVisible(addToCartButton);
        elementHelper.Click(addToCartButton);
    }

    public String getValidationOfNotification() {
        //Validates the "product added" notification's text
        return elementHelper.findElement(productAddedNotification).getText().trim();

    }

    public void navigateToCart() {
        //Clicks to cart button on the right top
        elementHelper.Click(cartSpan);
    }

    public void getProductName() {
        //Gets product's name and sets it as a variable for uses in the future
        String headText=driver.findElement(titleHeader).getText();
        System.setProperty("productNameTitle",headText);
    }
}
