package Tests;

import Pages.CartPage;
import Pages.MainPage;
import Pages.ProductPage;
import Pages.SearchPage;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;
import utils.ElementHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductSearchTests extends BaseTest {
    //Params and Page Definitions
    CartPage cartPage= new CartPage(driver);
    MainPage mainPage= new MainPage(driver);
    ProductPage productPage= new ProductPage(driver);
    SearchPage searchPage=new SearchPage(driver);
    ElementHelper elementHelper = new ElementHelper(driver);
    String baseUrl= ConfigReader.getProperty("baseUrl");
    String productName=ConfigReader.getProperty("productName");
    String urlKeywordForSearch=ConfigReader.getProperty("urlKeywordForSearch");
    String urlKeywordForProductPage=ConfigReader.getProperty("urlKeywordForProductPage");
    String itemCount=ConfigReader.getProperty("itemCount");
    String expectedNotification=ConfigReader.getProperty("expectedNotification");
    String urlKeywordForCart=ConfigReader.getProperty("urlKeywordForCart");

    @Test
    public void productSearchTest() throws InterruptedException{
        assertEquals(driver.getCurrentUrl(),baseUrl,"urls are different");
        assertTrue(elementHelper.checkVisible(mainPage.logo),"Logo invissible");
        assertTrue(elementHelper.checkVisible(mainPage.searchBar),"Search Bar invisible");
        logger.info("Main Page Reachable Searching Product");
        mainPage.searchForProduct(productName);
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains(urlKeywordForSearch),"url doesn't contain the keyword for search page");
        searchPage.clickToFirstProduct(productName);
        logger.info("Clicked to Product");
        Thread.sleep(1000);
        productPage.getProductName();
        assertTrue(driver.getCurrentUrl().contains(urlKeywordForProductPage),"url doesn't contain the keyword for search page");
        productPage.pickTheDesiredNumber(itemCount);
        logger.info("Selected Amount of Product");
        productPage.clickAddToCartButton();
        logger.info("Clicked to Add to cart button");
        assertTrue(elementHelper.checkVisible(productPage.productAddedNotification));
        assertEquals(productPage.getValidationOfNotification(),expectedNotification);
        logger.info("Notification Captured");
        Thread.sleep(2500);
        productPage.navigateToCart();
        logger.info("Controlling Product Name And Amount");
        cartPage.compareName();
        logger.info("Names are the same");
        assertEquals(cartPage.getAmountValue(),itemCount,"Numbers are different");
        logger.info("Amounts are the same");
        Thread.sleep(500);
        assertTrue(driver.getCurrentUrl().contains(urlKeywordForCart),"url doesn't contain keyword for cart");
        logger.info("Test Successful");
    }
}

