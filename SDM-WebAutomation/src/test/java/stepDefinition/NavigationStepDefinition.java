package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

import static org.testng.Assert.assertTrue;

public class NavigationStepDefinition {

    TestContextSetup tcs;

    public NavigationStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("A user is viewing a PLP")
    public void aUserIsViewingAPLP() {
        tcs.pom.getNavigation().viewPLP();
    }

    @When("The page is loaded - Navigation")
    public void thePageIsLoaded() {
        tcs.pom.getNavigation().isElementDisplayed();
    }

    @Then("They see products that belong in the category assortment load in a grid")
    public void theySeeProductsThatBelongInTheCategoryAssortmentLoadInAGrid() {
        assertTrue(tcs.pom.getNavigation().isProductGridDisplayed());
    }

    @Then("They see Showing [number of products visible on page] of [total products in category] products near the top of the page")
    public void they_see_showing_number_of_products_visible_on_page_of_total_products_in_category_products_near_the_top_of_the_page() {
        String expectedPattern = "You’ve viewed \\d+ of \\d+ products";
        String actualText = tcs.pom.getNavigation().getProductCountText();
        Assert.assertTrue(actualText.matches(expectedPattern));
    }


    @Then("at the end of the page they are seeing Pagination option. Triggering Page should lead the user to respective page")
    public void at_the_end_of_the_page_they_are_seeing_pagination_option_triggering_page_should_lead_the_user_to_respective_page() {
        Assert.assertTrue(tcs.pom.getNavigation().isPaginationDisplayed(), "Pagination is not displayed on the page");
        Assert.assertTrue(tcs.pom.getNavigation().goToPage(), "Failed to navigate to page ");
        Assert.assertEquals(2, tcs.pom.getNavigation().getCurrentPageNumber(), "Did not navigate to page ");
    }

    @Given("A User is on a PLP")
    public void aUserIsOnAPLP() {
        tcs.pom.getNavigation().userIsOnPLP();
    }

    @When("The page loads")
    public void thePageLoads() {
        tcs.pom.getNavigation().isElementDisplayed();
    }

    @Then("User should be able to click on the PLP Breadcrumbs and access the previous page")
    public void userShouldBeAbleToClickOnThePLPBreadcrumbsAndAccessThePreviousPage() {
        String expectedUrl = "https://shop.shoppersdrugmart.ca/";
        tcs.pom.getNavigation().goToPreviousPage();
        String actualUrl = tcs.pom.getNavigation().getUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User is not able to access the previous page");
    }

    @Given("I am on a PLP")
    public void i_am_on_a_plp() {
        tcs.pom.getNavigation().iAmOnAPLP();
    }

    @When("I click on the Sort By dropdown")
    public void i_click_on_the_sort_by_dropdown() {
        tcs.pom.getNavigation().iClickOnSortBy();
    }

    @Then("I see Recommended, Price: low to high, Price: high to low, Newest")
    public void i_see_recommended_price_low_to_high_price_high_to_low_newest() {
        tcs.pom.getNavigation().see();
    }

    @Given("I am viewing the Sort By dropdown")
    public void i_am_viewing_the_sort_by_dropdown() {
        tcs.pom.getNavigation().iAmOnAPLP();
        tcs.pom.getNavigation().iClickOnSortBy();
    }

    @When("I select Recommended")
    public void i_select_recommended() {
        assertTrue(tcs.pom.getNavigation().selectRecommendedOption());
    }

    @Then("I see products on PLP sorted in Recommended")
    public void i_see_products_on_plp_sorted_in_recommended() {
        tcs.pom.getNavigation().isRecommendedOptionSelected();
    }

    @When("I select Price: low to high")
    public void i_select_price_low_to_high() {
        tcs.pom.getNavigation().selectLowToHigh();
    }

    @Then("I see products on PLP sorted by price from low to high")
    public void i_see_products_on_plp_sorted_by_price_from_low_to_high() {
        tcs.pom.getNavigation().isLowToHigh();
    }

    @When("I select Price: high to low")
    public void i_select_price_high_to_low() {
        tcs.pom.getNavigation().selectHighToLow();
    }

    @Then("I see products on PLP sorted by price from high to low")
    public void iSeeProductsOnPLPSortedByPriceFromHighToLow() {
        tcs.pom.getNavigation().isHighToLow();
    }

    @When("I select Newest")
    public void i_select_newest() {
        tcs.pom.getNavigation().selectNewest();
    }

    @Then("I see products on PLP sorted by newest")
    public void i_see_products_on_plp_sorted_by_newest() {
        tcs.pom.getNavigation().isNewest();
    }

    @When("I look at my available filters")
    public void i_look_at_my_available_filters() {
    }

    @Then("I see filters based on the product type \\(price, in stock, ratings, brands, promotions, preferences, etc.)")
    public void i_see_filters_based_on_the_product_type_price_in_stock_ratings_brands_promotions_preferences_etc() {
        assertTrue(tcs.pom.getNavigation().areFiltersAvailable());
    }

    @Given("I am on a collections PLP")
    public void i_am_on_a_collections_plp() {
        tcs.pom.getNavigation().iAmOnCollectionPLP();
    }

    @When("The page is loaded for CLP")
    public void thePageIsLoadedForCLP() {
        tcs.pom.getNavigation().iSeeContentCLP();
    }

    @Then("I should see a contentful banner at the top of the PLP")
    public void i_should_see_a_contentful_banner_at_the_top_of_the_plp() {
        tcs.pom.getNavigation().iSeeContentfulBanner();
    }

    @Given("navigating to a page with Error 404")
    public void navigating_to_a_page_with_error_404() {
        tcs.pom.getNavigation().navigateTo404ErrorPage();
    }

    @When("The page is loaded for 404")
    public void thePageIsLoadedFor() {
        tcs.pom.getNavigation().is404PageLoaded();
    }

    @Then("Sorry the page you are looking for cannot be found should be shown")
    public void sorry_the_page_you_are_looking_for_cannot_be_found_should_be_shown() {
        assertTrue(tcs.pom.getNavigation().is404PageLoaded());
    }


    @Given("I am on any page")
    public void i_am_on_any_page() {
        tcs.pom.getNavigation().iAmOnAPLP();
    }

    @When("I click on the Shopers drug Mart logo")
    public void i_click_on_the_shopers_drug_mart_logo() {
        tcs.pom.getNavigation().iSeeShoppersLogo();
    }

    @Then("it navigates to the home page")
    public void it_navigates_to_the_home_page() {
        String expectedURL = "https://www.shoppersdrugmart.ca/en/home";
        String actualURL = tcs.pom.getNavigation().getUrl();
        Assert.assertEquals(actualURL, expectedURL, "User is not on the homepage");
    }

    @Given("I am browsing the site")
    public void i_am_browsing_the_site() {
    }

    @When("I arrive at a CLP page")
    public void i_arrive_at_a_clp_page() {
        String expectedHeading = "Cameras & Accessories";
        tcs.pom.getNavigation().iAmOnAPLP();
        String actualHeading = tcs.pom.getNavigation().verifyImAtCLPPage();
        Assert.assertEquals(actualHeading, expectedHeading, "The page heading is not as expected.");
    }

    @Then("I should see all the ancestor categories as a breadcrumb trail \\(e.g. a CLP for the category ‘baguettes’ has the category breadcrumbs: home>food>bakery>bread at the top of the page)")
    public void iShouldSeeAllTheAncestorCategoriesAsABreadcrumbTrailEGACLPForTheCategoryBaguettesHasTheCategoryBreadcrumbsHomeFoodBakeryBreadAtTheTopOfThePage() {
        tcs.pom.getNavigation().iSeeBreadCrumb();
    }

    @Given("I am viewing the navigation")
    public void i_am_viewing_the_navigation() {
        tcs.pom.getNavigation().iSeeNavigation();
    }

    @When("I choose a category")
    public void i_choose_a_category() {
        tcs.pom.getNavigation().iChooseACategory();
    }

    @Then("I should arrive at a CLP PLP containing relevant products belonging to the chosen category")
    public void i_should_arrive_at_a_clp_plp_containing_relevant_products_belonging_to_the_chosen_category() {
        String expectedHeading = "Body Lotions";
        String actualHeading = tcs.pom.getNavigation().iSeeNavCLP();
        Assert.assertEquals(actualHeading, expectedHeading, "The page heading is not as expected.");
    }

    @Given("I am on any page with a collections carousel e.g. Home page")
    public void i_am_on_any_page_with_a_collections_carousel_eg_home_page() {
        String expectedURL = "https://shop.shoppersdrugmart.ca/";
        String actualURL = tcs.pom.getNavigation().getUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @When("I view the carousel")
    public void i_view_the_carousel() {
        Assert.assertTrue(tcs.pom.getNavigation().isViewCarousel());
    }

    @Then("It should contain products from the collection")
    public void it_should_contain_products_from_the_collection() {
        tcs.pom.getNavigation().iClickOnCarousel();
        String expectedHeading = "Thoughtful Choices™";
        String actualHeading = tcs.pom.getNavigation().iSeeNavCLP();
        Assert.assertEquals(actualHeading, expectedHeading, "The page heading is not as expected.");
    }


    @Given("I have clicked tapped show all on a collection carousel")
    public void i_have_clicked_tapped_show_all_on_a_collection_carousel() {
        tcs.pom.getNavigation().clickedShopAll();
    }

    @When("I arrive on the collection page")
    public void i_arrive_on_the_collection_page() {
        tcs.pom.getNavigation().iVerifyCLPage();
    }

    @Then("I should be able to view all products in the collection")
    public void i_should_be_able_to_view_all_products_in_the_collection() {
        tcs.pom.getNavigation().verifyImAtCLPPage();
    }

    @Given("I have clicked on a collections page")
    public void i_have_clicked_on_a_collection_page() {
        tcs.pom.getNavigation().iClickOnCollection();
    }

    @When("I am viewing the page")
    public void i_am_viewing_the_page() {
        String expectedHeading = "Video Games";
        String actualHeading = tcs.pom.getNavigation().verifyImAtCLPPage();
        Assert.assertEquals(actualHeading, expectedHeading, "The page heading is not as expected.");
    }

    @Then("I should see products that exist within that collection \\(as defined by business users)")
    public void i_should_see_products_that_exist_within_that_collection_as_defined_by_business_users() {
        tcs.pom.getNavigation().isBrandsDisplayed();
    }

    @Then("I should be able to filter and sort the products based on their facets")
    public void i_should_be_able_to_filter_and_sort_the_products_based_on_their_facets() {
        tcs.pom.getNavigation().selectLowToHigh();
    }

    @Given("an item is listed online")
    public void an_item_is_listed_online() {
        tcs.pom.getNavigation().aProductIsListed();
    }

    @When("There is an Offer on a product i.e. Sale, Clearance, Mass PCO, or Gift with purchase \\(GWP) or Purchase with purchase \\(PWP)")
    public void there_is_an_offer_on_a_product_i_e_sale_clearance_mass_pco_or_gift_with_purchase_gwp_or_purchase_with_purchase_pwp() {
        tcs.pom.getNavigation().aOfferIsVisible();
    }

    @Then("I should be able to see it in the Offers section and I should also be able to see the product in it's Category section")
    public void i_should_be_able_to_see_it_in_the_offers_section_and_i_should_also_be_able_to_see_the_product_in_it_s_category_section() {
        Assert.assertTrue(tcs.pom.getNavigation().verifyProductIsListedInFilter());
    }
}
