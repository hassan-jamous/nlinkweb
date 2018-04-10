package com.nab.nlinkweb.controllers;

import com.nab.nlinkweb.nonfunctional.aspects.interfaces.Loggable;
import com.nab.nlinkweb.nonfunctional.config.Application.Configuration;
import com.nab.nlinkweb.nonfunctional.exceptions.InputValidationException;
import com.nab.nlinkweb.services.currency.CurrencyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

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

    @RequestMapping("/hystrix")
    public double hystrix() {
        return currencyServices.convertCurrencyHystrix();
    }

    @RequestMapping("/exception")
    public double exception() {
        throw new InputValidationException();
    }
}
