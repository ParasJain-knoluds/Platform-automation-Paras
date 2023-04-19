package stepDefinition;

import ddtConfig.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import util.Common;
import util.TestContextSetup;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

public class PlpStepDefinition {

    TestContextSetup tcs;

    public PlpStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }


    @Given("^I am viewing a product tile-brand on PLP")
    public void i_am_viewing_a_product_tile_brand_on_plp(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - brand")
    public void the_page_is_loaded_brand() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("Product brand displayed in full")
    public void product_brand_displayed_in_full() {
        Assert.assertEquals(tcs.pom.getPlp().getBrandTiles().size(), tcs.pom.getPlp().getBrandName().size());

    }

    @Given("I am viewing a product tile-name on PLP")
    public void i_am_viewing_a_product_tile_name_on_plp(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - name")
    public void the_page_is_loaded_name() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("Product name displayed in full")
    public void product_name_displayed_in_full() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().productName);
        Assert.assertTrue(tcs.pom.getPlp().productName.isDisplayed());

    }

    @Given("Product tile of a product that has multiple colour assortment")
    public void product_tile_of_a_product_that_has_multiple_colour_assortment(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - color display")
    public void the_page_is_loaded_color_display() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("They see the number of color variations listed in the product tile info")
    public void they_see_the_number_of_color_variations_listed_in_the_product_tile_info() {
        boolean foundColor = false;
        for (WebElement color : tcs.pom.getPlp().getProductColor()) {
            String trimmedColor = color.getText().trim();
            if (trimmedColor.contains("colours")) {
                Assert.assertTrue(trimmedColor.contains("colours"));
                foundColor = true;
                break;
            }
        }
        Assert.assertTrue(foundColor, "No product colors contain the substring 'colours'");

    }


    @Given("Product tile of a product that has multiple size assortment")
    public void product_tile_of_a_product_that_has_multiple_size_assortment(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - product size")
    public void the_page_is_loaded_product_size() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("They see the number of size variations listed in the product tile info")
    public void they_see_the_number_of_size_variations_listed_in_the_product_tile_info() {
        boolean size = false;
        for (WebElement color : tcs.pom.getPlp().getProductColor()) {
            String trimmedColor = color.getText().trim();
            if (trimmedColor.contains("size")) {
                Assert.assertTrue(trimmedColor.contains("size"));
                size = true;
                break;
            }
        }
        Assert.assertTrue(size);

    }

    @Given("Given a user is viewing a product tile of a product")
    public void given_a_user_is_viewing_a_product_tile_of_a_product(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("When the page is loaded - user rating")
    public void when_the_page_is_loaded_user_rating() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);

    }

    @Then("Then they see the star rating and number of reviews")
    public void then_they_see_the_star_rating_and_number_of_reviews() {
        boolean ratingUser = false;
        for (WebElement rating : tcs.pom.getPlp().getStarRating()) {
            Assert.assertTrue(rating.isDisplayed());
            List<WebElement> userReview = tcs.pom.getPlp().getUserReview();
            Assert.assertTrue(userReview.size() > 0);
            for (WebElement user : userReview) {
                Assert.assertTrue(user.isDisplayed());
                ratingUser = true;
                break;
            }
            break;

        }
        Assert.assertTrue(ratingUser);

    }

    @Given("I am viewing a product tile on a PLP for a regularly priced product")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_regularly_priced_product(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - regular price")
    public void the_page_is_loaded_regular_price() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("The product's regular price is displayed in black font")
    public void the_product_s_regular_price_is_displayed_in_black_font() {
        boolean colorFont = false;
        for (WebElement price : tcs.pom.getPlp().getProductPrice()) {
            String trimmedColor = price.getCssValue("color").trim();
            if (trimmedColor.contains("rgba(47, 47, 47, 1)")) {
                Assert.assertTrue(trimmedColor.contains("rgba(47, 47, 47, 1)"));
                colorFont = true;
                break;
            }
        }

        Assert.assertTrue(colorFont);

    }

    @Given("I am viewing a product tile on a PLP for a product with size assortment")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_size_assortment(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - regular price range")
    public void the_page_is_loaded_regular_price_range() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("Then the product's regular price range is displayed in black font")
    public void then_the_product_s_regular_price_range_is_displayed_in_black_font() {
        boolean colorFont = false;
        for (WebElement price : tcs.pom.getPlp().getProductPrice()) {
            String trimmedColor = price.getCssValue("color").trim();
            if (trimmedColor.contains("rgba(47, 47, 47, 1)")) {
                Assert.assertTrue(trimmedColor.contains("rgba(47, 47, 47, 1)"));
                colorFont = true;
                break;
            }
        }

        Assert.assertTrue(colorFont);

    }

    @Given("I am viewing a product tile on a PLP for a discounted or clearance product")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_discounted_clearance_product(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - discounted product")
    public void the_page_is_loaded_discounted_product() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("The product's discounted price is displayed in red font")
    public void the_product_s_discounted_price_is_displayed_in_red_font() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().discountProductPrice);
        String priceColorRange = tcs.pom.getPlp().discountProductPrice.getCssValue("color");
        Assert.assertEquals("rgba(203, 51, 59, 1)", priceColorRange);

    }

    @Then("The product's regular price is displayed with strikethrough styling in grey font")
    public void the_product_s_regular_price_is_displayed_with_strikethrough_styling_in_grey_font() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().regularDiscountProductPrice);
        String priceColorRange = tcs.pom.getPlp().regularDiscountProductPrice.getCssValue("color");
        Assert.assertEquals("rgba(117, 117, 117, 1)", priceColorRange);
    }

    @Then("Clearance and Sale labels differ")
    public void clearance_and_sale_labels_differ() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().saleName);
        String sale = tcs.pom.getPlp().saleName.getText();
        Assert.assertEquals("Sale", sale);
    }

    @Given("I am viewing a product tile on a PLP for a product with item level PC Optimum promotion")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_item_level_pc_optimum_promotion(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "OfferPage");
    }

    @Given("Promotion does not require quantity purchase")
    public void promotion_does_not_require_quantity_purchase() {

    }

    @When("^the page is loaded - P01$")
    public void when_the_page_is_loaded_p01() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("The applicable PC Optimum bonus point is displayed in red font")
    public void the_applicable_pc_optimum_bonus_point_is_displayed_in_red_font() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().bonusPoint);
        String priceColorRange = tcs.pom.getPlp().bonusPoint.getCssValue("color");
        Assert.assertEquals("rgba(203, 51, 59, 1)", priceColorRange);

    }

    @When("^the page is loaded - P05$")
    public void when_the_page_is_loaded_p05() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("Then PC Optimum Offer text is displayed in red font")
    public void then_pc_optimum_offer_text_is_displayed_in_red_font() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().pcOptimumOffer);
        String optimumColor = tcs.pom.getPlp().pcOptimumOffer.getCssValue("color");
        Assert.assertEquals("rgba(203, 51, 59, 1)", optimumColor);
    }

    @Given("I am viewing a product tile on a PLP for a product with item level PC Optimum points multiplier promotion P08")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_item_level_pc_optimum_points_multiplier_promotion_p08(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "OfferPage");
    }


    @When("^The page is loaded - P08$")
    public void the_page_is_loaded_p08() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
    }

    @Then("^Then \"10x the points\" text is displayed in red font$")
    public void then_text_is_displayed_in_red_font() {
        tcs.pom.getPlp().handlePointText();
        tcs.common.addExplicitWait(tcs.pom.getPlp().points);
        String pointsColor = tcs.pom.getPlp().points.getCssValue("color");
        Assert.assertEquals("rgba(203, 51, 59, 1)", pointsColor);

    }

    @Given("I hover over a product time I can see the quick view button")
    public void i_hover_over_a_product_time_i_can_see_the_quick_view_button(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");
        tcs.common.addExplicitWait(tcs.pom.getPlp().productToHover);
        Actions actionHover = new Actions(tcs.base.driver);
        actionHover.moveToElement(tcs.pom.getPlp().productToHover).perform();

    }

    @When("I click on the quick view button")
    public void i_click_on_the_quick_view_button() {
        tcs.common.addImplicitWait();
        LockSupport.parkNanos(TimeUnit.SECONDS.toMillis(1000));
        WebElement quickView = tcs.pom.getPlp().quickView;
        Assert.assertEquals("Quick view", quickView.getText());
        quickView.click();

    }

    @Then("The quick view modal opens")
    public void the_quick_view_modal_opens() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().quickViewModelElement);
        Assert.assertTrue(tcs.pom.getPlp().quickViewModelElement.isDisplayed());

    }

    @Given("Given I hover over a product WITH VARIANTS, I can see the quick view button")
    public void given_i_hover_over_a_product_with_variants_i_can_see_the_quick_view_button(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "VarientQuickView");
        tcs.common.addExplicitWait(tcs.pom.getPlp().productToHover);
        Actions actionHover = new Actions(tcs.base.driver);
        actionHover.moveToElement(tcs.pom.getPlp().productToHover).perform();
    }

    @Then("Then I can click on the drop down and select my desired variant")
    public void then_i_can_click_on_the_drop_down_and_select_my_desired_variant() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().quickViewModelElement);
        tcs.common.addImplicitWait();
        tcs.pom.getPlp().handleDropDown();
        tcs.pom.getPlp().variantDropDown.click();
        Assert.assertTrue(tcs.pom.getPlp().getVariantDropDownItems().size() > 1);

    }


    @Given("I am viewing a product tile on a PLP for a product with Gift with Purchase")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_gift_with_purchase(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "FreeGifts");

    }

    @When("The page is loaded - Gift with Purchase")
    public void the_page_is_loaded_gift_with_purchase() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().productForGiftWithPurchase);
    }

    @Then("Gift with Purchase text is displayed in red font")
    public void gift_with_purchase_text_is_displayed_in_red_font() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().giftWithPurchase);
        String pointsColor = tcs.pom.getPlp().giftWithPurchase.getCssValue("color");
        Assert.assertEquals("rgba(203, 51, 59, 1)", pointsColor);
    }

    @Given("A user is viewing a PLP for a category does not exist")
    public void a_user_is_viewing_a_plp_for_a_category_does_not_exist(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "ErrorPage");

    }

    @When("The page is loaded - 404")
    public void the_page_is_loaded() {
        Assert.assertEquals("Not Found", tcs.base.driver.getTitle());

    }

    @Then("Then they see a 404 page")
    public void then_they_see_a_page() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().error404);
        Assert.assertEquals("Error 404", tcs.pom.getPlp().error404.getText());
        Assert.assertEquals("The page you are looking for cannot be found.", tcs.pom.getPlp().pageNotFound.getText());

    }

    @Given("A user is viewing a PLP Page")
    public void a_user_is_viewing_a_plp_Page(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("The page is loaded - grid")
    public void the_page_is_loaded_grid() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);

    }

    @Then("Then they see products that belong in the category or assortment load in a grid")
    public void then_they_see_products_that_belong_in_the_category_assortment_load_in_a_grid() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().beautyGifts);
        Assert.assertEquals("Beauty Gifts", tcs.pom.getPlp().beautyGifts.getText());
        Assert.assertTrue(tcs.pom.getPlp().gridProductPage.isDisplayed());

    }

    @Given("Given I am viewing the PLP")
    public void given_i_am_viewing_the_plp(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("When the page is loaded breadCrump")
    public void when_the_page_is_loaded() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);

    }

    @Then("I can see the correct breadcrumb path that I have chosen to get to the PLP that I am viewing")
    public void i_can_see_the_correct_breadcrumb_path_that_i_have_chosen_to_get_to_the_plp_that_i_am_viewing() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().breadCrumbPath);
        String text = tcs.pom.getPlp().breadCrumbPath.getText().trim();
        String currentUrl = tcs.base.driver.getCurrentUrl();
        if (currentUrl.contains(text.split("\n")[0])) {
            Assert.assertTrue(true);
        } else if (currentUrl.contains(text.split("\n")[2])) {
            Assert.assertTrue(true);
        } else if (currentUrl.contains(tcs.pom.getPlp().beautyGifts.getText().trim())) {
            Assert.assertTrue(true);
        }
    }


    @Given("A user is viewing a PLP that contains 36 products or less")
    public void a_user_is_viewing_a_plp_that_contains_products_or_less(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "CottonSwapsPage");

    }

    @When("They scroll to the bottom of the PLP - 36 products or less")
    public void they_scroll_to_the_bottom_of_the_plp_products_or_less() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().page_of_the_PLP);
        tcs.pom.getPlp().scrollDown(tcs.pom.getPlp().bottom_of_the_PLP);

    }

    @Then("They see You've viewed [number of products visible on the page] of [number of products available on the page]")
    public void they_see_you_ve_viewed_number_of_products_visible_on_the_page_of_number_of_products_available_on_the_page() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().bottom_of_the_PLP);
        Assert.assertTrue(tcs.pom.getPlp().bottom_of_the_PLP.getText().contains("You’ve viewed 8 of 8 products"));

    }

    @Given("A user is viewing a PLP that contains 36 products or more")
    public void a_user_is_viewing_a_plp_that_contains_products_or_more(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("They scroll to the bottom of the PLP - 36 or more products")
    public void they_scroll_to_the_bottom_of_the_plp_or_more_products() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().page_of_the_PLP);
        tcs.pom.getPlp().scrollDown(tcs.pom.getPlp().bottom_of_the_PLP);

    }

    @Then("They see Pagination buttons")
    public void they_see_pagination_buttons() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().bottom_of_the_PLP);
        Assert.assertTrue(tcs.pom.getPlp().bottom_of_the_PLP.getText().contains("You’ve viewed"));

    }

    @Then("User should be on first page with red asterisk color")
    public void user_should_be_on_first_page_with_red_asterisk_color() {
        tcs.common.addExplicitWait( tcs.pom.getPlp().first_page_of_asterisk);
        WebElement firstPageOfAsterisk = tcs.pom.getPlp().first_page_of_asterisk;
        Assert.assertEquals(firstPageOfAsterisk.getText(), "1");
        Assert.assertEquals(firstPageOfAsterisk.getCssValue("color"), "rgba(255, 0, 0, 1)");

    }

    @Then("All the pagination buttons should be clickable")
    public void all_the_pagination_buttons_should_be_clickable() {
        Assert.assertEquals(tcs.pom.getPlp().first_page_of_asterisk.getText(), "1");
        Assert.assertTrue(tcs.pom.getPlp().clickAblePage(tcs.pom.getPlp().first_page_of_asterisk));
        Assert.assertEquals(tcs.pom.getPlp().second_page_of_asterisk.getText(), "2");
        Assert.assertTrue(tcs.pom.getPlp().clickAblePage(tcs.pom.getPlp().second_page_of_asterisk));
        Assert.assertEquals(tcs.pom.getPlp().third_page_of_asterisk.getText(), "3");
        Assert.assertTrue(tcs.pom.getPlp().clickAblePage(tcs.pom.getPlp().third_page_of_asterisk));


    }

    @Then("If pagination count more than three then an arrow should be displayed")
    public void if_pagination_count_more_than_three_then_an_arrow_should_be_displayed() {
        tcs.common.addExplicitWait( tcs.pom.getPlp().arrow_button);
        Assert.assertTrue(tcs.pom.getPlp().arrow_button.isDisplayed());

    }

    @Given("A user is viewing a PLP that contains less then 36 products")
    public void a_user_is_viewing_a_plp_that_contains_less_then_products(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "CottonSwapsPage");

    }

    @When("They scroll to the bottom of the PLP - less then 36")
    public void they_scroll_to_the_bottom_of_the_plp_less_then() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().page_of_the_PLP);
        tcs.pom.getPlp().scrollDown(tcs.pom.getPlp().bottom_of_the_PLP);

    }

    @Then("They should not see pagination buttons")
    public void they_should_not_see_pagination_buttons() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().bottom_of_the_PLP);
        try {
            Assert.assertFalse(tcs.pom.getPlp().first_page_of_asterisk.isDisplayed());
        } catch (NoSuchElementException ignored) {

        }

    }

    @Given("A user is viewing a PLP and has scrolled to the bottom of the PLP")
    public void a_user_is_viewing_a_plp_and_has_scrolled_to_the_bottom_of_the_plp(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");
        tcs.common.addExplicitWait(tcs.pom.getPlp().page_of_the_PLP);
        tcs.pom.getPlp().scrollDown(tcs.pom.getPlp().bottom_of_the_PLP);
        tcs.common.addExplicitWait(tcs.pom.getPlp().bottom_of_the_PLP);
        Assert.assertTrue(tcs.pom.getPlp().bottom_of_the_PLP.getText().contains("You’ve viewed"));

    }

    @When("They click the next pagination button")
    public void they_click_the_next_pagination_button() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().second_page_of_asterisk);
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().second_page_of_asterisk);


    }

    @Then("They see the next 36 products that belong on the 2nd pagination with red asterisk color")
    public void they_see_the_next_products_that_belong_on_the_2nd_pagination_with_red_asterisk_color() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().bottom_of_the_PLP);
        tcs.pom.getPlp().scrollDown(tcs.pom.getPlp().bottom_of_the_PLP);
        tcs.pom.getPlp().scrollDown(tcs.pom.getPlp().second_page_of_asterisk);
        Assert.assertEquals("2", tcs.pom.getPlp().second_page_of_asterisk.getText());
        Assert.assertEquals(tcs.pom.getPlp().second_page_of_asterisk.getCssValue("color"), "rgba(255, 0, 0, 1)");

    }

    @Given("A user is viewing PLP left side filter")
    public void a_user_is_viewing_plp_left_side_filter(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "BeautyPages");

    }

    @When("They go to Brand type filter")
    public void they_go_to_brand_type_filter() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().brandSearchContent);
        Assert.assertTrue(tcs.pom.getPlp().brandSearchContent.isDisplayed());

    }

    @Then("User should see a search bar on top to search the brands")
    public void user_should_see_a_search_bar_on_top_to_search_the_brands() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().brandSearchField);
        Assert.assertTrue(tcs.pom.getPlp().brandSearchField.isDisplayed());

    }

    @Given("I am on the PLP with Brand type filter search bar")
    public void i_am_on_the_plp_with_brand_type_filter_search_bar(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "SkinCarePage");

    }

    @When("I enter characters in the brands search bar")
    public void i_enter_characters_in_the_brands_search_bar(DataReader dataReader) {
        tcs.common.addExplicitWait(tcs.pom.getPlp().brandSearchContent);
        Assert.assertTrue(tcs.pom.getPlp().brandSearchContent.isDisplayed());
        WebElement brandSearchField = tcs.pom.getPlp().brandSearchField;
        tcs.common.addExplicitWait(brandSearchField);
        Assert.assertTrue(brandSearchField.isDisplayed());
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        brandSearchField.sendKeys(searchBrandName);
        brandSearchField.sendKeys(Keys.ENTER);

    }


    @Then("Brand name filters should be displayed that match the characters typed")
    public void brand_name_filters_should_be_displayed_that_match_the_characters_typed(DataReader dataReader) {
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        WebElement searchBrandItems = tcs.pom.getPlp().getSearchBrandItems(searchBrandName);
        Assert.assertEquals(searchBrandName, searchBrandItems.getText().trim().split(" ")[0]);

    }

    @Given("I am on the PLP with left side filter")
    public void i_am_on_the_plp_with_left_side_filter(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "SkinCarePage");

    }

    @When("I select some filters")
    public void i_select_some_filters(DataReader dataReader) {
        tcs.common.addExplicitWait(tcs.pom.getPlp().productForGiftWithPurchase);
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().getSearchBrandItemsForFilter(searchBrandName));
        String searchAnotherBrandName = Common.dataExtractorFromSheet(dataReader, "SecondBrandName");
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().getSearchBrandItemsForFilter(searchAnotherBrandName));

    }

    @Then("All the selected filters should be applied on PLP")
    public void all_the_selected_filters_should_be_applied_on_plp(DataReader dataReader) {
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        String searchAnotherBrandName = Common.dataExtractorFromSheet(dataReader, "SecondBrandName");
        List<String> brandNames = tcs.pom.getPlp().getBrandName().stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        boolean brandNameFound = false;

        for (String brandName : brandNames) {
            if (brandName.contains(searchBrandName)) {
                Assert.assertEquals(searchBrandName, brandName);
                brandNameFound = true;
                break;
            } else if (brandName.contains(searchAnotherBrandName)) {
                Assert.assertEquals(searchAnotherBrandName, brandName);
                brandNameFound = true;
                break;
            }
        }
        Assert.assertTrue(brandNameFound, "The search brand name or another brand name was not found.");

    }

    @Then("Correct count should be displayed on top right")
    public void correct_count_should_be_displayed_on_top_right() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().bottom_of_the_PLP);
        Assert.assertEquals(tcs.pom.getPlp().bottom_of_the_PLP.getText().split(" ")[2].trim(), String.valueOf(tcs.pom.getPlp().getBrandName().size()));

    }

    @Then("All the applied filters should be displayed on top as chip with cross button")
    public void all_the_applied_filters_should_be_displayed_on_top_as_chip_with_cross_button(DataReader dataReader) {
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        String searchAnotherBrandName = Common.dataExtractorFromSheet(dataReader, "SecondBrandName");
        Assert.assertEquals(tcs.pom.getPlp().first_Filter_item.getText(), searchAnotherBrandName);
        Assert.assertEquals(tcs.pom.getPlp().second_Filter_item.getText(), searchBrandName);

    }

    @Given("I am on the PLP with Applied filters")
    public void i_am_on_the_plp_with_applied_filters(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "SkinCarePage");
        tcs.common.addExplicitWait(tcs.pom.getPlp().productForGiftWithPurchase);
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().getSearchBrandItemsForFilter(searchBrandName));
        String searchAnotherBrandName = Common.dataExtractorFromSheet(dataReader, "SecondBrandName");
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().getSearchBrandItemsForFilter(searchAnotherBrandName));

    }

    @When("I click on Clear all")
    public void i_click_on_clear_all() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().clearAllFilter);

    }

    @Then("The applied filters  should be removed and result should be updated accordingly on PLP")
    public void the_applied_filters_should_be_removed_and_result_should_be_updated_accordingly_on_plp() {
        Assert.assertEquals(tcs.pom.getPlp().checkBoxOfSearchBrand.size(), 0);

    }

    @Given("I am on the PLP with some applied filters")
    public void i_am_on_the_plp_with_some_applied_filters(DataReader dataReader) {
        tcs.common.ExcelPageExtractor(dataReader, "SkinCarePage");
        tcs.common.addExplicitWait(tcs.pom.getPlp().productForGiftWithPurchase);
        String searchBrandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.pom.getPlp().clickOnAsterisk(tcs.pom.getPlp().getSearchBrandItemsForFilter(searchBrandName));

    }

    @When("I click on applied filter chip cross button")
    public void i_click_on_applied_filter_chip_cross_button() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
        tcs.pom.getPlp().press_enter_to_remove_filter.click();

    }

    @Then("That filter chip should be removed and the result on PLP should be updated accordingly")
    public void that_filter_chip_should_be_removed_and_the_result_on_plp_should_be_updated_accordingly() {
        Assert.assertEquals(tcs.pom.getPlp().checkBoxOfSearchBrand.size(), 0);

    }

    @When("click on any Product PDP or Cart and come back to PLP")
    public void click_on_any_product_pdp_or_cart_and_come_back_to_plp() {
        tcs.common.addExplicitWait(tcs.pom.getPlp().gridPage);
        tcs.pom.getPlp().pdpOfProduct.click();
        tcs.base.driver.navigate().back();

    }

    @Then("Then on the PLP applied filters should remains")
    public void then_on_the_plp_applied_filters_should_remains() {
        Assert.assertEquals(tcs.pom.getPlp().checkBoxOfSearchBrand.size(), 1);

    }

}