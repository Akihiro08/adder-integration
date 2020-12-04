package com.hyridia.adder.steps.jbehave;

import com.hyridia.adder.steps.serenity.AdderSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AdderAddStory {
    @Steps
    AdderSteps adderSteps;

    @Given("the user set the base number")
    public void givenTheUserSetTheBaseNumberEndAdder()
    {
        adderSteps.initialize_connection_given_base_and_adder(10, 20);
    }

    @When("the user get the result")
    public void whenTheUserGetTheResult() {
        adderSteps.whenAdd();
    }

    @Then("it should be the sum of the two first numbers")
    public void thenItShouldBeTheSum() {
        adderSteps.summedUp();
    }
}
