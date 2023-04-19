package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.TestContextSetup;

public class MyStepdefs {
    TestContextSetup tcs;
    public MyStepdefs(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("Abc")
    public void abc() {

    }

    @When("Def")
    public void def() {
    }

    @Then("Ghi")
    public void ghi() {
        Assert.assertTrue(tcs.pom.getHomePage().validateHomePage());
    }

}
