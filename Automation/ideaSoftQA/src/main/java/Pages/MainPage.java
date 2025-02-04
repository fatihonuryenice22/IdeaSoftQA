package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public MainPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper=new ElementHelper(driver);
    }
    //Elements - Public defined elements are also used in the test class
    public By logo= By.xpath("//div[@class='logo']");
    public By searchBar=By.xpath("//input[@name='q']");
    By searchBarSvg=By.xpath("//form[@data-selector='search-form']//button//*[name()='svg']");
    //Methods
    public void searchForProduct(String productName) {
        //Searches product ("ürün" in this case) and clicks to search button
        elementHelper.checkVisible(searchBar);
        elementHelper.findElement(searchBar).sendKeys(productName);
        elementHelper.Click(searchBarSvg);
    }
}
