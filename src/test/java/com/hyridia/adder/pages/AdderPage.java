package com.hyridia.adder.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.*;

@DefaultUrl("http://localhost:4200")
public class AdderPage extends PageObject {
    @FindBy(id = "random-button")
    private WebElementFacade randomButton;

    @FindBy(id = "setbase-button")
    private WebElementFacade setbaseButton;

    @FindBy(id = "add-button")
    private WebElementFacade addButton;

    @FindBy(id = "accu-button")
    private WebElementFacade accuButton;

    @FindBy(id = "setbase-input")
    private WebElementFacade setbaseInput;

    @FindBy(id = "add-input")
    private WebElementFacade addInput;

    @FindBy(id = "accu-input")
    private WebElementFacade accuInput;

    public void enter_number(HtmlElements elements, int number) {
        switch (elements) {
            case ADD_INPUT:
                addInput.type(Integer.toString(number));
                break;
            case ACCU_INPUT:
                accuInput.type(Integer.toString(number));
                break;
            case SETBASE_INPUT:
                setbaseInput.type(Integer.toString(number));
                break;
        }
    }

    public void click_button(HtmlElements elements) {
        switch (elements) {
            case ADD_BUTTON:
                addButton.click();
                break;
            case ACCU_BUTTON:
                accuButton.click();
                break;
            case RANDOM_BUTTON:
                randomButton.click();
                break;
            case SETBASE_BUTTON:
                setbaseButton.click();
                break;
        }
    }

    public Map<String, Integer> getResults() {
        Map<String, Integer> numbers = new HashMap<>();
        WebElementFacade current = find(By.id("current"));
        WebElementFacade result = find(By.id("result"));
        numbers.put("current", Integer.parseInt(current.getValue()));
        numbers.put("result", Integer.parseInt(result.getValue()));
        return numbers;
    }

    public int getRandom() {
        WebElementFacade random = find(By.id("random"));
        return Integer.parseInt(random.getValue());
    }
}
