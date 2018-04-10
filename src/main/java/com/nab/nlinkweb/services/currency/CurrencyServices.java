package com.nab.nlinkweb.services.currency;

import com.nab.nlinkweb.components.NlinkSoapConsumer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServices {

    @Autowired
    private NlinkSoapConsumer nlinkSoapConsumer;

    public double convertCurrency() {
        return nlinkSoapConsumer.getConversionRate().getConversionRate();
    }

    @HystrixCommand(groupKey = "CurrencyServices", commandKey = "convertCurrencyHystrix", fallbackMethod = "hystrixFallback")
    public double convertCurrencyHystrix() {
        return nlinkSoapConsumer.getConversionRateHystrixTest().getConversionRate();
    }

    public double hystrixFallback() {
        return Double.SIZE;
    }
}
