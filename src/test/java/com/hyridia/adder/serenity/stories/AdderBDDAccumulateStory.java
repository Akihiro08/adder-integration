package com.hyridia.adder.serenity.stories;

import com.hyridia.adder.pages.HtmlElements;
import com.hyridia.adder.serenity.steps.AdderBDDSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdderBDDAccumulateStory {

    private int number = 12;
    private int base = 24;

    @Steps
    AdderBDDSteps adderSteps;


    @Given("a number for base and a number to accumulate")
    public void givenANumber()
    {
        adderSteps.is_on_adder_page();
        adderSteps.entersOn(HtmlElements.SETBASE_INPUT, base);
        adderSteps.clickOn(HtmlElements.SETBASE_BUTTON);
        adderSteps.entersOn(HtmlElements.ACCU_INPUT, number);
    }

    @When("I click on accumulate button")
    public void clickOnAccumulateButton() {
        adderSteps.clickOn(HtmlElements.ACCU_BUTTON);
    }

    @Then("I get a sum of the numbers and the accumulation")
    public void getResultAndAccumulation() {
        adderSteps.should_see_current_and_result();
        adderSteps.should_accumulate(number+base);
    }
}
