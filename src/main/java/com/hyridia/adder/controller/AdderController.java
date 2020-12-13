package com.hyridia.adder.controller;

import com.hyridia.adder.service.AdderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/adder", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200", "http://0.0.0.0:4200"})
@RestController
public class AdderController {
    private AdderService adderService;

    public AdderController(AdderService adderService) {
        this.adderService = adderService;
    }

    @GetMapping("/current")
    public int currentNum() {
        return adderService.currentBase();
    }

    @GetMapping("/random")
    public int random() {
        return adderService.random();
    }

    @PostMapping
    public int add(@RequestParam int num) {
        return adderService.add(num);
    }

    @PostMapping("/accumulate")
    public int accumulate(@RequestParam int num)
    {
        return adderService.accumulate(num);
    }

    @PostMapping("/base")
    public String baseNum(@RequestParam int num) {
         adderService.baseNum(num);
         StringBuilder sb = new StringBuilder();
         sb.append("{")
                 .append("\"server\":{\"response\":\"Ok\"}")
                 .append("}");
         return sb.toString();
    }
}

