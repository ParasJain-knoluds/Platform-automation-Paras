package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    HomePage homePage;
    Footer footer;
    Navigation navigation;
    SearchPage searchPage;
    QuickView quickView;
    Bag bag;
    PdpPage pdpPage;
    PlpPage plp;
    CLP clp;
    Carousel carousel;
    Favourites fav;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public QuickView getQuickView() {
        quickView = new QuickView(driver);
        return quickView;
    }


    public Bag bag() {
        bag = new Bag(driver);
        return bag;
    }

    public Footer getFooter() {
        footer = new Footer(driver);
        return footer;
    }

    public PdpPage getPdpPage() {
        pdpPage = new PdpPage(driver);
        return pdpPage;
    }

    public PlpPage getPlp() {
        plp = new PlpPage(driver);
        return plp;
    }


    public Navigation getNavigation() {
        navigation = new Navigation(driver);
        return navigation;
    }

    public SearchPage getSearchPage() {
        searchPage = new SearchPage(driver);
        return searchPage;
    }

    public CLP getClp() {
        clp = new CLP(driver);
        return clp;
    }

    public Carousel getCarousel() {
        carousel = new Carousel(driver);
        return carousel;
    }

    public Favourites getfav() {
        fav = new Favourites(driver);
        return fav;
    }



}
