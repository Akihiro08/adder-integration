package com.hyridia.adder.junit;


import com.hyridia.adder.controller.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AdderApplicationTests {

    @Autowired
    private AdderController controller;

    private TestRestTemplate restTemplate = new TestRestTemplate();;
    private final String url = "http://localhost:8080";

    @BeforeEach
    void setUp() {
        String json = this.restTemplate.postForObject(url+"/adder/base?num=0", "", String.class);
        System.out.println(json);
    }

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void testCurrentNumber()
    {
        assertThat(this.restTemplate.getForObject(url+"/adder/current", Integer.class)).isZero();
    }

    @Test
    void testAccumulate()
    {
        int num = 12;
        assertThat(this.restTemplate.postForObject(url+"/adder/accumulate?num="+12, "", Integer.class)).isEqualTo(num);
        this.restTemplate.postForObject(url+"/adder/base?num=10", "", String.class);
        assertThat(this.restTemplate.postForObject(url+"/adder/accumulate?num="+12, "", Integer.class)).isEqualTo(22);
    }

    @Test
    void testBaseNum()
    {
        int num = 133;
        this.restTemplate.postForObject(url+"/adder/base?num="+num, "", String.class);
        assertThat(this.restTemplate.getForObject(url+"/adder/current", Integer.class)).isEqualTo(num);
    }

    @Test
    void testBaseNumJson()
    {
        int num = 133;
        String json = this.restTemplate.postForObject(url+"/adder/base?num="+num, "", String.class);
        assertThat(json).contains("Ok");
    }

    @Test
    void testAdd()
    {
        int num = 13;
        int add = 12;
        //Vérifie l'addition
        assertThat(this.restTemplate.postForObject(url+"/adder?num="+num, "", Integer.class)).isEqualTo(num);
        //Verifie que la valeur de base est toujours égale à 0
        assertThat(this.restTemplate.getForObject(url+"/adder/current", Integer.class)).isZero();
        this.restTemplate.postForObject(url+"/adder/accumulate?num="+12, "", Integer.class);
        assertThat(this.restTemplate.postForObject(url+"/adder?num="+13,"", Integer.class)).isEqualTo(num+add);
    }

    @Test
    void testRandom()
    {
        for(int i=0; i < 100; i++){
            assertThat(this.restTemplate.getForObject(url+"/adder/random", Integer.class)).isNotNegative();
        }
    }
}
