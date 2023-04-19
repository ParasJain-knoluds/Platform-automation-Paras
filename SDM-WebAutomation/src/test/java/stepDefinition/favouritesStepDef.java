package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.TestContextSetup;

import java.util.List;

public class favouritesStepDef {
    TestContextSetup tcs;

    public favouritesStepDef(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Given("a user is viewing a product tile of a product that has multiple colour assortments")
    public void a_user_is_viewing_a_product_tile_of_a_product_that_has_multiple_colour_assortments() {
        tcs.pom.getfav().viewPLPPage();
    }
    @When("the page is Loaded")
    public void the_Page_Is_Loaded() {}

    @Then("they Do NOT see the number of colour variations listed in the product tile info")
    public void they_do_not_see_the_number_of_colour_variations_listed_in_the_product_tile_info() {
        List<WebElement> elements = tcs.pom.getfav().findColour();
        Assert.assertTrue(elements.isEmpty(), "Element is present on the page");
    }


    @Given("I am on the favourites page")
    public void iAmOnTheFavouritesPage() {
     tcs.pom.getfav().VerifyFavouritesPage();
    }

    @When("I unfavourite an item")
    public void iUnfavouriteAnItem() {

    }

    @Then("The item is removed from my favourite list")
    public void theItemIsRemovedFromMyFavouriteList() {

    }
}
