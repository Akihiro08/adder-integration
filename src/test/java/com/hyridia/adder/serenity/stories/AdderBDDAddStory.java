package com.hyridia.adder.serenity.stories;

import com.hyridia.adder.pages.HtmlElements;
import com.hyridia.adder.serenity.steps.AdderBDDSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AdderBDDAddStory {

    private int add = 10;

    @Steps
    AdderBDDSteps adderSteps;

    @Given("a number to add")
    public void givenANumber()
    {
        adderSteps.is_on_adder_page();
        adderSteps.entersOn(HtmlElements.ADD_INPUT, add);
    }

    @When("I click on add button")
    public void clickOnSetBaseButton() {
        adderSteps.clickOn(HtmlElements.ADD_BUTTON);
    }

    @Then("I get the result of the sum")
    public void getBase() {
        adderSteps.should_see_addition(add);
    }
}
