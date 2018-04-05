package com.nab.nlinkweb.controllers;

import com.nab.nlinkweb.aspects.Loggable;
import com.nab.nlinkweb.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private Configuration config;

    @RequestMapping("/")
    @Loggable
    public String home() {
        return config.getDescription();
    }
}
