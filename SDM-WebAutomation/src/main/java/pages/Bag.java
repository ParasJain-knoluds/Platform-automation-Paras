package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static util.Log.log;


public class Bag {

    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentWait;
    Actions action;
    Random random;
    String productName;
    @FindBy(css = "input[placeholder='Search']") WebElement searchBox;
    @FindBy(css = "button[aria-label='Search']") WebElement searchBtn;
    @FindBy(css = "div.plp__imageWrapper__1iSxD") WebElement plpTile;
    @FindBy(xpath = "//div[@class =\"product-info brand\"]//p[@class=\"product-name\"]/a") WebElement chanelplptitle;
    @FindBy(xpath = "//p[text()='Add to bag']") WebElement addToBagFromQuickView;
    @FindBy(css = "button[data-testid=\"quickview-continue-shopping\"]") WebElement quickViewContinueShopping;

    @FindBy(css = "a[data-testid=\"signin\"]") WebElement logIn;

    @FindBy(css = "div[class=\"layout login-page\"]") WebElement loginLayout;

    @FindBy(css = "input[aria-label=\"Email\"]") WebElement usernameField;

    @FindBy(css = "input[aria-label=\"Password\"]") WebElement passwordInputField;
    @FindBy(xpath = "//div[@class =\"button-wrapper\"]/input") WebElement chanelAddtobag;
    @FindBy(css="button[data-testid=\"quickview-continue-shopping\"]") WebElement continueShopping;
    @FindBy(xpath = "//button[@data-testid='quickview-view-bag']") WebElement viewBagButtonFromQuickView;
    @FindBy(css = "img[class=\"plp__productTileImage__2vSgT\"]") WebElement productImage;
    @FindBy(xpath = "//div[@class= \"plp__navHeaderLayout__3zdYO\"]//li[1]") WebElement shop;
    @FindBy(xpath = "//div[@class= \"plp__lvl1UserAccountNav__1_zh0\"]//li[3]//span") WebElement bag;
    @FindBy(css = "h2[class=\"plp__emptyCartText__3EvGJ\"]") WebElement noProduct;
    @FindBy(css="h2[class=\"empty-new-cart\"]") WebElement noSamples;
    @FindBy(css = "button[aria-label=\"Remove\"]") WebElement remove;
    @FindBy(xpath = "//div[@class= \"free-sample-bar\"]//span[2]") WebElement freeSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[1]//button") WebElement firstSample;
    @FindBy(xpath = "//div[@class= \"free-sample-bar\"]//span[2]") WebElement freesamplebar;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[2]//button") WebElement secondSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[3]//button") WebElement thirdSample;
    @FindBy(xpath = "//ul[@class= \"sample-list\"]/li[4]//button") WebElement fourthSample;
    @FindBy(xpath = "//*[@id=\"bag-items\"]/li[2]/div/div/div[2]/div[2]/div/p") WebElement freesampleOnCart;
    @FindBy(xpath = "//div[@class= \"order-summary-title summary-row\"]/h4/span") WebElement orderSummary;
    @FindBy(css = "div[class=\"plp__messageAndPriceContainer__1mCq6\"]") WebElement totalBeforeTax;
    @FindBy(xpath = "//*[@id=\"checkout-mobile-cta\"]") WebElement checkout;
    @FindBy(xpath = "//input[@type = \"email\"]") WebElement email;
    @FindBy(xpath = "//button/span") WebElement next;
    @FindBy(xpath = "//input[@type = \"password\"]") WebElement password;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]//span") WebElement nextPassword;
   @FindBy(css = "input.checkout-input-field") WebElement guestEmailField;
    @FindBy(xpath = "//button[@class='CTA-button small-text']") WebElement checkoutAsGuestButton;
    @FindBy(xpath = "//div[@class= \"shipping summary-row\"]//span") WebElement shipping;
    @FindBy(xpath = "//div[@class= \"shipping summary-row\"]//p[@class=\"bold\"]/span") WebElement shippingprice;
    @FindBy(xpath = "//div[@class='incrementing-button-wrapper']/button[@class= \"CTA-button square\"]") WebElement incremenetButton;
    @FindBy(xpath = "//button[@class= \"CTA-button square is-disabled\"]") WebElement buttonDisabled;
    @FindBy(xpath = "//div[@class= \"brand-category-list top\"]//li[2]/a") WebElement luxaryproduct;
    @FindBy(xpath = "//button[@class =\"btn-checkout default-btn\"]") WebElement checkoutChanel;
    @FindBy(xpath = "//div[@class =\"plp__qtyStepperContainer__QF8E1\"]/button[2]") WebElement addmorefromPdp;
    @FindBy(css="button[aria-label=\"add quantity\"]") WebElement addmore;
    @FindBy(xpath = "//*[text()='Free Gift']") WebElement freegifts;
    @FindBy(css = "div[class=\"plp__descriptionText__3KCwu\"]") WebElement errormessage;
    @FindBy(css="button[type=\"submit\"]") WebElement button;
    @FindBy(css="button[data-testid=\"button-to-checkout\"]") WebElement checkoutWithoutSignIn;
    @FindBy(css="a[id=\"favourite-sign-in\"]") WebElement noSignIN;
    @FindBy(css="button[aria-label=\"Sign In\"]") WebElement signIn;
    @FindBy(css="p[class=\"plp__brandName__3gkaW\"]") WebElement productOnBag;

    @FindBy(css="button[class=\"CTA-button link\"]") WebElement removeSampleProduct;
    @FindBy(css="#SelectVariant") WebElement quantitySelect;
    @FindBy(xpath="//p[normalize-space()='6']") WebElement select6;
    @FindBy(css="div[data-testid=\"quickview\"]") WebElement quickLayout;
    @FindBy(css="p[class=\"plp__option-variant__1elDu\"]") WebElement quantity;
    @FindBy(css = "span[id=\"js-cart-item-count-nav-sub\"]") WebElement bagCount;
    @FindBy(css = "p[class=\"plp__qty__2R64I\"]") WebElement displayProductQuantity;
    @FindBy(css = "a[data-testid=\"shoppingbag\"]") WebElement clickBagButton;

    @FindBy(css=".plp__accordionIcon__1gB_5")
    WebElement arrowPC;

    @FindBy(css="input[name='promoCode']")
    WebElement promoCode;

    @FindBy(css="button[data-testid='apply-promo-button']")
    WebElement applyPcButton;

    @FindBy(css=".plp__title__1J0ws")
    WebElement MessagePC;

    @FindBy(css=".plp__messageDescription__21wa0")
    WebElement oosProductMessage;

    @FindBy(css="button[data-testid='quickview-add-to-bag']")
    WebElement addToBagButton;

    @FindBy(css="button[class='lds__button fmt__primary-button plp__primaryButton__1J9ph plp__primaryButton--disabled__3xlI5']")
    WebElement addToBagDisabled;

    @FindBy(css="a[data-testid='signin']")
    WebElement signIN;

    @FindBy(css="input[aria-label='Email']")
    WebElement emailField;

    @FindBy(css="input[aria-label='Password']")

    WebElement passwordField;

    @FindBy(css="button[type='submit']")
    WebElement signInButton;

    @FindBy(css=".plp__descriptionText__1xcCO")
    WebElement pointsAvailableWithOrder;

    @FindBy(css="p[data-testid='line-item-price']")
    WebElement pointsEarned;

    @FindBy(css="p[class='plp__registerPcOptimumText__1HOyU']")
    WebElement messageWithoutPCAccount;


    /*public void siignInGoogle() throws InterruptedException {
        Thread.sleep(5000);
        email.click();
        email.sendKeys("");
        Thread.sleep(4000);
        next.click();
        password.click();
        password.sendKeys("");
        nextPassword.click();
    }*/
    public boolean plusdisabled(){
        boolean disabledbutton = buttonDisabled.isEnabled();
        if(disabledbutton){
            return false;
        }
        return true;
    }
    public boolean freeGifts(){
        wait.until(ExpectedConditions.visibilityOf(freegifts));
        return freegifts.getText().contains("Free Gift");
    }
    public void addToBagPageChanel() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Chanel");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(luxaryproduct));
        luxaryproduct.click();
        wait.until(ExpectedConditions.visibilityOf(chanelplptitle));
        chanelplptitle.click();
        wait.until(ExpectedConditions.visibilityOf(chanelAddtobag));
        chanelAddtobag.click();
        wait.until(ExpectedConditions.visibilityOf(checkoutChanel));
        checkoutChanel.click();
    }
    public void incremenetProduct() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOf(addmore));
        wait.until(ExpectedConditions.elementToBeClickable(addmore));
        addmore.click();
        //Thread.sleep(10000);
//        Actions action = new Actions(driver);
//        wait.until(ExpectedConditions.visibilityOf(increment));
//        wait.until(ExpectedConditions.visibilityOf(addmore));
//        action.moveToElement(bagProduct).moveToElement(increment).moveToElement(addmore).click().build().perform();
    }
       public Bag(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public boolean orderSummary() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(orderSummary));
           return orderSummary.getText().contains("Order Summary");
    }

    public void checkout() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(checkout));
        checkout.click();
    }
    public void goToCheckoutShippingAddress() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(guestEmailField));
        guestEmailField.sendKeys("sdmweb@yopmail.com");
        checkoutAsGuestButton.click();
    }
public boolean booleantotalBeforeTax() throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(totalBeforeTax));
           return totalBeforeTax.getText().contains("Subtotal");
}
    public boolean productOnCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(productImage));
        return productImage.isDisplayed();
    }
public boolean freeSample() throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(freeSample));
           return freeSample.getText().contains("Free Samples");
}
public boolean freesampleOnCart() throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(freesampleOnCart));
       return freesampleOnCart.getText().contains("Free Gift");
}

    public boolean noProduct() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(noProduct));
       return noProduct.getText().contains("Psst, your shopping bag is empty!") ;
       }
       public void removeProduct() throws InterruptedException{
           wait.until(ExpectedConditions.elementToBeClickable(remove));
           remove.click();
    }
    public boolean removeSample() {
        wait.until(ExpectedConditions.visibilityOf(noSamples));
        return noSamples.isDisplayed();
    }
    public void removeSampleProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(removeSampleProduct));
        removeSampleProduct.click();
    }
    public void setSearchBoxMultiple(String searchTerm) {
        searchBox.sendKeys(searchTerm);
        productName = searchTerm;
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
    }
    public void addChanelProduct() throws InterruptedException {
        setSearchBoxMultiple("Chanel");
        goToBagPage();
    }
    public boolean shippingPrice() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(shipping));
        return shipping.getText().contains("Shipping") && shippingprice.getText().contains("$8");
    }
    public boolean shippingPriceFree() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(shipping));
        return shipping.getText().contains("Shipping") && shippingprice.getText().contains("FREE");
    }
    public void goToBagPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.visibilityOf(viewBagButtonFromQuickView));
        wait.until(ExpectedConditions.elementToBeClickable(viewBagButtonFromQuickView));
        viewBagButtonFromQuickView.click();
    }

    public void maxQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"plp__select-button-label__114iU\"]")));
        WebElement quantity = driver.findElement(By.cssSelector("button[class=\"plp__select-button-label__114iU\"]"));
        quantity.click();
        List<WebElement> allOptions = driver.findElements(By.cssSelector("div[name='VariantOptionRow']"));
        String option = "6";
        for(WebElement all:allOptions) {
            if(all.getText().contains(option)) {
                all.click();
            }
        }
    }

    public void addProductFromPDP() throws InterruptedException {
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.visibilityOf(continueShopping));
        continueShopping.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();

    }
    public boolean errorMessageOnAdd(){
        return errormessage.getText().contains("You can add up to 6 of this item to your bag, you've reached the limit");
    }
    public void shopClick() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(shop));
            shop.click();
    }
    public void bagClick() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(bag));
        bag.click();
    }
    public void addFreeSamples() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstSample));
               firstSample.click();
        wait.until(ExpectedConditions.visibilityOf(secondSample));
               secondSample.click();
        wait.until(ExpectedConditions.visibilityOf(thirdSample));
               thirdSample.click();

    }
    public boolean freesampleVisible(){
            wait.until(ExpectedConditions.visibilityOf(freesamplebar));
            return freesamplebar.getText().contains("Free Samples");
    }
    public boolean sampleDisabled(){
         boolean disabledbutton = fourthSample.isEnabled();
         if(disabledbutton){
             return false;
         }
         return true;
    }

    public void enterPromoCode()
    {
        wait.until(ExpectedConditions.visibilityOf(arrowPC));
        arrowPC.click();
        wait.until(ExpectedConditions.visibilityOf(promoCode));
        promoCode.sendKeys("SV5-89OF-0616-LNN4");
        wait.until(ExpectedConditions.visibilityOf(applyPcButton));
        applyPcButton.click();
    }

    public boolean displayMessage()
    {
        wait.until(ExpectedConditions.visibilityOf(MessagePC));
        System.out.println(MessagePC.getText());
        return MessagePC.getText().contains("Resource not found");
    }

    public boolean addOOSProductToBag() throws InterruptedException {
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        boolean flag=false;
        try{
            wait.until(ExpectedConditions.visibilityOf(addToBagDisabled));
            addToBagDisabled.click();
        }
        catch (ElementClickInterceptedException e)
        {
            log.info("Item cannot be added to cart as it is out of stock");
            flag=true;
        }
        return flag;
    }

    public boolean validateOOSProduct()
    {

        wait.until(ExpectedConditions.visibilityOf(oosProductMessage));
        String message=oosProductMessage.getText();
        log.info(message);
        return message.equalsIgnoreCase("We're sorry, this item is temporarily out of stock. Please check back at a later time.");
    }

    public void gotoSignin() {
        wait.until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
    }
    public void enterPCOAccount(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys("testwallet20@yopmail.com");
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("passwordisnew");
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void enterNonPCOAccount()
    {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys("testwallet777@yopmail.com");
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("passwordisnew");
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public boolean noSignIn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(noSignIN));
        return noSignIN.isDisplayed();
    }

    public void signInOnBag() {
        wait.until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
        email.click();
        email.sendKeys("testwallet20@yopmail.com");
        password.click();
        password.sendKeys("passwordisnew");
        button.click();
    }

    public void signInOnEmptyBag() {
        wait.until(ExpectedConditions.visibilityOf(noSignIN));
        noSignIN.click();
        email.click();
        email.sendKeys("testwallet20@yopmail.com");
        password.click();
        password.sendKeys("passwordisnew");
        button.click();
    }

    public boolean productONBag() {
        return productOnBag.isDisplayed();
    }

    public boolean checkoutWithoutSIgnIN() {
        return checkoutWithoutSignIn.isDisplayed();
    }

    public boolean validatePointsEarned()
    {
        wait.until(ExpectedConditions.visibilityOf(pointsAvailableWithOrder));
        log.info(pointsAvailableWithOrder.getText());
        wait.until(ExpectedConditions.visibilityOf(pointsEarned));
        log.info("Points Earned :" +pointsEarned);
        return pointsAvailableWithOrder.isDisplayed();
    }

    public boolean validateMessageWithoutPCAccount()
    {
        wait.until(ExpectedConditions.visibilityOf(messageWithoutPCAccount));
        log.info(messageWithoutPCAccount.getText());
        return messageWithoutPCAccount.isDisplayed();
    }

    public boolean checkBagQuantity() {
        String site = driver.getCurrentUrl();
        driver.get(driver.getCurrentUrl());
        ((JavascriptExecutor) driver).executeScript("window.open('" + site + "', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Dior");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.visibilityOf(quickViewContinueShopping));
        wait.until(ExpectedConditions.elementToBeClickable(quickViewContinueShopping));
        quickViewContinueShopping.click();

        driver.switchTo().window(tabs.get(1));

        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("mascara");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        wait.until(ExpectedConditions.elementToBeClickable(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.elementToBeClickable(quickViewContinueShopping));
        quickViewContinueShopping.click();
        return true;
    }

    public boolean switchTabA() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.navigate().refresh();
        return true;
    }

    public boolean validateBagProducts() {
        wait.until(ExpectedConditions.visibilityOf(bagCount));
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(bagCount));
        return true;
    }

    public boolean addToCart() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Dior");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.elementToBeClickable(quickViewContinueShopping));
        quickViewContinueShopping.click();
        return true;
    }

    public boolean login() {
        wait.until(ExpectedConditions.visibilityOf(logIn));
        logIn.click();
        wait.until(ExpectedConditions.visibilityOf(loginLayout));
        usernameField.sendKeys("testwallet20@yopmail.com");
        passwordInputField.sendKeys("passwordisnew");
        signInButton.click();
        return true;
    }

    public boolean validateBagItems() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Dior");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.visibilityOf(viewBagButtonFromQuickView));
        wait.until(ExpectedConditions.elementToBeClickable(viewBagButtonFromQuickView));
        viewBagButtonFromQuickView.click();
        return true;
    }

    public boolean registeredAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Dior");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.visibilityOf(addToBagFromQuickView));
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.visibilityOf(quickViewContinueShopping));
        wait.until(ExpectedConditions.elementToBeClickable(quickViewContinueShopping));
        quickViewContinueShopping.click();

        String site = driver.getCurrentUrl();
        driver.get(driver.getCurrentUrl());
        ((JavascriptExecutor) driver).executeScript("window.open('" + site + "', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        wait.until(ExpectedConditions.visibilityOf(logIn));
        logIn.click();
        wait.until(ExpectedConditions.visibilityOf(loginLayout));
        usernameField.sendKeys("testwallet20@yopmail.com");
        passwordField.sendKeys("passwordisnew");
        signInButton.click();

        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("Dior");
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(plpTile));
        plpTile.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToBagFromQuickView));
        addToBagFromQuickView.click();
        wait.until(ExpectedConditions.visibilityOf(viewBagButtonFromQuickView));
        wait.until(ExpectedConditions.elementToBeClickable(viewBagButtonFromQuickView));
        viewBagButtonFromQuickView.click();
        return true;
    }

    public boolean anonymousToRegisteredUser() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        logIn.click();
        wait.until(ExpectedConditions.visibilityOf(loginLayout));
        usernameField.sendKeys("testwallet20@yopmail.com");
        passwordField.sendKeys("passwordisnew");
        signInButton.click();
        return true;
    }

    public boolean verifyProductQuantityInBag() {
        wait.until(ExpectedConditions.visibilityOf(clickBagButton));
        clickBagButton.click();
        wait.until(ExpectedConditions.visibilityOf(displayProductQuantity));
        displayProductQuantity.isDisplayed();
        return true;
    }

}
