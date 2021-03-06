package com.hyridia.adder.serenity.steps;

import com.hyridia.adder.controller.AdderController;
import net.thucydides.core.annotations.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdderSteps {

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private final String url = "http://localhost:8080";

    private int givenNumber;
    private int base;
    private int sum;



    @Step
    public void initialize_connection_given_base(int base){
        this.restTemplate.postForObject(url+"/adder/base?num="+base, "", String.class);
        this.base = base;
        this.givenNumber = 0;
    }

    @Step
    public void whenAdd(int number) {
        this.givenNumber = number;
        sum = this.restTemplate.postForObject(url+"/adder?num="+givenNumber, "", Integer.class);
    }

    @Step
    public void summedUp() {
        assertEquals(base + givenNumber, sum);
    }

    @Step
    public void sumWrong() {
        assertNotEquals(base + givenNumber, sum);
    }

    @Step
    public void accumulationDone() {
        assertEquals(sum, base);
    }

    @Step
    public void whenAccumulate(int number) {
        this.givenNumber = number;
        sum = this.restTemplate.postForObject(url+"/adder/accumulate?num="+givenNumber, "", Integer.class);
        base = this.restTemplate.getForObject(url+"/adder/current", Integer.class);
    }
}
