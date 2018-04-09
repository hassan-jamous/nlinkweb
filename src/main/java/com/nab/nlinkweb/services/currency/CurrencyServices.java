package com.nab.nlinkweb.services.currency;

import com.nab.nlinkweb.components.NlinkSoapConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServices {

    @Autowired
    private NlinkSoapConsumer nlinkSoapConsumer;

    public double convertCurrency() {
        return nlinkSoapConsumer.getConversionRate().getConversionRate();

    }
}
