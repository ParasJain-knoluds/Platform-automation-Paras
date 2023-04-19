package stepDefinition;

import ddtConfig.DataReader;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.Color;
import util.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;
import java.util.List;
import java.util.Map;

public class PdpStepDefinition {
    TestContextSetup tcs;
    public PdpStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("I am viewing a PDP page")
    public void i_am_viewing_a_pdp_page() {

    }

    @When("The page is loaded")
    public void the_page_is_loaded() {
    }

    @Then("they see breadcrumb links at the top left, including from Left to right:")
    public void they_see_breadcrumb_links_at_the_top_left_including_from_left_to_right() {
        Assert.assertTrue(tcs.pom.getHomePage().validateHomePage());
    }

    @Given("I am viewing the Pdp Page")
    public void i_am_viewing_pdp_page() {
    }
    @When("I click on the brand name")
    public void i_Click_On_The_Brand_Name() {
    }
    @Then("user is directed to the Brand PLP")
    public void user_Is_Directed_To_The_Brand_PLP(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().brandName);
            Assert.assertTrue(tcs.pom.getPdpPage().brandName.isDisplayed());
            Log.info("Brand name : " + tcs.pom.getPdpPage().brandName.getText());
            String brandName = tcs.pom.getPdpPage().brandName.getText();
            tcs.pom.getPdpPage().brandName.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().pageHeading);
            Log.info("Page heading : " + tcs.pom.getPdpPage().pageHeading.getText());
            Assert.assertEquals(tcs.pom.getPdpPage().pageHeading.getText(),brandName);
        }
    }


    @When("I click on the magnifier Icon")
    public void i_Click_On_The_Magnifier_Icon() {}
    @Then("the zoomed image should be displayed with Close button on the top right corner which when clicked closes the zoomed image")
    public void the_Zoomed_Image_Should_Be_Displayed_With_Close_Button_On_The_Top_Right_Corner_Which_When_Clicked_Closes_The_Zoomed_Image(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().zoomBtn);
            tcs.pom.getPdpPage().zoomBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().zoomedImg);
            Assert.assertTrue(tcs.pom.getPdpPage().zoomedImg.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().zoomedImgCloseBtn.isDisplayed());
            tcs.pom.getPdpPage().zoomedImgCloseBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().zoomBtn);
            Assert.assertTrue(tcs.pom.getPdpPage().zoomBtn.isDisplayed());
        }
    }


    @When("I click on Write a review link")
    public void i_click_on_write_a_review_link() {}
    @Then("the Review form should be opened")
    public void the_review_form_should_be_opened(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().writeReviewBtn);
            tcs.pom.getPdpPage().writeReviewBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().writeReviewFormHeader);
            Assert.assertEquals(tcs.pom.getPdpPage().writeReviewFormHeader.getText(),"Write a Review");
            Assert.assertTrue(tcs.pom.getPdpPage().writeReviewFormRating.isDisplayed());
        }
    }


    @Given("that I am viewing the Pdp Page And the quantity is 1")
    public void that_I_Am_Viewing_PDP_Page_And_The_Quantity_Is_1() {}
    @When("I click on the - CTA to decrease qty")
    public void i_Click_On_The_CTA_To_Decrease_Qty() {}
    @Then("the Decrease CTA should be greyed out And I should not be able to decrease quantity below 1")
    public void the_Decrease_CTA_Should_Be_Greyed_Out_And_I_Should_Not_Be_Able_To_Decrease_Quantity_Below(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().productQuantity);
            String prdQuantity = tcs.pom.getPdpPage().productQuantity.getText();
            Log.info("prdQuantity : " + prdQuantity);
            Assert.assertEquals(prdQuantity, "1");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().decreaseQuantityDisabled);
            Assert.assertTrue(tcs.pom.getPdpPage().decreaseQuantityDisabled.isDisplayed());
            String ExpectedGrey = "#c1c1c1";
            String btnColorGrey= tcs.pom.getPdpPage().decreaseQuantityDisabled.getCssValue("background").split("none")[0].trim();
            Log.info("btnColorGrey : " + btnColorGrey);
            String HexColorGrey = Color.fromString(btnColorGrey).asHex();
            Log.info("HexColorGrey : " + HexColorGrey);
            Assert.assertEquals(HexColorGrey, ExpectedGrey);
            tcs.pom.getPdpPage().decreaseQuantityDisabled.click();
            String prdQuantityAfterClick = tcs.pom.getPdpPage().productQuantity.getText();
            Log.info("prdQuantityAfterClick : " + prdQuantityAfterClick);
            Assert.assertEquals(prdQuantity, "1");
        }
    }


    @When("I click on quantity increase CTA")
    public void i_Click_On_Quantity_Increase_CTA() {}
    @Then("I should be able to increase quantity till 6 And after 6 message should be displayed about quantity limit")
    public void i_Should_Be_Able_To_Increase_Quantity_Till_And_After_Message_Should_Be_Displayed_About_Quantity_Limit(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.pom.getPdpPage().increaseQuantity(6);
            String validateAlertText = "You can add up to 6 of this item to your bag, you've reached the limit";
            Log.info("maxQuantityMsg : " + tcs.pom.getPdpPage().maxQuantityMsg.getText());
            Assert.assertEquals(tcs.pom.getPdpPage().maxQuantityMsg.getText(), validateAlertText);
        }
    }


    @Given("^I am on a Product Details Page$")
    public void I_am_on_a_Product_Details_Page() {}
    @When("^I scroll to the top of the page or scroll to the bottom of the page$")
    public void I_scroll_to_the_top_of_the_page_or_scroll_to_the_bottom_of_the_page() {}
    @Then("^I want to see the standard Masthead including mega nav and Footer and be able to use it to perform a search or navigate to another page$")
    public void I_want_to_see_the_standard_Masthead_including_mega_nav_and_Footer_and_be_able_to_use_it_to_perform_a_search_or_navigate_to_another_page(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().masterHeader);
            Assert.assertTrue(tcs.pom.getPdpPage().masterHeader.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().navHeader.isDisplayed());
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().footerPDP);
            Assert.assertTrue(tcs.pom.getPdpPage().footerPDP.isDisplayed());
            Log.info("Footer text : " + tcs.pom.getPdpPage().footerPDPText.getText());
            Assert.assertTrue(tcs.pom.getPdpPage().footerPDPText.getText().contains("2019 Shoppers Drug Mart Inc."));
        }
    }

    @When("^I scroll down the page past the about this product and or ratings and reviews section$")
    public void I_scroll_down_the_page_past_the_about_this_product_and_or_ratings_and_reviews_section() {

    }
    @Then("^I want to see a product carousel that contains other recommended products The carousel should contain products related to the product I am viewing and I should be able to scroll through those products and view the product image brand product name price and any applicable promo information$")
    public void I_want_to_see_a_product_carousel_that_contains_other_recommended_products_The_carousel_should_contain_products_related_to_the_product_I_am_viewing_and_I_should_be_able_to_scroll_through_those_products_and_view_the_product_image_brand_product_name_price_and_any_applicable_promo_information(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.pom.getPdpPage().scrollDown();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().customerRecommendationHeader);
            Assert.assertEquals(tcs.pom.getPdpPage().customerRecommendationHeader.getText(),"Customers Also Viewed");
            Assert.assertTrue(tcs.pom.getPdpPage().validateCarousalProducts());
        }
    }

    @Given("^I am on a PDP for a Schedule 3 product$")
    public void I_am_on_a_PDP_for_a_Schedule_3_product() {}
    @When("^I click on Add to Bag$")
    public void I_click_on_Add_to_Bag() {}
    @Then("^I see a modal prompting me to talk to a pharmacist by calling a phone number or proceed with adding to bag$")
    public void I_see_a_modal_prompting_me_to_talk_to_a_pharmacist_by_calling_a_phone_number_or_proceed_with_adding_to_bag(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Schedule 3");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().addToBagBtn);
            tcs.pom.getPdpPage().addToBagBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().modalHeader);
            Log.info("modalHeader : " + tcs.pom.getPdpPage().modalHeader.getText());
            Assert.assertEquals(tcs.pom.getPdpPage().modalHeader.getText(), "Talk to a Pharmacist about this medication");
            Assert.assertTrue(tcs.pom.getPdpPage().pharmaNumber.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().pharmaCallBtn.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().modalAddToBagBtn.isDisplayed());
        }
    }


    @Given("^I am on a PDP for a Derm product$")
    public void I_am_on_a_PDP_for_a_Derm_product() {}
    @When("^I look under the Offers for this product panel$")
    public void I_look_under_the_Offers_for_this_product_panel() {}
    @Then("^I see a message to Get expert advice from the specialist team and there are two CTAs Ask a Question and Call 1 855 437 6243$")
    public void I_see_a_message_to_Get_expert_advice_from_the_specialist_team_and_there_are_two_CTAs_Ask_a_Question_and_Call_1_855_437_6243(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Derm");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().dermaDescription);
            Log.info("Description : " + tcs.pom.getPdpPage().dermaDescription.getText());
            Assert.assertEquals(tcs.pom.getPdpPage().dermaDescription.getText(),"Get expert advice from the specialist team");
            Assert.assertTrue(tcs.pom.getPdpPage().askQuestionBtn.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().callBtn.isDisplayed());
        }
    }


    @Given("that I am viewing item PDP which has multiple color swatches") //changes
    public void that_I_Am_Viewing_Item_PDP_Which_Has_Multiple_Color_Swatches() {}
    @When("the page is loaded")
    public void the_Page_Is_Loaded() {}
    @Then("all the color swatches should be displayed")
    public void all_The_Color_Swatches_Should_Be_Displayed() {
    }
    @And("the selected color should be highlighted")
    public void the_Selected_Color_Should_Be_High_lighted() {
    }
    @And("the selected color name should be displayed as selected in the dropdown")
    public void the_Selected_Color_Name_Should_Be_Displayed_As_Selected_In_The_Dropdown(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Colors");
            int sizeColor = tcs.pom.getPdpPage().getSizeOfElement(tcs.pom.getPdpPage().colorsList);
            Log.info("Number of colors : " + sizeColor);
            Assert.assertTrue(sizeColor>1);
            Assert.assertEquals(tcs.pom.getPdpPage().getSizeOfElement(tcs.pom.getPdpPage().colorSelected), 1);
            String colorName = tcs.pom.getPdpPage().getElementAttribute(tcs.pom.getPdpPage().colorSelected);
            Log.info("colorName : " + colorName);
            String dropdownColor = tcs.pom.getPdpPage().colorDropdownText.getText();
            Log.info("dropdownColor : " + dropdownColor);
            Assert.assertEquals(colorName, dropdownColor);
        }
    }

    @When("I click on a color swatch")
    public void i_Click_On_A_Color_Swatch() { }
    @Then("The selected color should be highlighted")
    public void The_selected_color_should_be_highlighted() {}
    @And("same color should be displayed in the dropdown as selected")
    public void same_color_should_be_displayed_in_the_dropdown_as_selected(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Colors");
            Assert.assertTrue(tcs.pom.getPdpPage().dropdownSelectColor());
        }
    }

    @When("I open the color dropdown")
    public void i_Open_The_Color_Dropdowns() {}
    @And("I select a color from the dropdown")
    public void i_Select_A_Color_From_The_Dropdown() {}
    @Then("The color should be selected in the pallet displayed above")
    public void The_Color_Should_Be_Selected_In_The_Pallet_Displayed_Above() {}
    @And("The image also should be changed")
    public void the_Image_Also_Should_Be_Changed(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Colors");
            Assert.assertTrue(tcs.pom.getPdpPage().dropdownSelectColor());
        }
    }


    @Given("that I am viewing item PDP which has single size")
    public void that_i_am_viewing_item_pdp_which_has_single_size() {}
    @Then("The size should be displayed correctly above the quantity section")
    public void the_size_should_be_displayed_correctly_above_the_quantity_section(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Single Size");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().sizeSingle);
            Assert.assertTrue(tcs.pom.getPdpPage().sizeSingle.getText().contains("Size"));
        }
    }


    @Given("that I am viewing item PDP which has multiple sizes")
    public void that_i_am_viewing_item_pdp_which_has_multiple_sizes() {}
    @Then("The sizes should be displayed correctly above the quantity section")
    public void the_sizes_should_be_displayed_correctly_above_the_quantity_section(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Multiple Size");
            int sizeCount = tcs.pom.getPdpPage().getSizeOfElement(tcs.pom.getPdpPage().sizeMultiple);
            Log.info("sizeCount : " + sizeCount);
            Assert.assertTrue(sizeCount>1);
            Assert.assertTrue(tcs.pom.getPdpPage().sizeSingle.getText().contains("Size"));
        }
    }


    @When("^I select the size$")
    public void I_select_the_size() {}
    @Then("^the selected size should be displayed correctly$")
    public void the_selected_size_should_be_displayed_correctly() {}
    @And("^price as per the selected size should be displayed$")
    public void price_as_per_the_selected_size_should_be_displayed(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Multiple Size");
            int sizeCount = tcs.pom.getPdpPage().getSizeOfElement(tcs.pom.getPdpPage().sizeMultiple);
            Log.info("sizeCount : " + sizeCount);
            Assert.assertTrue(sizeCount>1);
            Assert.assertTrue(tcs.pom.getPdpPage().sizeSingle.getText().contains("Size"));
            String sizeValue = tcs.pom.getPdpPage().checkSizeEnabled();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().sizeSingle);
            String sizeText = tcs.pom.getPdpPage().sizeSingle.getText();
            Log.info("sizeText : " + sizeText);
            Assert.assertTrue(sizeText.contains(sizeValue));
        }
    }

    @Given("That I am viewing item PDP which has multiple offers applicable")
    public void thatIAmViewingItemPDPWhichHasFreeSampleOffers() {}
    @Then("In the Offers for the product section, the description regarding offers should be displayed Different Offers should be tested")
    public void inTheOffersForTheProductSectionTheDescriptionRegardingFreeSampleShouldBeDisplayed(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Offers");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().offerHeading);
            Assert.assertTrue(tcs.pom.getPdpPage().offerHeading.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().offerHeading.getText(), "Offers for this Product");
            Assert.assertTrue(tcs.pom.getPdpPage().freeSamples.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().freeSamples.getText().contains("Free samples"));
            Assert.assertTrue(tcs.pom.getPdpPage().giftWithPurchase.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().giftWithPurchase.getText(), "Gift With Purchase");
            Assert.assertTrue(tcs.pom.getPdpPage().giftWithPurchaseDescription.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().freeSamplesDescription.isDisplayed());
        }
    }

    @When("I click on The Review click")
    public void i_Click_On_The_Review_Click() {}
    @Then("I should be anchored to the review section")
    public void i_Should_Be_Anchored_To_The_Review_Section(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Reviews");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().reviewBtn);
            tcs.pom.getPdpPage().reviewBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().powerReview);
            Assert.assertTrue(tcs.pom.getPdpPage().powerReview.isDisplayed());
        }
    }

    @Given("that I am Viewing PDP which does not have any Review")
    public void thatIAmViewingPDPWhichDoesNotHaveAnyReviewPDPLink() {}
    @Then("in the review section link Write the first review should be displayed and link should be clickable")
    public void inTheReviewSectionLinkWriteTheFirstReviewShouldBeDisplayedAndLinkShouldBeClickable(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "No Reviews");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().writeReviewBtn);
            Log.info("Write first review : " + tcs.pom.getPdpPage().writeReviewBtn.getText());
            Assert.assertEquals(tcs.pom.getPdpPage().writeReviewBtn.getText(), "Write the first review");
            tcs.pom.getPdpPage().writeReviewBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().writeReviewFormHeader);
            Assert.assertEquals(tcs.pom.getPdpPage().writeReviewFormHeader.getText(),"Write a Review");
            Assert.assertTrue(tcs.pom.getPdpPage().writeReviewFormRating.isDisplayed());
        }
    }


    @Given("^I am viewing an item PDP which has multiple reviews of different ratings$")
    public void iAmViewingAnItemPDPWhichHasMultipleReviewsOfDifferentRatings() {}
    @And("^one rating Ex 5 star rating is applied$")
    public void oneRatingEx5StarRatingIsApplied(){}
    @When("^I click on any other rating Example 4 start rating$")
    public void iClickOnAnyOtherRatingExample4StartRating() {}
    @Then("^Previous applied rating 5 star should be removed$")
    public void previousAppliedRating5StarShouldBeRemoved(){}
    @And("^New selected rating 4 star ratings should be displayed$")
    public void newSelectedRating4StarRatingsShouldBeDisplayed(DataReader dataReader) throws InterruptedException {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Reviews");
            tcs.pom.getPdpPage().clickOnRatingFilter("5 Stars");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().removeRatingFilter);
            Assert.assertTrue(tcs.pom.getPdpPage().removeRatingFilter.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().removeRatingFilter.getText(), "5 Stars");
            tcs.pom.getPdpPage().removeRatingBtn.click();
            Thread.sleep(3000);
            Assert.assertFalse(tcs.pom.getPdpPage().checkIfElementPresent(tcs.pom.getPdpPage().removeRatingFilterBy));
            tcs.pom.getPdpPage().clickOnRatingFilter("4 Stars");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().removeRatingFilter);
            Assert.assertTrue(tcs.pom.getPdpPage().removeRatingFilter.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().removeRatingFilter.getText(), "4 Stars");
        }
    }

    @Given("that I am Viewing PDP of an out of stock item")
    public void thatIAmViewingPDPOfAnOutOfStockItemPDPPage() {}
    @When("the page loaded")
    public void thePageIs_Loaded() {}
    @Then("the out of stock message should be displayed")
    public void theOutOfStockMessageShouldBeDisplayed() {}
    @And("sold out text should be displayed next to the size")
    public void soldOutTextShouldBeDisplayedNextToTheSize() {}
    @And("Add to bag CTA should be disabled")
    public void addToBagCTAShouldBeDisabled() {}
    @And("increase decrease qty buttons should be greyed out")
    public void increaseDecreaseQtyButtonsShouldBeGreyedOut(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Out of stock");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().outOfStockErrMsg);
            String oosErrMsg = tcs.pom.getPdpPage().outOfStockErrMsg.getText();
            Log.info("oosErrMsg : " + oosErrMsg);
            Assert.assertTrue(oosErrMsg.contains("We're sorry, this item is temporarily out of stock online. Please check back later"));
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().soldOutText);
            Assert.assertEquals(tcs.pom.getPdpPage().soldOutText.getText(), ("Out of stock online"));
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().addToBagBtn);
            Assert.assertTrue(tcs.pom.getPdpPage().addToBagBtn.getAttribute("class").contains("--disabled__3xlI5"));
            Assert.assertTrue(tcs.pom.getPdpPage().decreaseQuantityDisabled.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().increaseQuantityDisabled.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().decreaseQuantityDisabled.getAttribute("aria-disabled"), "true");
            Assert.assertEquals(tcs.pom.getPdpPage().increaseQuantityDisabled.getAttribute("aria-disabled"), "true");
        }
    }


    @Given("^That I am viewing item PDP$")
    public void thatIAmViewingItemPDP() {}
    @When("^I click on item displayed in the recommended section$")
    public void iClickOnItemDisplayedInTheRecommendedSection() {}
    @Then("^The item PDP should be displayed$")
    public void theItemPDPShouldBeDisplayed(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().recommendSectionHeader);
            Assert.assertEquals(tcs.pom.getPdpPage().recommendSectionHeader.getText(), "Customers Also Viewed");
            String recommendedProductName = tcs.pom.getPdpPage().clickRecommendedProduct();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().productNameHeader);
            String productNameHead = tcs.pom.getPdpPage().productNameHeader.getText();
            Log.info("productNameHead : " + productNameHead);
            Assert.assertEquals(recommendedProductName, productNameHead);
        }
    }


    @Then("the item images provided in customer reviews are displayed below the recommended section")
    public void theItemImagesProvidedInCustomerReviewsAreDisplayedBelowTheRecommendedSection(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Review Images");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().reviewImagesSection);
            Assert.assertTrue(tcs.pom.getPdpPage().reviewImagesSection.isDisplayed());
            String followingSiblingId = tcs.pom.getPdpPage().reviewImagesSection.getAttribute("id");
            Assert.assertEquals(followingSiblingId, "pr-reviewdisplay");
        }
    }


    @Given("that for a particular product I have 6 qty in my cart")
    public void thatForAParticularProductIHaveQtyInMyCartPDPPage() {}
    @When("I click on Add to bag from PDP")
    public void iClickOnAddToBagFromPDP() {
    }
    @Then("the error is displayed of max limit")
    public void theErrorIsDisplayedOfMaxLimit() {
    }
    @And("product should not be added to cart")
    public void productShouldNotBeAddedToCart(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "ProductId");
            tcs.pom.getPdpPage().increaseQuantity(5);
            tcs.pom.getPdpPage().addToBagBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().addToBagModal);
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().continueShoppingBtn);
            tcs.pom.getPdpPage().continueShoppingBtn.click();
            int bagCount = tcs.pom.getPdpPage().getBagCount();
            Assert.assertEquals(bagCount, 6);
            tcs.pom.getPdpPage().addToBagBtn.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().maxQuantityErr);
            String maxQuantityError = tcs.pom.getPdpPage().maxQuantityErr.getText();
            Log.info("maxQuantityError : " + maxQuantityError);
            Assert.assertEquals(maxQuantityError, "You can add up to 6 of this item to your bag, you've reached the limit");
        }
    }


    @When("I click on item image displayed in the Review section")
    public void iClickOnItemImageDisplayedInTheReviewSection() {}
    @Then("the review modal is displayed with the review comments.")
    public void theReviewModalIsDisplayedWithTheReviewComments(DataReader dataReader) throws InterruptedException {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Review Images");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().reviewImagesSection);
            Assert.assertTrue(tcs.pom.getPdpPage().reviewImagesSection.isDisplayed());
            tcs.pom.getPdpPage().clickReviewImage();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().reviewModal);
            Assert.assertTrue(tcs.pom.getPdpPage().validateReviewModalText());
            tcs.pom.getPdpPage().reviewModalClose.click();
        }
    }


    @When("^I click on the 5 star rating in review section$")
    public void iClickOnTheStarRatingInReviewSection(){}
    @Then("^The filter bar of 5 star is displayed$")
    public void theFilterBarOfStarIsDisplayed()  {}
    @And("^Reviews which has rating of 5 star should be displayed")
    public void reviewsWhichHasRatingOfStarShouldBeDisplayed() {}
    @And("Total count of reviews should be updated")
    public void totalCountOfReviewsShouldBeUpdated(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Reviews");
            int totalReviewBefore = tcs.pom.getPdpPage().getTotalReview();
            tcs.pom.getPdpPage().clickOnRatingFilter("5 Stars");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().removeRatingFilter);
            Assert.assertTrue(tcs.pom.getPdpPage().removeRatingFilter.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().removeRatingFilter.getText(), "5 Stars");
            Assert.assertTrue(tcs.pom.getPdpPage().checkRatingValue("5"));
            int totalReviewAfter = Integer.parseInt(tcs.pom.getPdpPage().reviewTotal.getText().trim().split(" ")[0].trim());
            Log.info("totalReviewBefore : " + totalReviewBefore + " :: " + "totalReviewAfter : " + totalReviewAfter);
            Assert.assertTrue(totalReviewBefore>totalReviewAfter);
        }
    }


    @Given("that I am viewing item PDP which has multiple colour swatches")
    public void that_i_am_viewing_item_pdp_which_has_multiple_colour_swatches() {
    }
    @When("I click on a colour swatch")
    public void i_click_on_a_colour_swatch() {}
    @Then("Image image of the selected colour should be displayed")
    public void image_image_of_the_selected_colour_should_be_displayed(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Colors");
            int sizeColor = tcs.pom.getPdpPage().getSizeOfElement(tcs.pom.getPdpPage().colorsList);
            Log.info("Number of colors : " + sizeColor);
            Assert.assertTrue(sizeColor>1);
            String imgLinkBeforeChange = tcs.pom.getPdpPage().getImageLink();
            tcs.pom.getPdpPage().selectRandomColor();
            String imgLinkAfterChange = tcs.pom.getPdpPage().getImageLink();
            Assert.assertNotEquals(imgLinkBeforeChange, imgLinkAfterChange);
        }
    }


    @Then("all the colours should be displayed in the ascending order of the colour number")
    public void all_the_colours_should_be_displayed_in_the_ascending_order_of_the_colour_number() {}
    @Then("selected colour should have a tick mark against it")
    public void selected_colour_should_have_a_tick_mark_against_it() {}
    @Then("sold out colour should have sold out text against it")
    public void sold_out_colour_should_have_sold_out_text_against_it(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Out Of Stock Color");
            Assert.assertTrue(tcs.pom.getPdpPage().dropdownCheck());
            Assert.assertTrue(tcs.pom.getPdpPage().checkColorTick());
            Assert.assertTrue(tcs.pom.getPdpPage().checkColorOOS());
        }
    }


    @Then("The sold out color should be crossed out in the color pallet displayed")
    public void theSoldOutColorShouldBeCrossedOutInTheColorPalletDisplayed(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Out Of Stock Color");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().outOfStockButton);
            Assert.assertTrue(tcs.pom.getPdpPage().outOfStockButton.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().outOfStockButton.isEnabled());
            tcs.pom.getPdpPage().outOfStockButton.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().soldOutText);
            String oosText = tcs.pom.getPdpPage().soldOutText.getText();
            Log.info("oosText : " + oosText);
            Assert.assertEquals(oosText, "Out of stock online");
        }
    }


    @When("I click on the sold out color swatch")
    public void i_click_on_the_sold_out_color_swatch() {}
    @Then("the sold out message should be displayed")
    public void the_sold_out_message_should_be_displayed() {}
    @Then("the increase decrease quantity button should be disabled")
    public void the_increase_decrease_quantity_button_should_be_disabled() {}
    @Then("Add to Bag button should be disabled")
    public void add_to_bag_button_should_be_disabled(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Out Of Stock Color");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().outOfStockButton);
            Assert.assertTrue(tcs.pom.getPdpPage().outOfStockButton.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().outOfStockButton.isEnabled());
            tcs.pom.getPdpPage().outOfStockButton.click();
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().outOfStockErrMsg);
            String oosText = tcs.pom.getPdpPage().outOfStockErrMsg.getText();
            Log.info("oosText : " + oosText);
            Assert.assertTrue(oosText.contains("We're sorry, this item is temporarily out of stock online. Please check back later"));
            Assert.assertTrue(tcs.pom.getPdpPage().addToBagBtn.getAttribute("class").contains("--disabled__3xlI5"));
            Assert.assertTrue(tcs.pom.getPdpPage().decreaseQuantityDisabled.isDisplayed());
            Assert.assertTrue(tcs.pom.getPdpPage().increaseQuantityDisabled.isDisplayed());
            Assert.assertEquals(tcs.pom.getPdpPage().decreaseQuantityDisabled.getAttribute("aria-disabled"), "true");
            Assert.assertEquals(tcs.pom.getPdpPage().increaseQuantityDisabled.getAttribute("aria-disabled"), "true");
        }
    }

    @Given("I am viewing item PDP for which free shipping is provided$")
    public void i_am_viewing_item_PDP_for_which_free_shipping_is_provided(){}
    @Then("The Free shipping text should be displayed between the price and PCO text$")
    public void theFreeShippingTextShouldBeDisplayedBetweenThePriceAndPCOText(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Free Shipping");
            tcs.common.addExplicitWait(tcs.pom.getPdpPage().freeShippingText);
            Assert.assertTrue(tcs.pom.getPdpPage().freeShippingText.isDisplayed());
            String freeShippingMsg = tcs.pom.getPdpPage().freeShippingText.getText();
            Log.info("freeShippingMsg : " + freeShippingMsg);
            Assert.assertEquals(freeShippingMsg, "Free Shipping");
        }
    }


    @Given("I am viewing PDP which has multiple reviews of different ratings")
    public void iAmViewingPDPWhichHasMultipleReviewsOfDifferentRatings() {}
    @When("I click all the options")
    public void iClickAllTheOptions() {}
    @Then("The Reviews should be displayed as per the selected sort option")
    public void theReviewsShouldBeDisplayedAsPerTheSelectedSortOption(DataReader dataReader) {
        List<Map<String, String>> excelRows = dataReader.getAllRows();
        for (Map<String, String> excelRow : excelRows) {
            tcs.pom.getPdpPage().openProduct(excelRow, "Review Images");
            Assert.assertTrue(tcs.pom.getPdpPage().validateSortFilters());
        }
    }
}
