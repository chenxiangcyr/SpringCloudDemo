package com.example.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadConfigController {
    private final static Logger logger = LoggerFactory.getLogger(ReadConfigController.class);

    //@Value("${jdbc.driverClassName}")
    String driverClassName;

    //@Value("${jdbc.url}")
    String url;

    //@Value("${jdbc.username}")
    String username;

    //@Value("${jdbc.password}")
    String password;

    @ApiOperation(value="从全局的 Config Server 读取配置", notes="")
    @GetMapping("/config")
    public String config() {

        logger.info("jdbc.driverClassName = " + driverClassName);
        logger.info("jdbc.url = " + url);
        logger.info("jdbc.username = " + username);
        logger.info("jdbc.password = " + password);

        return "success";
    }
}
