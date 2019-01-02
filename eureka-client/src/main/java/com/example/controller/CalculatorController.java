package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final static Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/add")
    public Integer add(@RequestParam Integer operand1, @RequestParam Integer operand2) throws InterruptedException {

        logger.info("{} REST API provided by {}", "add", "eureka-client");

        return operand1 + operand2;
    }
}
