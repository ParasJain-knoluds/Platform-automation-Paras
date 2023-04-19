package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class Carousel {

    public WebDriver driver;

    @FindBy(css = ".L0[href='/Electronics?nav=/shop/homeandelectronics']")
    public WebElement homeElectronicsElement;
    @FindBy(xpath = "//a[normalize-space()='Headphones & Earbuds']")
    public WebElement headphonesAndEarbuds;
    @FindBy(css = "button[value='Quick view']")
    public WebElement noProductOverlay;
    @FindBy(css = "#FrontShopShopNavNode")
    public WebElement shopLandingPage;
    @FindBy(css = "img[data-testid=\"heart-609332821194\"]")
    public WebElement favourite;
    @FindBy(xpath = "//a[normalize-space()='Makeup']")
    public WebElement categoryMakeup;
    @FindBy(css=".L0[href='/Beauty?nav=/shop/beauty']")
    public WebElement productBeauty;
    @FindBy(css="li[id='FrontShopBeautyMakeupLipstickNavNode'] a[role='menuitem']")
    public WebElement productLipstick;
    @FindBy(css=".L0[href='/Personal-care?nav=/shop/personal']")
    public WebElement personalCare;
    @FindBy(css="li[id='FrontShopPersonalCareBathBodyCareBodyCareNavNode'] a[role='menuitem']")
    public WebElement bodyCare;
    @FindBy(css="li[id='FrontShopPersonalCareBathBodyCareDeodorantNavNode'] a[role='menuitem']")
    public WebElement deodrant;

    By productTiles = By.cssSelector(".plp__productTileWrapper__2Z_7s");
    By badge = By.cssSelector("div[class='plp__ribbonWrapper__GHKpz']");
    By product = By.cssSelector("p[class=\"plp__brandName__n-pQ0\"]");
    By productname = By.cssSelector("p[class=\"plp__brandName__n-pQ0\"]");
    By productprice = By.cssSelector("p[class=\"plp__price__325EX\"]");
    By pricerange = By.cssSelector("p[data-testid=\"price-container\"]");
    By pricediscount = By.cssSelector("p[data-testid=\"price-container\"]");
    By offer = By.cssSelector("div[data-testid='offerText']");
    By pcpoint = By.cssSelector("p[class=\"plp__offerText__1UB2Z\"]");

    public Carousel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iWait(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitAndGetElements(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }

    public void byWait(By element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void viewPLPPage() {
        Actions action = new Actions(driver);
        action.moveToElement(homeElectronicsElement).build().perform();
        iWait(headphonesAndEarbuds, 10);
        action.moveToElement(homeElectronicsElement).moveToElement(headphonesAndEarbuds).click().build().perform();
    }

    public void viewProductTile() {
        Actions actions = new Actions(driver);
        byWait(productTiles, 10);
        WebElement productTile = driver.findElement(productTiles);
        actions.moveToElement(productTile).build().perform();
    }

    public boolean ProductOverlay() {
        try {
            noProductOverlay.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

   public List<WebElement> findfavourite() {
        return driver.findElements(By.xpath("//img[@data-testid='heart-041554080421']"));
    }

    public List<WebElement> findColour() {
        return driver.findElements(By.xpath("//p[normalize-space()='60 colours']"));
    }

    public List<WebElement> findSize() {
        return driver.findElements(By.xpath("//p[normalize-space()='24 sizes']"));
    }

    public void viewShopLanding() {
        shopLandingPage.click();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public boolean seeFavourite() {
        iWait(favourite, 10);
        return favourite.isDisplayed();
    }

    public void clickCategory() {
        iWait(categoryMakeup, 10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoryMakeup);
    }

    public boolean viewBadge() {
        List<WebElement> badges = waitAndGetElements(badge, 10);
        return badges.size() >= 1;
    }

    public boolean viewProductBrand() {
        List<WebElement> productBrand = waitAndGetElements(product, 10);
        return productBrand.size() >= 1;
    }


    public boolean viewProductName() {
        List<WebElement> productName = waitAndGetElements(productname, 10);
        return productName.size() >= 1;
    }

    public boolean viewProductPrice() {
        List<WebElement> productPrice = waitAndGetElements(productprice, 10);
        return productPrice.size() >= 1;

    }

    public void viewPLPPageWithSize() {
        Actions action = new Actions(driver);
        action.moveToElement(productBeauty).build().perform();
        iWait(productLipstick, 10);
        action.moveToElement(productBeauty).moveToElement(productLipstick).click().build().perform();
    }

    public boolean viewPriceRange() {
        List<WebElement> priceRange = waitAndGetElements(pricerange, 10);
        return priceRange.size() >= 1;
    }


    public boolean viewPriceDiscount() {
        List<WebElement> priceDiscount = waitAndGetElements(pricediscount, 10);
        if
        (priceDiscount.size() >= 1)
            return true;
        else
            return false;
    }


    public void viewPCPage() {
        Actions action = new Actions(driver);
        action.moveToElement(personalCare).build().perform();
        iWait(bodyCare, 10);
        action.moveToElement(personalCare).moveToElement(bodyCare).click().build().perform();
    }

    public boolean viewOffers() {
        List<WebElement> offers = waitAndGetElements(offer, 10);
        return offers.size() >= 1;
    }

    public boolean view3000PC() {
        List<WebElement> pcPoint = waitAndGetElements(pcpoint, 10);
        for (WebElement pcPoints : pcPoint) {
            if(pcPoints.getText().equalsIgnoreCase("3000 bonus points"))
                return true;
            break;
        }
        return false;
    }

    public void viewGiftPage() {
        Actions action = new Actions(driver);
        action.moveToElement(personalCare).build().perform();
        iWait(deodrant, 10);
        action.moveToElement(personalCare).moveToElement(deodrant).click().build().perform();
    }

    public boolean clickGiftWithPurchase() {
        List<WebElement> pcPoint = waitAndGetElements(pcpoint, 10);
        for (WebElement pcPoints : pcPoint) {
            if(pcPoints.getText().equalsIgnoreCase("Gift With Purchase"))
                return true;
            break;
        }
        return false;
    }

}
