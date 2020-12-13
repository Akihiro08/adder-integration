package com.hyridia.adder.serenity.steps;

import com.hyridia.adder.pages.AdderPage;
import com.hyridia.adder.pages.HtmlElements;
import net.thucydides.core.annotations.Step;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdderBDDSteps {
    AdderPage adderPage;

    @Step
    public void entersOn(HtmlElements elements, int number) {
        adderPage.enter_number(elements, number);
    }

    @Step
    public void clickOn(HtmlElements elements) {
        adderPage.click_button(elements);
    }

    @Step
    public void is_on_adder_page() {
        adderPage.open();
    }

    @Step
    public void should_see_addition(int add) {
        assertThat(adderPage.getResults()).containsKey("result").containsValue(adderPage.getResults().get("current")+add);
    }

    @Step
    public void should_see_current(int current) {
        assertThat(adderPage.getResults()).containsKey("current").containsValue(current);
    }

    @Step
    public void should_see_current_and_result() {
        assertThat(adderPage.getResults()).containsKeys("result", "current");
    }

    @Step
    public void should_accumulate(int accumulation) {
        assertThat(adderPage.getResults().values()).allSatisfy(number -> {
            assertThat(number).isEqualTo(accumulation);
        });
    }
}
