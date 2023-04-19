package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class QuickView {

    WebDriver driver;
    WebDriverWait wait;
    Random random;

    public QuickView(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        random = new Random();
    }

    @FindBy(css = "input[placeholder='Search']")
    WebElement searchbox;
    @FindBy(css = "button[aria-label='Search']")
    WebElement search;

    @FindBy(css = "button[value='Quick view']")
    WebElement button;
    By productTiles = By.xpath("//*[@class='plp__productTileWrapper__2Z_7s']");
    By productTilesXpath = By.xpath("//a[class='plp__productTileWrapper__2Z_7s']");

    @FindBy(css = ".plp__quickViewBrandTxt__LB2LH")
    WebElement brandname;

    @FindBy(css = ".plp__modalBody__3XsdT")
    WebElement quickview;

    @FindBy(css = ".plp__quickViewProductNameTxt__2YUtU")
    public WebElement productname;

    @FindBy(css = ".plp__select-wrapper__Ga3OZ")
    WebElement quantity;

    @FindBy(css = ".plp__ratingContainer__OI4tH")
    WebElement rating;

    @FindBy(css = ".plp__quickViewPriceTxt__3_zRF")
    WebElement offerprice;

    @FindBy(css = ".plp__pcoPointsTxt__3IBzl")
    WebElement pc_optimum_offers;

    @FindBy(css = ".plp__select-single__1NnFv")
    WebElement productsize;

    @FindBy(css = "a[href='#']")
    public WebElement productdetails;

    @FindBy(xpath = "//button[normalize-space()='Favourite']")
    WebElement favouritebutton;

    @FindBy(css = "a[href='#']")
    WebElement productimage;

    @FindBy(xpath = "(//*[@class='plp__pageHeading__zUcEq plp__productName__2Ci77 plp__productName__1evR8'])[2]")
    public WebElement validateproductname;
    @FindBy(css = "button[value='Quick view']")
    public WebElement quickView;


    public void clickOnRandomProduct() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTiles));
        List<WebElement> products = driver.findElements(productTiles);
        int productTilesToChoose = random.nextInt(products.size());
        Actions action = new Actions(driver);
        action.moveToElement(products.get(productTilesToChoose));

    }

    public boolean validateQuickViewButton() throws TimeoutException {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", button);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOf(quickView));
            Log.info("Add button is present");
            Actions action = new Actions(driver);
            action.moveToElement(button).click().perform();
            return true;

        } catch (NoSuchElementException e) {
            Log.info("Add button is not present: " + e.getMessage());
            return false;
        }
    }

    public boolean validateQuickView() {
        wait.until(ExpectedConditions.visibilityOf(quickview));
        return quickview.isDisplayed();
    }

    public boolean validateBrandName() throws TimeoutException {
        wait.until(ExpectedConditions.visibilityOf(brandname));
        return brandname.isDisplayed();
    }

    public boolean validateProductName() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(productname));
        return productname.isDisplayed();
    }

    public boolean validateProductQuantity() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(quantity));
        return quantity.isDisplayed();
    }

    public boolean validateProductRating() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(rating));
        return rating.isDisplayed();
    }

    public boolean validateProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(offerprice));
        return offerprice.isDisplayed();
    }

    public boolean validateProductPCOffers() {
        wait.until(ExpectedConditions.visibilityOf(pc_optimum_offers));
        return pc_optimum_offers.isDisplayed();
    }

    public boolean validateProductSize() {
        wait.until(ExpectedConditions.visibilityOf(productsize));
        return productsize.isDisplayed();
    }

    public boolean validateShowProductDetails() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(productdetails));
        return productdetails.isDisplayed();
    }

    public boolean validatePdp() {
        wait.until(ExpectedConditions.visibilityOf(validateproductname));
        return validateproductname.isDisplayed();
    }

    public boolean validateFavouriteButton() {
        wait.until(ExpectedConditions.visibilityOf(favouritebutton));
        return favouritebutton.isDisplayed();
    }

    public boolean validateProductImage() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(productimage));
        return productimage.isDisplayed();
    }


}
