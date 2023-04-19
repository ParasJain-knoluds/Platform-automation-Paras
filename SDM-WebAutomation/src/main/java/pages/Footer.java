package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Footer {
    WebDriver driver;
    WebDriverWait wait;
    public Footer(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @FindBy(css = "button.lds__privacy-policy__btnClose")
  WebElement footerClose;
    @FindBy(xpath = "//input[@type = 'email']") WebElement email;
    @FindBy(xpath = "//input[@type = 'password']") WebElement password;
    @FindBy(xpath = "//*[@id='passwordNext']//span") WebElement nextPassword;
    @FindBy(xpath = "//*[@id='identifierNext']/div/button/span") WebElement next;

    public void closeFooterPopup(){
        wait.until(ExpectedConditions.visibilityOf(footerClose));
        footerClose.click();
    }

    public void signInGoogle() throws InterruptedException {
        Thread.sleep(2000);
        email.click();
        email.sendKeys("paras.jain@loblaw.ca");
        Thread.sleep(2000);
        next.click();
        Thread.sleep(2000);
        password.click();
        password.sendKeys("ParasLo11@22blaw");
        Thread.sleep(2000);
        nextPassword.click();
        Thread.sleep(10000);
    }


}
