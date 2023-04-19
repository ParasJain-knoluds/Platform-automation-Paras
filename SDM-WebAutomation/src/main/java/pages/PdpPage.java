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
import java.util.*;

public class PdpPage {
    WebDriver driver;
    WebDriverWait wait;
    Random random;
    public PdpPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        random=new Random();
    }
    @FindBy(css ="img.plp__sdmLogo__2OSbd0") WebElement sdmLogo;
    @FindBy(css = "input[placeholder='Search']") WebElement searchBox;
    @FindBy(css = "button[aria-label='Search']") WebElement searchBtn;
    @FindBy(xpath = "//div[@class='plp__rightColumn__BPNVI']/div/div/p/a") public WebElement brandName;
    @FindBy(css = "h1.plp__pageHeading__zUcEq") public WebElement pageHeading;
    @FindBy(css = "p.plp__productName__1gTx_") public WebElement productTileImgSearch;
    @FindBy(xpath = "//button[@class='plp__secondaryIconButton__2pMpU plp__primaryIconButton__2TlSE']//*[name()='svg']") public WebElement zoomBtn;
    @FindBy(xpath = "//img[@class='plp__imgContainer__2G8UW']") public WebElement zoomedImg;
    @FindBy(xpath = "//button[@aria-label = 'close zoom view']") public WebElement zoomedImgCloseBtn;
    @FindBy(css = "div.pr-snippet-read-and-write > a.pr-snippet-write-review-link") public WebElement writeReviewBtn;
    @FindBy(className = "pr-header-title") public WebElement writeReviewFormHeader;
    @FindBy(id = "pr-rating") public WebElement writeReviewFormRating;
    @FindBy(css = "p.plp__qty__2R64I") public WebElement productQuantity;
    @FindBy(xpath = "//button[@aria-label='remove quantity disabled']") public WebElement decreaseQuantityDisabled;
    @FindBy(css = "button[aria-label='add quantity disabled']") public WebElement increaseQuantityDisabled;
    @FindBy(xpath = "//button[@aria-label='add quantity']") public WebElement increaseQuantity;
    @FindBy(xpath = "//p[@role='alert']") public WebElement maxQuantityMsg;
    @FindBy(css = "div[class='plp__masthead__2aP3M']") public WebElement masterHeader;
    @FindBy(css = "ul.plp__navItemsLayout__1pXOD") public WebElement navHeader;
    @FindBy(css = "div.plp__footerMastheadWrapper__7C4r_") public WebElement footerPDP;
    @FindBy(css = "div.plp__copyRightContainer__sKcKb >p") public WebElement footerPDPText;
    @FindBy(css = "section.plp__sliderWrapper__rn5Mb >h2") public WebElement customerRecommendationHeader;
    By carousalProducts = By.cssSelector("li.plp__sliderListItem__tU9gP");
    @FindBy(css = "button[data-testid='pdp-add-to-bag-btn']") public WebElement addToBagBtn;
    @FindBy(css = "div[class='plp__headingWrapper__2TvjN'] >h3") public WebElement modalHeader;
    @FindBy(css = "span.plp__bodyTextNumber__37kH2") public WebElement pharmaNumber;
    @FindBy(css = "button.plp__callPharmacistButton__1fLog") public WebElement pharmaCallBtn;
    @FindBy(css = "button.plp__addToBag__2JLR7") public WebElement modalAddToBagBtn;
    @FindBy(css = "p[class='plp__dermSectionTitle__kF1Vv']") public WebElement dermaDescription;
    @FindBy(css = "button[data-testid='ask-a-question-derm']") public WebElement askQuestionBtn;
    @FindBy(xpath = "//*[contains(text(),'Call 1-855-437-6243')]") public WebElement callBtn;
    public By colorsList = By.cssSelector("button.plp__btnChip__UaBkS");
    public By colorSelected = By.cssSelector("button.plp__btnChipSelected__1Qfgo");
    @FindBy(css = "p.plp__option-variant__1elDu") public WebElement colorDropdownText;
    @FindBy(xpath = "//div[@class = 'plp__select-variant-wrapper__1PRlQ']") public WebElement colorDropdown;
    By colorDropdownOptions = By.cssSelector("div[name='VariantOptionRow']");
    By colorSelectedCss = By.cssSelector("button.plp__btnChipSelected__1Qfgo");
    @FindBy(css = "p.plp__variantName__tiEnh") public WebElement sizeSingle;
    public By sizeMultiple = By.cssSelector("label.plp__label__OdGJu");
    @FindBy(css = "h2.plp__productOfferTitle__pKtUO") public WebElement offerHeading;
    @FindBy(css = "h3.plp__title__2J7_b") public WebElement giftWithPurchase;
    @FindBy(css = "p.plp__description__gER3Q") public WebElement giftWithPurchaseDescription;
    @FindBy(css = "h3.plp__title__3Zg-5") public WebElement freeSamples;
    @FindBy(css = "p.plp__description__2NB9r") public WebElement freeSamplesDescription;
    @FindBy(xpath = "//a[@class='pr-snippet-review-count']") public WebElement reviewBtn;
    @FindBy(xpath = "//a[@aria-label='Power Review Link']//*[name()='svg']") public WebElement powerReview;
    @FindBy(css = ".pr-histogram-list") WebElement reviewRatingContainer;
    @FindBy(css = ".pr-filter-btn__buttonText") public WebElement removeRatingFilter;
    @FindBy(css = ".pr-filter-btn__icon") public WebElement removeRatingBtn;
    public By removeRatingFilterBy = By.cssSelector(".pr-filter-btn__buttonText");
    @FindBy(css = "p.plp__message__1_fRy") public WebElement outOfStockErrMsg;
    @FindBy(css = "span.plp__soldOutOnlineText__591NG") public WebElement soldOutText;
    @FindBy(css = "h2.plp__productSliderHeading__oppOi") public WebElement recommendSectionHeader;
    By recommendSectionScroll = By.cssSelector("div.plp__swipeSliderContainer__XD2gv");
    @FindBy(xpath = "//div[@class='plp__hide__1oZHX plp__show__o-ksV']//h1[@class='plp__pageHeading__zUcEq plp__productName__2Ci77 plp__productName__1evR8']") public WebElement productNameHeader;
    @FindBy(xpath = "//div[@data-testid='slider-root']//following-sibling::section/div") public WebElement reviewImagesSection;
    @FindBy(css = "div.plp__addedToBagContainer__2Z3Lz") public WebElement addToBagModal;
    @FindBy(xpath = "//button[@data-testid='pdp-continue-shopping']") public WebElement continueShoppingBtn;
    @FindBy(css = "span.plp__shoppingBag__2CNK9") public WebElement bagButton;
    @FindBy(css = "p.plp__messageDescription__21wa0") public WebElement maxQuantityErr;
    By reviewImages = By.cssSelector("button.pr-ggl_image-btn");
    @FindBy(css = ".slide__center > .pr-media-card") public WebElement reviewModal;
    @FindBy(css = "span.pr-cross-icon") public WebElement reviewModalClose;
    @FindBy(css = "h1.pr-rd-review-total") public WebElement reviewTotal;
    By ratingValue = By.xpath("//div[@class='pr-rd-star-rating']//div[contains(@aria-label, 'Rated 5 out of 5 stars')]/div[2]");
    @FindBy(xpath = "//div[@class='plp__imageButtonContainer__3b-rh']//img[contains(@src,'/01/')]") public WebElement productImage;
    @FindBy(css = "button.plp__outOfStock__3Q7Uh") public WebElement outOfStockButton;
    @FindBy(css = "h3.plp__promoWithoutDetails__1W663") public WebElement freeShippingText;
    @FindBy(id = "pr-rd-sort-by") public WebElement sortContainer;

    public void openProduct(Map<String, String> excelRow, String rowId){
        Log.info("Row number " + excelRow);
        String productId = excelRow.get(rowId);
        Log.info("Searching id : " + productId);
        setSearchBox(productId);
        openSearchedProduct();
    }

    public boolean validatePdpPage(){
        wait.until(ExpectedConditions.visibilityOf(sdmLogo));
        return sdmLogo.isDisplayed();
    }

    public void setSearchBox(String searchTerm) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(searchTerm);
        searchBtn.click();
    }

    public void openSearchedProduct(){
        wait.until(ExpectedConditions.visibilityOf(productTileImgSearch));
        productTileImgSearch.click();
    }

    public void increaseQuantity(int quantity){
        for (int i = 1; i <= quantity; i++) {
            wait.until(ExpectedConditions.visibilityOf(increaseQuantity)).click();
        }
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public boolean validateCarousalProducts(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(carousalProducts));
        List<WebElement> carousalList = driver.findElements(carousalProducts);
        for(WebElement product : carousalList){
            Log.info("brandName : " + product.findElement(By.className("plp__brandName__VXQnE")).getText());
            boolean img = product.findElement(By.className("plp__productTileImage__3NT4C")).isDisplayed();
            boolean brandName = product.findElement(By.className("plp__brandName__VXQnE")).isDisplayed();
            boolean price = product.findElement(By.className("plp__priceContainerWrapper__3inn9")).isDisplayed();
            if(!img||!brandName||!price){
                return false;
            }
        }
        return true;
    }

    public int getSizeOfElement(By webElement){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
        return driver.findElements(webElement).size();
    }

    public String getElementAttribute(By webElement){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
        WebElement element = driver.findElement(webElement);
        return element.getAttribute("value");
    }

    public void selectRandomColor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorsList));
        List<WebElement> colorList = driver.findElements(colorsList);
        int colorInt=random.nextInt(driver.findElements(colorsList).size());
        Log.info("colorInt : " + colorInt);
        WebElement colorSelect = colorList.get(colorInt);
        colorSelect.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorsList));
        WebElement colorSelectNew = driver.findElements(colorsList).get(colorInt);
        Log.info("Color name : " + colorSelectNew.getAttribute("value"));
        colorSelectNew.getAttribute("value");
    }

    public WebElement getColorWithName(String name){
        String xpathColor = "//button[@value='" + name + "']";
        Log.info("Color xpath : " + xpathColor );
        return driver.findElement(By.xpath(xpathColor));
    }

    public boolean dropdownSelectColor(){
        wait.until(ExpectedConditions.visibilityOf(colorDropdown));
        colorDropdown.click();
        String id = driver.findElements(colorDropdownOptions).get(random.nextInt(
                driver.findElements(colorDropdownOptions).size())).getAttribute("id");
        Log.info("Color id from dropdown: " + id);
        driver.findElement(By.cssSelector("div[data-testid='variantSelectList'] div[id='"+id+"']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorSelectedCss));
        String idButton = driver.findElement(colorSelectedCss).getAttribute("id");
        Log.info("Color id above dropdown: " + idButton);
        return id.equalsIgnoreCase(idButton);
    }

    public boolean dropdownCheck(){
        String previous = "";
        List<String> colorNameList = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOf(colorDropdown));
        colorDropdown.click();
        List<WebElement> colorList = driver.findElements(colorDropdownOptions);
        for(WebElement colorElement : colorList){
            String colorName = colorElement.findElement(By.cssSelector("p.plp__option-variant__1elDu")).getText();
            colorNameList.add(colorName);
        }
        Log.info("colorNameList : " + colorNameList);
        for (String current: colorNameList) {
            if (current.compareTo(previous) < 0)
                return false;
            previous = current;
        }
        return true;
    }

    public String checkSizeEnabled(){
        String sizeValue = null;
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeMultiple));
        List<WebElement> sizeList = driver.findElements(sizeMultiple);
        for(WebElement sizeElement : sizeList){
            WebElement sizeInput = sizeElement.findElement(By.tagName("input"));
            String sizeEnabled = sizeInput.getAttribute("aria-checked");
            Log.info("aria-checked : " + sizeEnabled);
            if(sizeEnabled.equalsIgnoreCase("false")){
                sizeValue=sizeElement.getText();
                sizeInput.click();
                Log.info("sizeValue : " + sizeValue);
                break;
            }
        }
        return sizeValue;
    }

    public void clickOnRatingFilter(String ratingExpected){
        String rating;
        wait.until(ExpectedConditions.visibilityOf(reviewRatingContainer));
        List<WebElement> reviewRatings = reviewRatingContainer.findElements(By.tagName("li"));
        Log.info("reviewRatings size : " + reviewRatings.size());
        for(WebElement ratingContainer :  reviewRatings){
            String ratingCount = ratingContainer.findElement(By.tagName("div")).findElement(By.className("pr-histogram-count")).getText();
            Log.info("ratingCount : " + Integer.valueOf(ratingCount));
            if(Integer.parseInt(ratingCount)>2){
                rating = ratingContainer.findElement(By.tagName("div")).findElement(By.className("pr-histogram-label")).getText();
                if(rating.equalsIgnoreCase(ratingExpected)){
                    ratingContainer.findElement(By.tagName("div")).findElement(By.className("pr-ratings-histogram-bar-container")).click();
                    break;
                }
            }
        }
    }

    public boolean checkIfElementPresent(By byLocator){
        //Returns true if element is present for the given cssSelector
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> element = driver.findElements(byLocator);
        Log.info("element present size: " + element.size());
        return element.size() != 0;
    }

    public String clickRecommendedProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(recommendSectionScroll));
        List<WebElement> recommendedProducts = driver.findElement(recommendSectionScroll).findElement(By.tagName("ul")).findElements(By.tagName("li"));
        int recommendedProductInt=random.nextInt(recommendedProducts.size());
        WebElement recommendedProduct = recommendedProducts.get(recommendedProductInt);
        String productName = recommendedProduct.findElement(By.tagName("a")).findElement(By.className("plp__productInfo__RQ1zn"))
                .findElement(By.className("plp__productNameFlavourWrapper__2Howy")).findElement(By.tagName("p")).getText();
        Log.info("Recommended productName : " + productName);
        recommendedProduct.click();
        return productName;
    }

    public int getBagCount(){
        wait.until(ExpectedConditions.visibilityOf(bagButton));
        String bagCount = bagButton.findElement(By.tagName("span")).getText();
        int bagCountInt = Integer.parseInt(bagCount);
        Log.info("bagCountInt : " + bagCountInt);
        return bagCountInt;
    }

    public void clickReviewImage(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",reviewImagesSection);
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewImages));
        List<WebElement> reviewImagesList = driver.findElements(reviewImages);
        int reviewImageInt=random.nextInt(reviewImagesList.size());
        WebElement reviewImageClick = reviewImagesList.get(reviewImageInt);
        reviewImageClick.click();
    }

    public boolean validateReviewModalText() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(reviewModal));
        WebElement reviewTextContainer = reviewModal.findElement(By.className("pr-media-card-content")).findElement(By.className("pr-media-card-content-text"));
        Thread.sleep(2000);
        return reviewTextContainer.findElement(By.className("pr-media-card-content-text-headline")).isDisplayed();
    }

    public int getTotalReview(){
        wait.until(ExpectedConditions.visibilityOf(reviewImagesSection));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",reviewImagesSection);
        wait.until(ExpectedConditions.visibilityOf(reviewTotal));
        Log.info("reviewTotal : " + reviewTotal.getText());
        String totalReviewStr = reviewTotal.getText().split("by")[1].trim().split(" ")[0].trim();
        Log.info("totalReviewStr : " + totalReviewStr);
        return Integer.parseInt(totalReviewStr);
    }

    public boolean checkRatingValue(String ratingExpected){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingValue));
        List<WebElement> ratingValueList = driver.findElements(ratingValue);
        Log.info("ratingValueList size : " + ratingValueList.size());
        for(WebElement rating :  ratingValueList){
            Log.info("rating : " + rating.getText());
            if(!rating.getText().equalsIgnoreCase(ratingExpected)){
                return false;
            }
        }
        return true;
    }

    public String getImageLink(){
        wait.until(ExpectedConditions.visibilityOf(productImage));
        String imgUrl = productImage.getAttribute("src");
        Log.info("imgUrl : " + imgUrl);
        return imgUrl;
    }

    public boolean checkColorTick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorDropdownOptions));
        String selectedColor = colorDropdownText.getText();
        Log.info("selectedColor : " + selectedColor);
        List<WebElement> colorList = driver.findElements(colorDropdownOptions);
        for(WebElement colorElement : colorList){
            String colorName = colorElement.findElement(By.cssSelector("p.plp__option-variant__1elDu")).getText();
            Log.info("colorName : " + colorName);
            if(colorName.equalsIgnoreCase(selectedColor)){
                if(!colorElement.findElement(By.cssSelector(".plp__optionVariantStatus__1j4GE > svg")).isDisplayed()){
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public boolean checkColorOOS(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorDropdownOptions));
        String selectedColor = colorDropdownText.getText();
        Log.info("selectedColor : " + selectedColor);
        List<WebElement> colorList = driver.findElements(By.cssSelector("p.plp__option-variant-soldout__1FqB1"));
        for(WebElement colorElement : colorList){
            String colorOOSText = colorElement.getText();
            Log.info("colorOOSText : " + colorOOSText);
            if(!colorOOSText.equalsIgnoreCase("Sold out")){
                return false;
            }
        }
        return true;
    }

    public boolean validateSortFilters(){
        List<String> sortValues = Arrays.asList("Most Helpful","Most Recent","Lowest Rated","Highest Rated","Oldest","Images");
        wait.until(ExpectedConditions.visibilityOf(sortContainer));
        List<WebElement> sortOptionsList = sortContainer.findElement(By.tagName("optgroup")).findElements(By.tagName("option"));
        for(WebElement sortOption : sortOptionsList){
            Log.info("sortOption : " + sortOption.getText());
            if(!sortValues.contains(sortOption.getText())){
                return  false;
            }
        }
        return true;
    }
}
