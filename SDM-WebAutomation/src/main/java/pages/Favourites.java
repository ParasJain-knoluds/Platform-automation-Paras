package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Favourites {
    WebDriver driver;
    WebDriverWait wait;
    Random random;

    @FindBy(css = ".L0[href='/Electronics?nav=/shop/homeandelectronics']")
    public WebElement homeElectronicsElement;
    @FindBy(xpath = "//a[normalize-space()='Headphones & Earbuds']")
    public WebElement headphonesAndEarbuds;
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement goToSignIn;
    @FindBy(css = "input#email")
    WebElement pcEmail;
    @FindBy(css = "input#password")
    WebElement pcPassword;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    WebElement signInButton;

    public Favourites(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void iWait(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void viewPLPPage() {
        Actions action = new Actions(driver);
        action.moveToElement(homeElectronicsElement).build().perform();
        iWait(headphonesAndEarbuds, 10);
        action.moveToElement(homeElectronicsElement).moveToElement(headphonesAndEarbuds).click().build().perform();
    }

    public List<WebElement> findColour() {
        return driver.findElements(By.xpath("//p[normalize-space()='60 colours']"));
    }
    public void signIn(){
        wait.until(ExpectedConditions.visibilityOf(goToSignIn)).click();

        wait.until(ExpectedConditions.visibilityOf(pcEmail));
        pcEmail.sendKeys("testingjoefresh@yopmail.com");
        pcPassword.sendKeys("Testingsdm@123");
        signInButton.click();
    }
    public void VerifyFavouritesPage(){
     signIn();

    }
}
