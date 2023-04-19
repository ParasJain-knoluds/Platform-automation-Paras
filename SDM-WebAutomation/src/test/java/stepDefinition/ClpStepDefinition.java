package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.TestContextSetup;


public class ClpStepDefinition {

    TestContextSetup tcs;

    public ClpStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }


    @Given("I am viewing the CLP Beauty or Holiday Home")
    public void i_am_viewing_the_clp_beauty_or_holiday_home() {
        tcs.pom.getClp().iViewCLPBeauty();
    }

    @When("the page loads")
    public void the_page_loads() {
        tcs.pom.getClp().clickCLPBeauty();
    }

    @Then("I can see the Hero Banner of rotating offers on top of page")
    public void i_can_see_the_hero_banner_of_rotating_offers_on_top_of_page() {
        tcs.pom.getClp().iViewCLPBanner();
    }

    @Given("I am viewing the CLP")
    public void i_am_viewing_the_clp() {
        tcs.pom.getClp().iViewCLPCategory();
    }

    @Then("I can see the shop by category links")
    public void i_can_see_the_shop_by_category_links() {
        tcs.pom.getClp().iViewCLPShopByCategory();
    }

    @Then("I can see the recommended for you carousel")
    public void i_can_see_the_recommended_for_you_carousel() {
        tcs.pom.getClp().iViewCLPRecommendedForYouCategroy();
    }

    @Then("I can see the New & Trending carousel")
    public void i_can_see_the_new_trending_carousel() {
        tcs.pom.getClp().iViewCLPNewAndTrending();
    }

    @Then("I can see the carousel for current events")
    public void i_can_see_the_carousel_for_current_events() {
        tcs.pom.getClp().iViewCLPBanner();
    }

    @Then("I can view the current features, each with a shop now button")
    public void i_can_view_the_current_features_each_with_a_shop_now_button() {
        tcs.pom.getClp().iViewCLPFeature();
        tcs.pom.getClp().verifyShopNowInBrandSlider();
    }

    @Given("I am viewing the CLP, specifically the features carousel")
    public void i_am_viewing_the_clp_specifically_the_features_carousel() {
        tcs.pom.getClp().iViewCLPFeature();
    }

    @When("clicking the shop now button")
    public void clicking_the_shop_now_button() {
        tcs.pom.getClp().clickClpFeatureShopBy();
    }

    @Then("Takes me to resulting PLP")
    public void takesMeToResultingPLP() {
        tcs.pom.getClp().iAmOnCLPPage();
    }

    @Then("I can view the promotional carousel \\(Quo Beauty Kit {int})")
    public void i_can_view_the_promotional_carousel_quo_beauty_kit(Integer int1) {
        tcs.pom.getClp().iViewCLPBanner();
    }
}
