package com.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class HomeController {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/index")
    public String index() {
        List<String> services = discoveryClient.getServices();
        String serviceList = String.join(",", services);
        logger.info("/index, serviceList:" + serviceList);
        return "hello eureka client";
    }

}
