package com.hyridia.adder.serenity;


import com.hyridia.adder.serenity.steps.AdderSteps;
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
        adderSteps.initialize_connection_given_base(0);
        adderSteps.whenAdd(10);
        adderSteps.summedUp();
    }

    @Test
    public void accumulate_number(){
        adderSteps.initialize_connection_given_base(10);
        adderSteps.whenAccumulate(10);
        adderSteps.accumulationDone();
    }

    @Test
    public void accumulate_number_with_sum_verification(){
        adderSteps.initialize_connection_given_base(10);
        adderSteps.whenAccumulate(30);
        adderSteps.sumWrong();
    }

}