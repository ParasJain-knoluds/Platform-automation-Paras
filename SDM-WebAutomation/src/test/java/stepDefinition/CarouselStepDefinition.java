package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.TestContextSetup;

import java.util.List;

public class CarouselStepDefinition {

    TestContextSetup tcs;

    public CarouselStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("a user is viewing a PLP page")
    public void a_user_is_viewing_a_plp_page() {
        tcs.pom.getCarousel().viewPLPPage();
    }

    @When("they hover over a product tile")
    public void they_hover_over_a_product_tile() {
        tcs.pom.getCarousel().viewProductTile();
    }

    @Then("nothing is overlaid on product image")
    public void nothing_is_overlaid_on_product_image() {
        Assert.assertTrue((tcs.pom.getCarousel().ProductOverlay()));
    }


    @Given("a user is viewing the shop landing page")
    public void a_user_is_viewing_the_shop_landing_page() {
        tcs.pom.getCarousel().viewShopLanding();
    }

    @When("the page gets loaded")
    public void the_page_gets_loaded() {

    }

    @Then("they DO NOT see a favourite button on the product tile for the main page")
    public void they_do_not_see_a_favourite_button_on_the_product_tile_for_the_main_page() {
        List<WebElement> elements = tcs.pom.getCarousel().findfavourite();
        Assert.assertTrue(elements.isEmpty(), "Element is present on the page");
    }

    @Given("a user is viewing any category landing page \\(e.g. Makeup)")
    public void a_user_is_viewing_any_category_landing_page_e_g_makeup() {
        tcs.pom.getCarousel().clickCategory();
    }

    @When("the page load")
    public void the_page_load() {
        String expectedUrl = "https://shop.shoppersdrugmart.ca/Shop/Categories/Beauty/Makeup/c/FS-MakeUp?hid=homeLandingPage_departmentTiles_Makeup_1&sort=trending&page=0";
        String actualUrl = tcs.pom.getCarousel().getURL();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Then("they see a favourite button on the product tile")
    public void they_see_a_favourite_button_on_the_product_tile() {
        Assert.assertTrue(tcs.pom.getCarousel().seeFavourite());
    }

    @Given("i am viewing a product tile on PLP")
    public void i_am_viewing_a_product_tile_on_plp() {
        tcs.pom.getCarousel().viewPLPPage();
    }

    @Then("the badge text with the highest priority for this product is displayed above the product name.")
    public void the_badge_text_with_the_highest_priority_for_this_product_is_displayed_above_the_product_name() {
        Assert.assertTrue(tcs.pom.getCarousel().viewBadge());
    }

    @Then("product brand is displayed in full")
    public void product_brand_is_displayed_in_full() {
        Assert.assertTrue(tcs.pom.getCarousel().viewProductBrand());
    }

    @Then("product name is displayed in full")
    public void product_name_is_displayed_in_full() {
        Assert.assertTrue(tcs.pom.getCarousel().viewProductName());
    }

    @Given("a user is viewing a product tile of a product that has multiple colour assortment")
    public void a_user_is_viewing_a_product_tile_of_a_product_that_has_multiple_colour_assortment() {
        tcs.pom.getCarousel().viewPLPPage();
    }

    @Then("they DO NOT see the number of colour variations listed in the product tile info")
    public void they_do_not_see_the_number_of_colour_variations_listed_in_the_product_tile_info() {
        List<WebElement> elements = tcs.pom.getCarousel().findColour();
        Assert.assertTrue(elements.isEmpty(), "Element is present on the page");
    }

    @Given("a user is viewing a product tile of a product that has multiple size assortment")
    public void a_user_is_viewing_a_product_tile_of_a_product_that_has_multiple_size_assortment() {
        tcs.pom.getCarousel().viewPLPPage();
    }

    @Then("they DO NOT see the number of size variations listed in the product tile info")
    public void they_do_not_see_the_number_of_size_variations_listed_in_the_product_tile_info() {
        List<WebElement> elements = tcs.pom.getCarousel().findSize();
        Assert.assertTrue(elements.isEmpty(), "Element is present on the page");
    }

    @Given("i am viewing a product tile on a PLP for a regularly priced product")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_regularly_priced_product() {
        tcs.pom.getCarousel().viewPLPPage();
    }

    @When("the page gets load")
    public void the_page_gets_load() {

    }

    @Then("the product's regular price is displayed in black font")
    public void the_product_s_regular_price_is_displayed_in_black_font() {
        tcs.pom.getCarousel().viewProductPrice();
    }

    @Given("i am viewing a product tile on a PLP for a product with size assortment")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_size_assortment() {
        tcs.pom.getCarousel().viewPLPPageWithSize();
    }

    @Then("the product's regular price range is displayed in black font")
    public void the_product_s_regular_price_range_is_displayed_in_black_font() {
        tcs.pom.getCarousel().viewPriceRange();
    }

    @Given("i am viewing a product tile on a PLP for a discounted or clearance product")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_discounted_clearance_product() {
        tcs.pom.getCarousel().viewPLPPageWithSize();
    }

    @Then("the product's discounted price is displayed in red font AND is followed by the product's regular price is displayed with strikethrough styling in grey font")
    public void the_product_s_discounted_price_is_displayed_in_red_font_and_is_followed_by_the_product_s_regular_price_is_displayed_with_strikethrough_styling_in_grey_font() {
        tcs.pom.getCarousel().viewPriceDiscount();
    }

    @Given("i am viewing a product tile on a PLP for a product with item level PC Optimum promotion AND promotion does not require quantity purchase")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_item_level_pc_optimum_promotion_and_promotion_does_not_require_quantity_purchase() {
        tcs.pom.getCarousel().viewPCPage();
    }

    @Then("the applicable PC Optimum bonus point is displayed 3000 in red font")
    public void the_applicable_pc_optimum_bonus_point_is_displayed_eg_in_red_font() {
        tcs.pom.getCarousel().view3000PC();
    }

    @Given("i am viewing a product tile on a PLP for a product with item level PC Optimum promotion AND promotion requires quantity purchase")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_item_level_pc_optimum_promotion_and_promotion_requires_quantity_purchase_e_g_buy_and_get_points() {
        tcs.pom.getCarousel().viewPLPPageWithSize();
    }

    @Then("PC Optimum Offer text is displayed in red font")
    public void pc_optimum_offer_text_is_displayed_in_red_font() {
        tcs.pom.getCarousel().viewOffers();
    }

    @Given("i am viewing a product tile on a PLP for a product with a item level multiplier PC Optimum promotion \\(e.g. get 10x points on purchase of this product)")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_a_item_level_multiplier_pc_optimum_promotion_e_g_get_10x_points_on_purchase_of_this_product() {
        tcs.pom.getCarousel().viewPLPPageWithSize();
    }

    @Then("Nx the points text is displayed in red font")
    public void nx_the_points_text_is_displayed_in_red_font() {
        tcs.pom.getCarousel().viewOffers();
    }

    @Given("i am viewing a product tile on a PLP for a product with Gift with Purchase")
    public void i_am_viewing_a_product_tile_on_a_plp_for_a_product_with_gift_with_purchase() {
        tcs.pom.getCarousel().viewGiftPage();
    }

    @Then("Gift with Purchase text is displayed in red font - carousel")
    public void gift_with_purchase_text_is_displayed_in_red_font_carousel() {
        tcs.pom.getCarousel().clickGiftWithPurchase();
    }

    @When("the page is loaded - carousel")
    public void thePageIsLoaded_carousel() {
    }
}
