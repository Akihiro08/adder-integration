package com.hyridia.adder;

import com.hyridia.adder.steps.AdderSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AdderSerenityTest {

    @Steps
    AdderSteps adderSteps;

    @Test
    public void add_number(){
        adderSteps.initialize_connection_given_base_and_adder(0, 10);
        adderSteps.whenAdd();
        adderSteps.summedUp();
    }

    @Test
    public void accumulate_number(){
        adderSteps.initialize_connection_given_base_and_adder(10,30);
        adderSteps.whenAccumulate();
        adderSteps.accumulationDone();
    }

    @Test
    public void accumulate_number_with_sum_verification(){
        adderSteps.initialize_connection_given_base_and_adder(10,30);
        adderSteps.whenAccumulate();
        adderSteps.sumWrong();
    }

}
