package com.hyridia.adder.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdderService {
    private int num;
    public void baseNum(int base) {
        this.num = base;
    }
    public int currentBase() {
        return num;
    }
    public int add(int adder) {
        return this.num + adder;
    }
    public int accumulate(int adder) {
        return this.num += adder;
    }
    public int random()
    {
        return new Random().nextInt(Integer.SIZE - 1);
    }
}
