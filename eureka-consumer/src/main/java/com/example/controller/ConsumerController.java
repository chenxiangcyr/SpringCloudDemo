package com.example.controller;

import com.example.service.ConsumerService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private final static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ConsumerService consumerService;

    @ApiOperation(value = "提供 1 + 2 的加法结果", notes = "")
    @GetMapping("/consumer")
    public String consumer() {
        logger.info("{} REST API provided by {}", "consumer", "eureka-consumer");
        return consumerService.consumer();
    }

}
