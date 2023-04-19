package stepDefinition;

import ddtConfig.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.Common;
import util.TestContextSetup;


public class QuickViewStepDefinition {
    TestContextSetup tcs;

    public QuickViewStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }


    @Given("I open up the quick view")
    public void i_open_up_the_quick_view_o(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "Product");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().clickSearchButton);
        tcs.pom.getSearchPage().clickSearchButton.submit();
        tcs.pom.getQuickView().clickOnRandomProduct();
        Assert.assertTrue(tcs.pom.getQuickView().validateQuickViewButton());

    }


    @When("I inspect the quick view")
    public void i_inspect_the_quick_view() {
        Assert.assertTrue(tcs.pom.getQuickView().validateQuickView());

    }

    @Then("I can see the product brand")
    public void i_can_see_the_product_brand() {
        Assert.assertTrue(tcs.pom.getQuickView().validateBrandName());
    }

    @Then("I can see the product name")
    public void i_can_see_the_product_name() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductName());

    }

    @Then("I can see the quantity")
    public void i_can_see_the_quantity() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductQuantity());
    }

    @Then("I can see the rating option")
    public void i_can_see_the_rating_option() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductRating());

    }

    @Then("I can see the offer sale price")
    public void i_can_see_the_offer_sale_price() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductPrice());
    }

    @Then("I can see the PC optimum offers")
    public void i_can_see_the_pc_optimum_offers() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductPCOffers());

    }

    @Then("I can see the PC optimum amount for purchase")
    public void i_can_see_the_pc_optimum_amount_for_purchase() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductPrice());


    }

    @Then("Indicates the size or colour if applicable")
    public void indicates_the_size_or_colour_if_applicable() {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductSize());

    }


    @When("I click Show Product Details")
    public void i_click_show_product_details() {
        Assert.assertTrue(tcs.pom.getQuickView().validateShowProductDetails());

    }

    @Then("Takes me to the correct PDP")
    public void takes_me_to_the_correct_pdp() {
        String product_name = tcs.pom.getQuickView().productname.getText();
        tcs.pom.getQuickView().productdetails.click();
        Assert.assertTrue(tcs.pom.getQuickView().validatePdp());
        Assert.assertEquals(tcs.pom.getQuickView().validateproductname.getText(), product_name);
    }

    @Then("I can see the Favourite button")
    public void i_can_see_the_favourite_button() {
        Assert.assertTrue(tcs.pom.getQuickView().validateFavouriteButton());

    }

    @Then("I can see the product image and under the image I should see show product details which on accessing takes me to PDP")
    public void i_can_see_the_product_image_and_under_the_image_i_should_see_show_product_details_which_on_accessing_takes_me_to_pdp() throws InterruptedException {
        Assert.assertTrue(tcs.pom.getQuickView().validateProductImage());
        i_click_show_product_details();
        takes_me_to_the_correct_pdp();
    }

}
