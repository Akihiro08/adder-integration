package com.hyridia.adder.serenity.stories;

import com.hyridia.adder.serenity.steps.AdderSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AdderAccumulationStory {
    @Steps
    AdderSteps adderSteps;

    @Given("a number")
    public void givenANumber(){
        adderSteps.initialize_connection_given_base(10);
    }

    @When("I submit another number to adder for accumulation")
    public void whenIDoAccumulation(){
        adderSteps.whenAccumulate(10);
    }

    @Then("I get a sum of the numbers and the accumulation is on server")
    public void thenGetSumAndAccumulationIsOnServer()
    {
        adderSteps.accumulationDone();
    }
}
