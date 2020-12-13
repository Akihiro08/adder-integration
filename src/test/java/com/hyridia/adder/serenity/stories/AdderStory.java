package com.hyridia.adder.serenity.stories;

import com.hyridia.adder.serenity.steps.AdderSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AdderStory {

    @Steps
    AdderSteps adderSteps;

    @Given("a number")
    public void givenANumber()
    {
        adderSteps.initialize_connection_given_base(10);
    }

    @When("I submit another number 5 to adder")
    public void whenTheUserGetTheResult() {
        adderSteps.whenAdd(20);
    }

    @Then("I get a sum of the numbers")
    public void thenItShouldBeTheSum() {
        adderSteps.summedUp();
    }
}
