import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;


public class SimpletestTest extends AbstractTestNGCucumberTests {
    private Simpletest calc ;

    double a;
    double b;
    double result;

    @Given("^two numbers (-{0,1}\\d) and (-{0,1}\\d)")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        this.calc = new Simpletest();
    }

    @When("^we try to find sum of our numbers")
    public void when() {
        result = calc.sum(a, b);
    }

    @Then("^result should be (-{0,1}\\d)")
    public void then(double res) {
        Assert.assertEquals(res, result, 0.0001);
    }
}