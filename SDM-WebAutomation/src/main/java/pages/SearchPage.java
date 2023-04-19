package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SearchPage {

    WebDriver driver;
    Random random;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(className = "plp__productResultsBody__3f9qv")
    public WebElement brandPlpPage;
    @FindBy(xpath = "//*[@name='text']")
    public WebElement searchTextField;
    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement clickSearchButton;
    @FindBy(xpath = "//*[@class='plp__pageHeading__zUcEq plp__resultsHeading__SXLWG']")
    public WebElement productSearch;
    @FindBy(className = "plp__pdpTopContainer__1JoNz")
    public WebElement ModelElementPage;
    @FindBy(xpath = "//*[@class='plp__pageHeading__zUcEq plp__resultsHeading__SXLWG']")
    public WebElement NotFoundProduct;

    public WebElement productToHover;
    By brandName = By.xpath("//*[@class='plp__brandName__n-pQ0']");
    By variantProducts = By.cssSelector(".plp__btnChip__UaBkS.plp__outOfStock__3Q7Uh, .plp__btnChip__UaBkS");

    public List<WebElement> getBrandName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandName));
        return driver.findElements(brandName);

    }

    public List<WebElement> getColorName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(variantProducts));
        return driver.findElements(variantProducts);

    }

}
