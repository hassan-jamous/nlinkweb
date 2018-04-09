package com.nab.nlinkweb.controllers;

import com.nab.nlinkweb.aspects.interfaces.Loggable;
import com.nab.nlinkweb.config.Application.Configuration;
import com.nab.nlinkweb.services.currency.CurrencyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private Configuration config;

    @Autowired
    private CurrencyServices currencyServices;

    @RequestMapping("/")
    @Loggable
    public String home() {
        return config.getDescription();
    }

    @RequestMapping("/soapTest")
    public double soap() {
        return currencyServices.convertCurrency();
    }
}
