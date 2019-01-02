package com.example.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")},
            fallbackMethod = "fallback")
    public String consumer() {
        // 调用加法服务
        String url = "http://eureka-client/add";

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url)
                // Add query parameter
                .queryParam("operand1", 1)
                .queryParam("operand2", 2);

        return restTemplate.getForObject(builder.toUriString(), Integer.class)+"";
    }

    public String fallback() {
        return "fallback";
    }

}
