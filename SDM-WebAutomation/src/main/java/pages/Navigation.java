package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Navigation {
    public WebDriver driver;

    @FindBy(css = ".plp__paginationInfo__3KwkR")
    public WebElement productCountElement;

    @FindBy(css = ".L0[href='/Electronics?nav=/shop/homeandelectronics']")
    public WebElement homeElectronicsElement;

    @FindBy(css = "li[id='FrontShopHomeAndElectronicsElectronicsAudioHeadphonesEarbudsNavNode'] a[role='menuitem']")
    public WebElement audioHeadphones;

    @FindBy(css = "li[id='FrontShopHomeAndElectronicsElectronicsCamerasAndPhoneAccessoriesCamerasAndAccessoriesNavNode'] a[role='menuitem']")
    public WebElement camerasAccessoriesElement;

    @FindBy(css = ".plp__paginationNav__tl-xo")
    public WebElement paginationElement;

    @FindBy(css = "button[aria-label='Page 2']")
    public WebElement pageNumberElement;

    @FindBy(css = ".plp__productResultsBody__3f9qv")
    public WebElement productGrid;

    @FindBy(css = ".plp__pageHeading__zUcEq")
    public WebElement plpLogo;

    @FindBy(css=".content__heading")
    public WebElement plpContent;

    @FindBy(css = ".plp__breadcrumbLink__PGAYA[href='/Shop/Categories/Home-%26-Electronics/Electronics/c/FS-EL-Electronics']")
    public WebElement plpBreadCrum;

    @FindBy(css = ".plp__btnTitle__1YC3P")
    public WebElement sortBy;

    @FindBy(css = "li[data-value='price-asc'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement lowToHigh;

    @FindBy(css = "li[data-value='price-desc'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement highToLow;

    @FindBy(css = "li[data-value='newest'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement newest;

    @FindBy(css = "li[data-value='trending'] button[class='plp__listItemBtn__UhHM4']")
    public WebElement recommended;

    @FindBy(css = "#filters-hybris-id > div:nth-child(1) > div > div.lds__accordion__header-container > button > h2")
    public WebElement inStockFilter;

    @FindBy(css = "#filters-hybris-id > div:nth-child(2) > div > div.lds__accordion__header-container > button > h2")
    public WebElement brandFilter;

    @FindBy(css = "#filters-hybris-id > div:nth-child(3) > div > div.lds__accordion__header-container > button > h2")
    public WebElement priceFilter;

    @FindBy(css = "#filters-hybris-id > div:nth-child(4) > div > div.lds__accordion__header-container > button > h2")
    public WebElement promotionFilter;

    @FindBy(css = "a[href='https://www1.shoppersdrugmart.ca/en/electronics']")
    public WebElement collectionPLP;

    @FindBy(css = "div[class='hero-copy-container'] h2")
    public WebElement contentBanner;

    @FindBy(css = "h3[align='center']")
    public WebElement error404;

    @FindBy(css = "img[alt='Shoppers Drug Mart']")
    public WebElement shoppersLogo;

    @FindBy(css = ".plp__pageHeading__zUcEq")
    public WebElement pageHeading;

    @FindBy(css = ".L0[href='/Personal-care?nav=/shop/personal']")
    public WebElement navPersonalCare;

    @FindBy(css = "li[id='FrontShopPersonalCareBathBodyCareBodyLotionsNavNode'] a[role='menuitem']")
    public WebElement navPersonalCareOption;

    @FindBy(css = "img[alt='Thoughtful Choices at Shoppers Drug Mart™.']")
    public WebElement carousel;

    @FindBy(css = "#main-content > section.plp__carouselContainer__2zqDF > ul > li.plp__slide__37oOO.plp__active__1XTme > div > div.plp__textContainer__zvazL.plp__splitWidth__D3zK8 > div > a")
    public WebElement carouselClick;

    @FindBy(css = "div:nth-child(4) a:nth-child(5)")
    public WebElement shopAll;

    @FindBy(css = "#main-content > section:nth-child(2) > div > div > div:nth-child(4) > a:nth-child(3)")
    public WebElement collection3;

    @FindBy(css = "#main-content > section:nth-child(2) > div > div > div:nth-child(4) > a.plp__departmentLink__3Yuyc")
    public WebElement collection1;

    @FindBy(css = "#main-content > section:nth-child(2) > div > div > div:nth-child(4) > a:nth-child(2)")
    public WebElement collection2;

    @FindBy(css = "a[href='/c/FS-EL-201']")
    public WebElement consoles;

    @FindBy(css = "li[id='FrontShopPersonalCareBathBodyCareBodyWashAndShowerGelsNavNode'] a[role='menuitem']")
    public WebElement navPersonalCareBodyWash;

    @FindBy(css = "body.page-product-list.pageType-CategoryPage.template-pages-category-productListPage.language-en:nth-child(2) main.plp__plpWrapper__PmWJg:nth-child(5) div.plp__mainContentWrapper__S52r0:nth-child(4) div.plp__rightWrapper__2YfKB div.plp__productResultsBody__3f9qv a.plp__productTileWrapper__2Z_7s:nth-child(1) div.plp__productInfo__1eUE9 div:nth-child(6) > p.plp__offerText__1UB2Z")
    public WebElement offer;

    @FindBy(xpath = "//label[contains(text(),'Sale (92)')]")
    public WebElement saleFilter;

    @FindBy(xpath = "//h2[contains(text(),'Promotions')]")
    public WebElement promotions;

    public Navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iWait(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void clickWithExecutor(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void viewPLP() {
        Actions action = new Actions(driver);
        action.moveToElement(homeElectronicsElement).build().perform();
        iWait(audioHeadphones, 40);
        action.moveToElement(homeElectronicsElement).moveToElement(audioHeadphones).click().build().perform();
    }


    public boolean isProductGridDisplayed() {
        iWait(productGrid, 40);
        return productGrid.isDisplayed();
    }


    public String getProductCountText() {
        iWait(productCountElement,40);
        return productCountElement.getText();
    }

    public boolean isPaginationDisplayed() {
        iWait(paginationElement, 40);
        try {
            return paginationElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean goToPage() {
        iWait(pageNumberElement, 40);
        clickWithExecutor(driver, pageNumberElement);
        return true;
    }

    public int getCurrentPageNumber() {
        try {
            iWait(pageNumberElement, 40);
            return Integer.parseInt(pageNumberElement.getText());
        } catch (NoSuchElementException e) {
            return -1;
        }
    }

    public void userIsOnPLP() {
        Actions action = new Actions(driver);
        action.moveToElement(homeElectronicsElement).build().perform();
        iWait(camerasAccessoriesElement, 40);
        action.moveToElement(homeElectronicsElement).moveToElement(camerasAccessoriesElement).click().build().perform();
    }

    public boolean isElementDisplayed() {
        iWait(plpLogo, 40);
        return plpLogo.isDisplayed();
    }

    public void goToPreviousPage() {
        driver.navigate().back();
    }

    public void iAmOnAPLP() {
        Actions action = new Actions(driver);
        action.moveToElement(homeElectronicsElement).build().perform();
        iWait(camerasAccessoriesElement, 40);
        action.moveToElement(homeElectronicsElement).moveToElement(camerasAccessoriesElement).click().build().perform();
    }

    public void iClickOnSortBy() {
        iWait(sortBy, 40);
        sortBy.click();
    }

    public List<Boolean> see() {
        List<Boolean> optionVisibilities = new ArrayList<>();
        optionVisibilities.add(recommended.isDisplayed());
        optionVisibilities.add(lowToHigh.isDisplayed());
        optionVisibilities.add(highToLow.isDisplayed());
        optionVisibilities.add(newest.isDisplayed());
        return optionVisibilities;
    }

    public boolean selectRecommendedOption() {
        Actions actions = new Actions(driver);
        actions.moveToElement(sortBy).click().build().perform();
        iWait(recommended,40);
        recommended.click();
        return true;
    }

    public boolean isRecommendedOptionSelected() {
        return sortBy.isSelected();
    }

    public boolean selectLowToHigh() {
        iWait(sortBy, 40);
        Actions actions = new Actions(driver);
        actions.moveToElement(sortBy).click().build().perform();
        iWait(lowToHigh, 40);
        lowToHigh.click();
        return true;
    }

    public boolean isLowToHigh() {
        iWait(sortBy, 40);
        return sortBy.isSelected();
    }

    public boolean selectHighToLow() {
        Actions actions = new Actions(driver);
        actions.moveToElement(sortBy).click().build().perform();
        iWait(highToLow, 40);
        highToLow.click();
        return true;
    }

    public boolean isHighToLow() {
        iWait(sortBy, 40);
        return sortBy.isSelected();
    }

    public boolean selectNewest() {
        Actions actions = new Actions(driver);
        actions.moveToElement(sortBy).click().build().perform();
        iWait(newest, 40);
        newest.click();
        return true;
    }

    public boolean isNewest() {
        iWait(sortBy, 40);
        return sortBy.isSelected();
    }

    public boolean areFiltersAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElements(inStockFilter, priceFilter, brandFilter, promotionFilter));
        return inStockFilter.isDisplayed() && priceFilter.isDisplayed() && brandFilter.isDisplayed() && promotionFilter.isDisplayed();
    }

    public void iAmOnCollectionPLP() {
        iWait(collectionPLP, 40);
        collectionPLP.click();
    }

    public void iSeeContentfulBanner() {
        iWait(contentBanner, 40);
        contentBanner.isDisplayed();
    }

    public void navigateTo404ErrorPage() {
        driver.get("https://shop.shoppersdrugmart.ca/adsadsadasda");
    }

    public boolean is404PageLoaded() {
        iWait(error404, 40);
        return error404.isDisplayed();
    }

    public void iSeeShoppersLogo() {
        iWait(shoppersLogo, 40);
        shoppersLogo.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String verifyImAtCLPPage() {
        iWait(pageHeading, 40);
        return pageHeading.getText();
    }

    public boolean iSeeBreadCrumb() {
        iWait(plpBreadCrum, 40);
        return plpBreadCrum.isDisplayed();
    }

    public boolean iSeeNavigation() {
        iWait(navPersonalCare, 40);
        return navPersonalCare.isDisplayed();
    }

    public void iChooseACategory() {
        Actions action = new Actions(driver);
        action.moveToElement(navPersonalCare).build().perform();
        iWait(navPersonalCareOption, 40);
        action.moveToElement(navPersonalCare).moveToElement(navPersonalCareOption).click().build().perform();
    }

    public boolean iSeeContentCLP() {
        iWait(plpContent, 40);
        return plpContent.isDisplayed();
    }

    public String iSeeNavCLP() {
        iWait(pageHeading, 40);
        return pageHeading.getText();
    }

    public boolean isViewCarousel() {
        iWait(carousel, 40);
        return carousel.isDisplayed();
    }

    public void iClickOnCarousel() {
        iWait(carouselClick, 40);
        clickWithExecutor(driver, carouselClick);
    }


    public boolean iVerifyCLPage() {
        iWait(pageHeading, 40);
        return pageHeading.isDisplayed();
    }

    public void iClickOnCollection() {
        Actions action = new Actions(driver);
        action.moveToElement(collection1).moveToElement(collection2).moveToElement(collection3).build().perform();
        clickWithExecutor(driver, collection3);
    }

    public boolean isBrandsDisplayed() {
        return consoles.isDisplayed();
    }

    public void clickedShopAll() {
        iWait(shopAll, 40);
        clickWithExecutor(driver, shopAll);
    }

    public void aProductIsListed() {
        Actions action = new Actions(driver);
        action.moveToElement(navPersonalCare).build().perform();
        iWait(navPersonalCareBodyWash, 40);
        action.moveToElement(navPersonalCare).moveToElement(navPersonalCareBodyWash).click().build().perform();
    }


    public boolean aOfferIsVisible() {
        iWait(offer, 40);
        return offer.isDisplayed();
    }

    public boolean verifyProductIsListedInFilter() {
        iWait(promotions, 40);
        Actions action = new Actions(driver);
        action.moveToElement(promotions).moveToElement(saleFilter);
        clickWithExecutor(driver, saleFilter);
        return true;
    }

}

