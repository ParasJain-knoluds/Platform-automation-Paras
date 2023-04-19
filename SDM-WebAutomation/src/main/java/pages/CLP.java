package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CLP {
    public WebDriver driver;

    @FindBy(xpath = "//h3[normalize-space()='Beauty']")
    public WebElement clpBeauty;
    @FindBy(css = "section[aria-label='Offers slide show. 3 offers'] li:nth-child(1)")
    public WebElement clpBeautyBanner;
    @FindBy(css = "#Shopbycategory")
    public WebElement clpCategory;
    @FindBy(css = "#Shopbeautybycategory")
    public WebElement clpShopByCategory;
    @FindBy(xpath = "//h2[normalize-space()='Recommended For You']")
    public WebElement clpRecommendedForYou;
    @FindBy(xpath = "//h2[normalize-space()='New & Trending']")
    public WebElement clpNewAndTrending;
    @FindBy(xpath = "//h2[normalize-space()='Features']")
    public WebElement clpFeatures;
    @FindBy(xpath = "//li[2]//div[1]//div[1]//a[1]//p[1]")
    public WebElement clpFeatureShopBy;
    @FindBy(css = ".plp__pageHeading__zUcEq")
    public WebElement clpFeaturePage;
    @FindBy(xpath = "//div[@id='landing-page']/div[@id='main-content']/section/div/ul[1]")
    public WebElement imageSlider;
    @FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/div/ul/li[1]/div/div/a/p")
    public WebElement shopnowButton;
    By sliderimage = By.cssSelector("div");

    public void iWait(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public CLP(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iViewCLPBeauty() {
        iWait(clpBeauty, 10);
       clpBeauty.isDisplayed();
    }

    public void clickCLPBeauty() {
        clpBeauty.click();
    }

    public void iViewCLPBanner() {
        iWait(clpBeautyBanner, 10);
       clpBeautyBanner.isDisplayed();
    }

    public void iViewCLPCategory() {
        iWait(clpCategory, 10);
       clpCategory.isDisplayed();
    }

    public void iViewCLPShopByCategory() {
        iWait(clpShopByCategory, 10);
       clpShopByCategory.isDisplayed();
    }

    public void iViewCLPRecommendedForYouCategroy() {
        iWait(clpRecommendedForYou, 10);
       clpRecommendedForYou.isDisplayed();
    }

    public void iViewCLPNewAndTrending() {
        iWait(clpNewAndTrending, 10);
       clpNewAndTrending.isDisplayed();
    }

    public void iViewCLPFeature() {
        iWait(clpFeatures, 10);
       clpFeatures.isDisplayed();
    }

    public void verifyShopNowInBrandSlider() {
        List<WebElement> sliderImages = imageSlider.findElements(sliderimage);
        for (WebElement image : sliderImages) {
            Actions actions = new Actions(driver);
            actions.moveToElement(image).perform();
            WebElement shopNowButton = shopnowButton;
            if (!shopNowButton.isDisplayed()) {
                return;
            }
        }
    }

    public void clickClpFeatureShopBy() {
        iWait(clpFeatures, 10);
        Actions actions = new Actions(driver);
        actions.moveToElement(clpFeatures).moveToElement(clpFeatureShopBy).build().perform();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clpFeatureShopBy);
    }

    public boolean iAmOnCLPPage() {
        iWait(clpFeaturePage, 10);
        return clpFeaturePage.isDisplayed();
    }

}
