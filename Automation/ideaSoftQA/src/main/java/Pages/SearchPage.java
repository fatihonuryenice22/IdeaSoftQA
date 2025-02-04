package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Methods
    public void clickToFirstProduct(String productName) throws InterruptedException {
        //Clicks on the product containing the keyword
        WebElement element =driver.findElement(By.xpath("//section[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/a[contains(normalize-space(), "+productName+")][1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        element.click();
    }
}
