package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Log;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PlpPage {

    WebDriver driver;
    Random random;
    WebDriverWait wait;

    public PlpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//*[contains(text(),'Lash Sensational Sky High Mascara')]")
    public WebElement productName;
    @FindBy(xpath = "(//p[@class='plp__price__325EX plp__salePrice__2ExZ2 plp__price__325EX'])[1]")
    public WebElement discountProductPrice;
    @FindBy(xpath = "(//span[contains(@class, 'plp__priceStrikeThrough__2MAlQ plp__price__325EX')])[1]")
    public WebElement regularDiscountProductPrice;
    @FindBy(xpath = "(//p[contains(@class, 'plp__offerText__1UB2Z')])[1]")
    public WebElement saleName;
    @FindBy(xpath = "//div[@class='plp__productResultsBody__3f9qv']//p[@class='plp__offerText__1UB2Z'][contains(text(),'bonus points')]")
    public WebElement bonusPoint;
    @FindBy(xpath = "(//div[@data-testid='offerText']//p[contains(text(), 'PC Optimum Offer')])[3]")
    public WebElement pcOptimumOffer;
    @FindBy(xpath = "(//p[@aria-label='10x the points'])[1]")
    public WebElement points;
    @FindBy(css = "button[value='Quick view']")
    public WebElement quickView;
    @FindBy(xpath = "(//div[@class=\"plp__imageWrapper__1iSxD\"])[1]")
    public WebElement productToHover;
    @FindBy(xpath = "//div[contains(@class,'plp__modalBody__3XsdT')]")
    public WebElement quickViewModelElement;
    @FindBy(css = "a.plp__productTileWrapper__2Z_7s")
    public WebElement productForGiftWithPurchase;
    @FindBy(css = "p.plp__offerText__1UB2Z")
    public WebElement giftWithPurchase;
    @FindBy(css = "h3[align='center']")
    public WebElement error404;
    @FindBy(css = "p[align='center']")
    public WebElement pageNotFound;
    @FindBy(xpath = "//*[text()='Recommended']")
    public WebElement gridPage;
    @FindBy(xpath = "//h1[@class='plp__pageHeading__zUcEq']")
    public WebElement beautyGifts;
    @FindBy(xpath = "//div[contains(@class, 'plp__productResultsBody__3f9qv')]")
    public WebElement gridProductPage;
    @FindBy(xpath = "//nav[contains(@class,'plp__breadcrumbs__3rjRQ')]")
    public WebElement breadCrumbPath;
    @FindBy(xpath = "(//div[contains(@class,'plp__select-wrapper__Ga3OZ')])[1]")
    public WebElement variantDropDown;
    @FindBy(xpath = "(//div[contains(@class,'plp__quickViewRightSide__w2u0u')])")
    public WebElement dropDownPage;
    @FindBy(xpath = "//h1[@class='plp__pageHeading__zUcEq']")
    public WebElement page_of_the_PLP;
    @FindBy(css = "label.plp__paginationInfo__3KwkR")
    public WebElement bottom_of_the_PLP;
    @FindBy(xpath = "//button[contains(@data-testid, 'pagination-listitem0')]")
    public WebElement first_page_of_asterisk;
    @FindBy(xpath = "//button[contains(@data-testid, 'pagination-listitem1')]")
    public WebElement second_page_of_asterisk;
    @FindBy(xpath = "//button[contains(@data-testid, 'pagination-listitem2')]")
    public WebElement third_page_of_asterisk;
    @FindBy(xpath = "(//img[@class = 'lds__icon plp__btnRight__Sse0p'])")
    public WebElement arrow_button;
    @FindBy(xpath = "(//div[@role='tablist'])[2]")
    public WebElement brandSearchContent;
    @FindBy(xpath = "//input[contains(@placeholder ,'Search Brands')]")
    public WebElement brandSearchField;
    @FindBy(xpath = "//button[@class='lds__button plp__pillButton__1V-Fn'][1]")
    public WebElement first_Filter_item;
    @FindBy(xpath = "//button[@class='lds__button plp__pillButton__1V-Fn'][2]")
    public WebElement second_Filter_item;
    @FindBy(xpath = "//button[contains(text(), 'Clear All')]")
    public WebElement clearAllFilter;
    @FindBy(xpath = "(//img[@alt='press enter to remove filter'])[1]")
    public WebElement press_enter_to_remove_filter;
    @FindBy(xpath = "//input[@type='checkbox'][@aria-checked='true']")
    public List<WebElement> checkBoxOfSearchBrand;
    @FindBy(xpath = "(//div[contains(@class, 'plp__productInfo__1eUE9')])[1]")
    public WebElement pdpOfProduct;

    By brandLoad = By.cssSelector("a.plp__productTileWrapper__2Z_7s");
    By brandName = By.cssSelector("p.plp__brandName__n-pQ0");
    By productColor = By.className("plp__productSize__25y2S");
    By productPrice = By.className("plp__priceContainerWrapper__3xP6G");
    By userRating = By.className("plp__ratingWrapper__1MYaa");
    By starRating = By.className("plp__ratingContainer__OI4tH");
    By variantProducts = By.xpath("(//p[contains(@class,'plp__option-variant__1elDu')])");


    public WebElement getSearchBrandItemsForFilter(String searchBrandName) {
        By brandText = By.xpath("//li[@data-code='" + searchBrandName + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandText));
        return driver.findElement(brandText);

    }

    public void clickOnAsterisk(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public void scrollDown(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean clickAblePage(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));

        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    public void handlePointText() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15));
            points.isDisplayed();
        } catch (Exception e) {
            driver.navigate().refresh();
            handlePointText();

        }

    }

    public List<WebElement> getVariantDropDownItems() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(variantProducts));
        return driver.findElements(variantProducts);

    }

    public WebElement getSearchBrandItems(String searchBrandName) {
        By brandText = By.xpath("//*[contains(text() ,'" + searchBrandName + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandText));
        return driver.findElement(brandText);

    }

    public void handleDropDown() {
        try {
            variantDropDown.isDisplayed();
        } catch (Exception e) {
            dropDownPage.click();
            handleDropDown();

        }

    }

    public List<WebElement> getProductColor() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productColor));
        return driver.findElements(productColor);

    }

    public List<WebElement> getStarRating() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(starRating));
        return driver.findElements(starRating);

    }

    public List<WebElement> getUserReview() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userRating));
        return driver.findElements(userRating);

    }

    public List<WebElement> getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrice));
        return driver.findElements(productPrice);

    }


    public List<WebElement> getBrandTiles() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandLoad));
        Log.info("Size of the productTiles: " + driver.findElements(brandLoad).size());
        return driver.findElements(brandLoad);

    }

    public List<WebElement> getBrandName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandName));
        Log.info("Size of the productTiles: " + driver.findElements(brandName).size());
        return driver.findElements(brandName);

    }

}