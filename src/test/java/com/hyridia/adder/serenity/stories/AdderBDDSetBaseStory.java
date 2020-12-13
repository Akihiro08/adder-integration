package com.hyridia.adder.serenity.stories;

import com.hyridia.adder.pages.HtmlElements;
import com.hyridia.adder.serenity.steps.AdderBDDSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AdderBDDSetBaseStory {

    private int base = 10;

    @Steps
    AdderBDDSteps adderSteps;

    @Given("a number for base")
    public void givenANumber()
    {
        adderSteps.is_on_adder_page();
        adderSteps.entersOn(HtmlElements.SETBASE_INPUT, base);
    }

    @When("I click on setbase button")
    public void clickOnSetBaseButton() {
        adderSteps.clickOn(HtmlElements.SETBASE_BUTTON);
    }

    @Then("I get the result of my action")
    public void getBase() {
        adderSteps.should_see_current(base);
    }
}
