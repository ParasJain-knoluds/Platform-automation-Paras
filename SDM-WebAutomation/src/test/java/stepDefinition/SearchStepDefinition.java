package stepDefinition;

import ddtConfig.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.Common;
import util.TestContextSetup;

import java.util.ArrayList;
import java.util.List;


public class SearchStepDefinition {

    TestContextSetup tcs;

    public SearchStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("I search a specific brand or badge \\\\(thoughtful choices)")
    public void given_i_search_a_specific_brand_or_badge_thoughtful_choices(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);


    }

    @When("I hit enter")
    public void when_i_hit_enter() {
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().clickSearchButton);
        tcs.pom.getSearchPage().clickSearchButton.submit();

    }

    @Then("It should take me to the specific brand PLP I searched")
    public void it_should_take_me_to_the_specific_brand_plp_i_searched(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "SearchBrandName");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().brandPlpPage);
        Assert.assertTrue(tcs.pom.getSearchPage().brandPlpPage.isDisplayed());
        boolean brand = false;
        for (WebElement brandNamePlp : tcs.pom.getSearchPage().getBrandName()) {
            String brandValue = brandNamePlp.getText().trim();
            if (brandValue.contains(brandName)) {
                Assert.assertTrue(brandValue.contains(brandName));
                brand = true;
                break;

            }

        }
        Assert.assertTrue(brand);

    }

    @Given("a search query is made")
    public void a_search_query_is_made(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "Product");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);

    }

    @When("the query is specific to a category or colour")
    public void when_the_query_is_specific_to_a_category_colour_e_g_pink_lipstick() {
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().clickSearchButton);
        tcs.pom.getSearchPage().clickSearchButton.submit();

    }

    @Then("correct product matching the term should be displayed")
    public void correct_product_matching_the_term_should_be_displayed(DataReader dataReader) {
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().brandPlpPage);
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().productSearch);
        String product = Common.dataExtractorFromSheet(dataReader, "Product");
        String productVariant = tcs.pom.getSearchPage().productSearch.getText().split(" \"")[1];
        Assert.assertTrue(productVariant.contains(product));


    }

    @Given("a search query is made - oos and stock")
    public void a_search_query_is_made_oos_stock(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "Product");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().clickSearchButton);
        tcs.pom.getSearchPage().clickSearchButton.submit();
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().productToHover);
        tcs.pom.getSearchPage().productToHover.click();

    }

    @When("the variant for the query is out of stock")
    public void the_variant_for_the_query_is_out_of_stock() {
        Assert.assertTrue(tcs.pom.getSearchPage().ModelElementPage.isDisplayed());
        boolean color = false;
        Assert.assertTrue(tcs.pom.getSearchPage().getColorName().size() > 1);
        for (WebElement brandColor : tcs.pom.getSearchPage().getColorName()) {
            String attributeName = brandColor.getAttribute("aria-label");
            if (attributeName.contains("Sold out")) {
                Assert.assertTrue(attributeName.contains("Sold out"));
                color = true;
                break;

            }

        }
        Assert.assertTrue(color);


    }

    @When("Other variants of the product are in stock")
    public void other_variants_of_the_product_are_in_stock() {
        List<String> results = new ArrayList<String>();
        for (WebElement brandColor : tcs.pom.getSearchPage().getColorName()) {
            String attributeName = brandColor.getAttribute("aria-label");
            if (!attributeName.equals("Sold out")) {
                results.add(attributeName);
            }
        }
        Assert.assertFalse(results.isEmpty());

    }

    @Then("the relevant variant should be displayed with an OOS badge")
    public void the_relevant_variant_should_be_displayed_with_an_oos_badge(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "Product");
        boolean color = false;
        for (WebElement brandColor : tcs.pom.getSearchPage().getColorName()) {
            String attributeName = brandColor.getAttribute("aria-label");
            if (attributeName.contains("Sold out")) {
                Assert.assertTrue(attributeName.contains("Sold out"));
                if (attributeName.contains(brandName.split(" ")[0])) {
                    Assert.assertTrue(attributeName.contains(brandName.split(" ")[0]));
                    color = true;
                    break;
                } else {
                    continue;
                }

            }

        }
        Assert.assertTrue(color);


    }

    @Given("a search query is made - special character")
    public void a_search_query_is_made_special_character(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "SpecialCharacter Product");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().clickSearchButton);
        tcs.pom.getSearchPage().clickSearchButton.submit();
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().productToHover);


    }

    @When("When the keyword has a special character")
    public void when_the_keyword_has_a_special_character() {

    }

    @Then("the correct products matching the search term should be displayed")
    public void the_correct_products_matching_the_search_term_should_be_displayed(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "SpecialCharacter Product");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().brandPlpPage);
        Assert.assertTrue(tcs.pom.getSearchPage().brandPlpPage.isDisplayed());
        boolean brand = false;
        for (WebElement brandNamePlp : tcs.pom.getSearchPage().getBrandName()) {
            String brandValue = brandNamePlp.getText().trim();
            if (brandValue.contains(brandName)) {
                Assert.assertTrue(brandValue.contains(brandName));
                brand = true;
                break;

            }

        }
        Assert.assertTrue(brand);
    }

    @Given("Given I search a term not found")
    public void given_i_search_a_term_not_found(DataReader dataReader) {
        String brandName = Common.dataExtractorFromSheet(dataReader, "NotFound Product");
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().searchTextField);
        tcs.pom.getSearchPage().searchTextField.sendKeys(brandName);

    }

    @Then("It should take me to a blank plp breadcrumbed as Shop: [search term] informing me that 0 results are found")
    public void it_should_take_me_to_a_blank_plp_breadcrumbed_as_shop_search_term_informing_me_that_results_are_found(DataReader dataReader) {
        tcs.common.addExplicitWait(tcs.pom.getSearchPage().NotFoundProduct);
        String brandName = Common.dataExtractorFromSheet(dataReader, "NotFound Product");
        String expected = "0 results for \"" + brandName + "\"";
        Assert.assertEquals(tcs.pom.getSearchPage().NotFoundProduct.getText(), expected);
    }

}
