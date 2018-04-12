package com.nab.nlinkweb.controllers;

import com.nab.nlinkweb.nonfunctional.aspects.interfaces.Loggable;
import com.nab.nlinkweb.nonfunctional.config.Application.Configuration;
import com.nab.nlinkweb.nonfunctional.exceptions.InputValidationException;
import com.nab.nlinkweb.nonfunctional.interfaces.published.GeneralFunction;
import com.nab.nlinkweb.services.currency.CurrencyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class SampleController implements GeneralFunction {

    @Autowired
    private CurrencyServices currencyServices;

    @Override
    @Loggable
    @RequestMapping(method = GET, value = "/")
    public String home() {
        return Configuration.getLogLevel() + Configuration.getDescription();
    }

    @Override
    @RequestMapping(method = GET, value = "/soapTest")
    public double soap() {
        return currencyServices.convertCurrency();
    }

    @Override
    @RequestMapping(method = GET, value = "/hystrix")
    public double hystrix() {
        return currencyServices.convertCurrencyHystrix();
    }

    @Override
    @RequestMapping(method = GET, value = "/exception")
    public double exception() {
        throw new InputValidationException();
    }
}
