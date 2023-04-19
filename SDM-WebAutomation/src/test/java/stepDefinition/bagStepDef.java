package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import util.ExcelReader;
import util.TestContextSetup;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class bagStepDef {
    TestContextSetup tcs;

    public bagStepDef(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I am on the bag page sheetname {string} and rownumber {int}")
    public void iAmOnTheBagPageSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("Term");
        tcs.pom.bag().setSearchBoxMultiple(heading);
        tcs.pom.bag().goToBagPage();
    }

    @When("I have added products to my bag")
    public void i_have_added_products_to_my_bag() throws InterruptedException {

    }

    @Then("my added products load on the page")
    public void my_added_products_load_on_the_page() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().productOnCart());
    }

    @Given("I am on the bag page empty")
    public void i_am_on_the_bag_page_empty() throws InterruptedException {
        tcs.pom.bag().shopClick();
    }

    @When("I have not added products to my bag")
    public void i_have_not_added_products_to_my_bag() throws InterruptedException {
        tcs.pom.bag().bagClick();
    }

    @Then("I am presented with the message that my bag is currently empty and option to keep shopping")
    public void i_am_presented_with_the_message_that_my_bag_is_currently_empty_and_option_to_keep_shopping() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }

    @When("I remove the item")
    public void i_remove_the_item() throws InterruptedException {
        tcs.pom.bag().removeProduct();
    }

    @Then("my bag should be empty")
    public void my_bag_should_be_empty() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }

    @When("I have a qualifying product from the beauty category")
    public void i_have_a_qualifying_product_from_the_beauty_category() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().freeSample());
        tcs.pom.bag().addFreeSamples();
    }

    @Then("I can select up to 3 samples to be shipped alongside my order for free")
    public void i_can_select_up_to_samples_to_be_shipped_alongside_my_order_for_free() {
        Assert.assertFalse(tcs.pom.bag().sampleDisabled());
    }

    @When("I remove all qualifying product from the beauty category")
    public void i_remove_all_qualifying_product_from_the_beauty_category() throws InterruptedException {
        tcs.pom.bag().removeSampleProduct();
    }

    @Then("I no longer see samples in my bag")
    public void i_no_longer_see_samples_in_my_bag() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().removeSample());
    }

    @When("I have added products to my bag and I have not signed in")
    public void i_have_added_products_to_my_bag_and_i_have_not_signed_in() throws InterruptedException {
        //Assert.assertTrue(tcs.pom.bag().orderSummary());
    }

    @Then("I am presented the summary calculations of my order but not the tax value")
    public void i_am_presented_the_summary_calculations_of_my_order_but_not_the_tax_value() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().booleantotalBeforeTax());
    }

    @When("I have added products to my bag and I have signed in with an account that has made it through checkout journey before")
    public void i_have_added_products_to_my_bag_and_i_have_signed_in_with_an_account_that_has_made_it_through_checkout_journey_before() throws InterruptedException {
        tcs.pom.bag().checkout();
        tcs.pom.bag().goToCheckoutShippingAddress();
    }

    @Then("I am presented the summary calculations of my order including the tax value")
    public void i_am_presented_the_summary_calculations_of_my_order_including_the_tax_value() {
        // Will add once QA will be integrated in Prod
    }

    @Given("I am on the bag page under50 sheetname {string} and rownumber {int}")
    public void i_am_on_the_bag_page_under50_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("under50$");
        tcs.pom.bag().setSearchBoxMultiple(heading);

    }

    @When("I have added products to my bag and my order is under fifty")
    public void i_have_added_products_to_my_bag_and_my_order_is_under_fifty() throws InterruptedException {
        tcs.pom.bag().goToBagPage();
    }

    @Then("I am presented the summary calculations of my order and the shipping costs is shownas $eight")
    public void i_am_presented_the_summary_calculations_of_my_order_and_the_shipping_costs_is_shownas_$eight() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().shippingPrice());
    }

    @Then("I am presented the summary calculations of my order and the shipping costs is shown as Free")
    public void iAmPresentedTheSummaryCalculationsOfMyOrderAndTheShippingCostsIsShownAsFree() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().shippingPriceFree());
    }

    @When("I select the plus and minus buttons")
    public void iSelectThePlusAndMinusButtons() throws InterruptedException {
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();

    }

    @Then("I am able to modify the quantity to a maximum of six quantities per product and then the plus button is greyed out")
    public void iAmAbleToModifyTheQuantityToAMaximumOfsixQuantitiesPerProductAndThenThePlusButtonIsGreyedOut() {
        Assert.assertTrue(tcs.pom.bag().plusdisabled());
    }


    @Then("I am able to modify the quantity to a maximum ofthree quantities per product and then the plus button is greyed out")
    public void iAmAbleToModifyTheQuantityToAMaximumOfthreeQuantitiesPerProductAndThenThePlusButtonIsGreyedOut() {
        Assert.assertTrue(tcs.pom.bag().plusdisabled());
    }


    @When("I select the plus and minus buttons threetimes")
    public void iSelectThePlusAndMinusButtonsThreetimes() throws InterruptedException {
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
        tcs.pom.bag().incremenetProduct();
    }
    @Given("I am on the bag page with a CHANEL product")
    public void iAmOnTheBagPageWithACHANELProduct() throws InterruptedException {
        tcs.pom.bag().addToBagPageChanel();
    }
    @Given("have the max quantity of the item in my bag sheetname {string} and rownumber {int}")
    public void have_the_max_quantity_of_the_item_in_my_bag_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("product");
        System.out.println(heading);
        tcs.pom.bag().setSearchBoxMultiple(heading);

    }
    @When("I try to add more from PDP or PLP")
    public void i_try_to_add_more_from_pdp_or_plp() throws InterruptedException {
        tcs.pom.bag().maxQuantity();
        tcs.pom.bag().addProductFromPDP();
    }
    @Then("I am not able to do so and I get an error message")
    public void i_am_not_able_to_do_so_and_i_get_an_error_message() {
    Assert.assertTrue(tcs.pom.bag().errorMessageOnAdd());
    }
    @When("I have an item that qualify for the gift with purchase")
    public void i_have_an_item_that_qualify_for_the_gift_with_purchase() {

    }

    @Then("I see the free gift in my bag")
    public void i_see_the_free_gift_in_my_bag() {
    Assert.assertTrue(tcs.pom.bag().freeGifts());
    }
    @Given("I am on the bag page and have a GWP sheetname {string} and rownumber {int}")
    public void iAmOnTheBagPageAndHaveAGWPSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("GWP");
        System.out.println(heading);
        tcs.pom.bag().setSearchBoxMultiple(heading);
    }
    @When("I remove qualifying item")
    public void i_remove_qualifying_item() throws InterruptedException {
        tcs.pom.bag().goToBagPage();
        tcs.pom.bag().removeProduct();
    }
    @Then("the GWP is removed from the bag")
    public void the_gwp_is_removed_from_the_bag() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }
    @When("I spend more than the threshold and qualify for a deluxe sample")
    public void i_spend_more_than_the_threshold_and_qualify_for_a_deluxe_sample() {

    }
    @Then("I am presented with a free deluxe sample in my bag")
    public void i_am_presented_with_a_free_deluxe_sample_in_my_bag() {
    Assert.assertTrue(tcs.pom.bag().freesampleVisible());
    }


    @When("I enter a promo code that applies to the item\\(s) in the bag")
    public void iEnterAPromoCodeThatAppliesToTheItemSInTheBag() {
        tcs.pom.bag().enterPromoCode();
    }

    @Then("the appropriate discount will be applied to the order and displayed in the order summary calculation")
    public void theAppropriateDiscountWillBeAppliedToTheOrderAndDisplayedInTheOrderSummaryCalculation() {
        Assert.assertTrue(tcs.pom.bag().displayMessage());
    }

    @When("I enter an invalid promo code")
    public void iEnterAnInvalidPromoCode() {
        tcs.pom.bag().enterPromoCode();
    }

    @Then("an error message will be displayed")
    public void anErrorMessageWillBeDisplayed() {
        Assert.assertTrue(tcs.pom.bag().displayMessage());

    }

    @When("I enter a one-time promo code that has already been used")
    public void iEnterAOneTimePromoCodeThatHasAlreadyBeenUsed() {
        tcs.pom.bag().enterPromoCode();
    }

    @Then("an error message will be displayed This promo code has already been used and cannot be applied again.")
    public void anErrorMessageWillBeDisplayedThisPromoCodeHasAlreadyBeenUsedAndCannotBeAppliedAgain() {
        Assert.assertTrue(tcs.pom.bag().displayMessage());
    }


    @When("I try to add more from PDP or PLP for chanel")
    public void iTryToAddMoreFromPDPOrPLPForChanel() {
    }



    @When("I enter a promo code that only applies to Beauty products")
    public void iEnterAPromoCodeThatOnlyAppliesToBeautyProducts() {
        tcs.pom.bag().enterPromoCode();
    }

    @Then("an error message will be displayed mentioning that it's for the wrong category or fineline")
    public void anErrorMessageWillBeDisplayedMentioningThatItSForTheWrongCategoryOrFineline() {
        Assert.assertTrue(tcs.pom.bag().displayMessage());
    }

    @When("I enter a code that includes free shipping")
    public void iEnterACodeThatIncludesFreeShipping() {
        tcs.pom.bag().enterPromoCode();
    }

    @Then("The shipping cost in the summary calculation will changed to Free, regardless of the value of the bag.")
    public void theShippingCostInTheSummaryCalculationWillChangedToFreeRegardlessOfTheValueOfTheBag() {
        Assert.assertTrue(tcs.pom.bag().displayMessage());
    }


    @When("I am signed in with an account with PCO and have items in my bag")
    public void iAmSignedInWithAnAccountWithPCOAndHaveItemsInMyBag() {
        tcs.pom.bag().gotoSignin();
        tcs.pom.bag().enterPCOAccount();
    }

    @Then("the PCO tile will display with the message")
    public void thePCOTileWillDisplayWithTheMessage() {
        Assert.assertTrue(tcs.pom.bag().validatePointsEarned());
    }

    @When("I am signed in but don't have a PCO account and have items in my bag")
    public void iAmSignedInButDonTHaveAPCOAccountAndHaveItemsInMyBag() {
        tcs.pom.bag().gotoSignin();
        tcs.pom.bag().enterNonPCOAccount();
    }


    @Then("the PCO tile will display with the message Points you could earn today! as well as offering the options to sign up")
    public void thePCOTileWillDisplayWithTheMessagePointsYouCouldEarnTodayAsWellAsOfferingTheOptionsToSignUp() {
        Assert.assertTrue(tcs.pom.bag().validateMessageWithoutPCAccount());
    }

    @Given("that I am on the bag page and I have only non-beauty products in my bags sheetname {string} and rownumber {int}")
    public void that_i_am_on_the_bag_page_and_i_have_only_non_beauty_products_in_my_bags_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("NonBeautyProduct");
        System.out.println(heading);
        tcs.pom.bag().setSearchBoxMultiple(heading);
        tcs.pom.bag().goToBagPage();
    }



    @Given("I am on a PDP page looking at a product and that product is in stock and I leave that page open and I return and that product is now out of stock sheetname {string} and rownumber {int}")
    public void i_am_on_a_pdp_page_looking_at_a_product_and_that_product_is_in_stock_and_i_leave_that_page_open_and_i_return_and_that_product_is_now_out_of_stock_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("OOS Product");
        System.out.println(heading);
        tcs.pom.bag().setSearchBoxMultiple(heading);
    }

    @When("I add that product to my bag")
    public void iAddThatProductToMyBag() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().addOOSProductToBag());

    }

    @Then("I should know that the product is no longer available and I should not be able to add it to my bag")
    public void iShouldKnowThatTheProductIsNoLongerAvailableAndIShouldNotBeAbleToAddItToMyBag() {
        Assert.assertTrue(tcs.pom.bag().validateOOSProduct());
    }

    @When("I am not signed in and have no items in my bag")
    public void i_am_not_signed_in_and_have_no_items_in_my_bag() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noSignIn());
    }

    @Then("The PCO tile will not display on the bag page")
    public void the_pco_tile_will_not_display_on_the_bag_page() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().noProduct());
    }

    @Given("I am on the bag page")
    public void i_am_on_the_bag_page() throws InterruptedException {
        tcs.pom.bag().shopClick();
        tcs.pom.bag().bagClick();
    }

    @Given("I have a registered account with a pre-existing cart but I am shopping as a guest user and added items to my bag sheetname {string} and rownumber {int}")
    public void i_have_a_registered_account_with_a_pre_existing_cart_but_i_am_shopping_as_a_guest_user_and_added_items_to_my_bag(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("Term");
        tcs.pom.bag().setSearchBoxMultiple(heading);
        tcs.pom.bag().goToBagPage();
    }

    @When("I sign in to my account on the bag page")
    public void i_sign_in_to_my_account_on_the_bag_page() {
        tcs.pom.bag().signInOnBag();
    }

    @Then("I get a pop-up telling me my bag has been updated")
    public void i_get_a_pop_up_telling_me_my_bag_has_been_updated() {
    }

    @Given("That I am on the bag page")
    public void that_i_am_on_the_bag_page() throws InterruptedException {
        tcs.pom.bag().shopClick();
        tcs.pom.bag().bagClick();
    }

    @When("I sign in after having an empty bag to an account with an empty bag")
    public void i_sign_in_after_having_an_empty_bag_to_an_account_with_an_empty_bag() {
        tcs.pom.bag().signInOnEmptyBag();
    }

    @Then("Text changes from {string} to Please add items to your bag")
    public void text_changes_from_to_please_add_items_to_your_bag(String arg0) {
    }

    @Given("That I am on the bag page sheetname {string} and rownumber {int}")
    public void that_i_am_on_the_bag_page(String sheetName, Integer rowNumber) throws InterruptedException, IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("Term");
        tcs.pom.bag().setSearchBoxMultiple(heading);
        tcs.pom.bag().goToBagPage();
    }

    @When("I have items in my bag")
    public void i_have_items_in_my_bag() {
        tcs.pom.bag().productONBag();
    }

    @Then("I will see a Checkout CTA under the order summary calculation.")
    public void i_will_see_a_checkout_cta_under_the_order_summary_calculation() {
        tcs.pom.bag().checkoutWithoutSIgnIN();
    }

    @Given("I am an SDM employee and I added my location id to my account and activated my Employee Discount Program")
    public void iAmAnSDMEmployeeAndIAddedMyLocationIdToMyAccountAndActivatedMyEmployeeDiscountProgram() {
        
    }

    @When("I add an item to my cart")
    public void iAddAnItemToMyCart() {
        
    }

    @Then("If the items current price doesnot have any promotions available, then the discount price shown on the cart should be MAX")
    public void ifTheItemsCurrentPriceDoesnotHaveAnyPromotionsAvailableThenTheDiscountPriceShownOnTheCartShouldBeMAX() {
        
    }

    @Then("If the items current price has a promotion, then discount price shown on the cart should be MIN")
    public void ifTheItemsCurrentPriceHasAPromotionThenDiscountPriceShownOnTheCartShouldBeMIN() {
        
    }

    @Given("I have a cart with the following items: item a with a wholesale price of ${int}, regular price of ${int}, and no deal, item b with {int}% off sale, item c with a ${int} off sale on the ${int} regular price and ${int} wholesale price, voucher d")
    public void iHaveACartWithTheFollowingItemsItemAWithAWholesalePriceOf$RegularPriceOf$AndNoDealItemBWithOffSaleItemCWithA$OffSaleOnThe$RegularPriceAnd$WholesalePriceVoucherD(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        
    }

    @When("I activate my employee discount from my account and go to view my cart")
    public void iActivateMyEmployeeDiscountFromMyAccountAndGoToViewMyCart() {
        
    }

    @Then("Then I see item a now has {int}% off, item b still has {int}%, item c has {int}%, and my voucher d will be removed unless it also applies to the employees.")
    public void thenISeeItemANowHasOffItemBStillHasItemCHasAndMyVoucherDWillBeRemovedUnlessItAlsoAppliesToTheEmployees(int arg0, int arg1, int arg2) {
        
    }

    @Given("I have my employee discount activated and I created a cart and added a voucher that")
    public void iHaveMyEmployeeDiscountActivatedAndICreatedACartAndAddedAVoucherThat() {
        
    }

    @When("I deactivate my employee discount from my account and go to view my cart")
    public void iDeactivateMyEmployeeDiscountFromMyAccountAndGoToViewMyCart() {
        
    }

    @Then("My employee discount is removed, and I should see the items with the current price that the general public pays and my voucher is removed unless it also applies to the general public")
    public void myEmployeeDiscountIsRemovedAndIShouldSeeTheItemsWithTheCurrentPriceThatTheGeneralPublicPaysAndMyVoucherIsRemovedUnlessItAlsoAppliesToTheGeneralPublic() {
        
    }

    @Given("I created a cart without logging in and added items and a voucher to my cart")
    public void iCreatedACartWithoutLoggingInAndAddedItemsAndAVoucherToMyCart() {
        
    }

    @When("I log in to my account, which has an employee discount and a pre-existing cart with items")
    public void iLogInToMyAccountWhichHasAnEmployeeDiscountAndAPreExistingCartWithItems() {
        
    }

    @Then("I see that my cart items are merged together, my employee discount is applied on items if there is no better deal for them, and my voucher will be removed unless it also applies to the employees")
    public void iSeeThatMyCartItemsAreMergedTogetherMyEmployeeDiscountIsAppliedOnItemsIfThereIsNoBetterDealForThemAndMyVoucherWillBeRemovedUnlessItAlsoAppliesToTheEmployees() {
    }

    @Given("I am on bag page sheetname {string} and rownumber {int}")
    public void iAmOnBagPageSheetnameAndRownumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, InterruptedException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("src/main/java/resources/externalData/ddt_data.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("Samples");
        System.out.println(heading);
        tcs.pom.bag().setSearchBoxMultiple(heading);
        tcs.pom.bag().goToBagPage();
    }

    @Given("I'm an anonymous user and I have added product A to my bag from tab A and I am on tab B on the same site and I have added product B to my bag from tab B")
    public void i_m_an_anonymous_user_and_i_have_added_product_a_to_my_bag_from_tab_a_and_i_am_on_tab_b_on_the_same_site_and_i_have_added_product_b_to_my_bag_from_tab_b() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(tcs.pom.bag().checkBagQuantity());
    }
    @When("I go back to tab A and refresh the page")
    public void i_go_back_to_tab_a_and_refresh_the_page() throws InterruptedException {
        Assert.assertTrue(tcs.pom.bag().switchTabA());
    }
    @Then("My bag should show products A and B")
    public void my_bag_should_show_products_a_and_b() {
        Assert.assertTrue(tcs.pom.bag().validateBagProducts());
    }

    @Given("I am an anonymous user and I have added item A to my bag and I also have a registered user B that already had item B in my bag from yesterday")
    public void i_am_an_anonymous_user_and_i_have_added_item_a_to_my_bag_and_i_also_have_a_registered_user_b_that_already_had_item_b_in_my_bag_from_yesterday() {
        Assert.assertTrue(tcs.pom.bag().addToCart());
    }

    @When("I log in to device A as user B")
    public void i_log_in_to_device_a_as_user_b() {
        Assert.assertTrue(tcs.pom.bag().login());
    }

    @Then("I should see my bag has items A and B in them \\(items from the anonymous user are synched with items from user B, that has an account)")
    public void i_should_see_my_bag_has_items_a_and_b_in_them_items_from_the_anonymous_user_are_synched_with_items_from_user_b_that_has_an_account() {
        Assert.assertTrue(tcs.pom.bag().validateBagItems());
    }

    @Given("I have product A in my anonymous bag and product A in my registered bag")
    public void iHaveProductAInMyAnonymousBagAndProductAInMyRegisteredBag() {
        Assert.assertTrue(tcs.pom.bag().registeredAddToCart());
    }

    @When("I log in from the anonymous user to my registered user")
    public void iLogInFromTheAnonymousUserToMyRegisteredUser() {
        Assert.assertTrue(tcs.pom.bag().anonymousToRegisteredUser());
    }


    @Then("my bag with show the total number of product A's in my bag \\(added them together) and the total should not exceed the max quantity allowed for that item")
    public void myBagWithShowTheTotalNumberOfProductASInMyBagAddedThemTogetherAndTheTotalShouldNotExceedTheMaxQuantityAllowedForThatItem() {
        Assert.assertTrue(tcs.pom.bag().verifyProductQuantityInBag());
    }
}


