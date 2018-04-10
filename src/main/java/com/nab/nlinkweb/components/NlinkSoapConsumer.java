package com.nab.nlinkweb.components;

import com.nab.nlinkweb.domain.domainmapper.ConversionRateMapper;
import com.nab.nlinkweb.nonfunctional.config.Application.Configuration;
import nlink.wsdl.domain.ConversionRate;
import nlink.wsdl.domain.ConversionRateResponse;
import nlink.wsdl.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class NlinkSoapConsumer extends WebServiceGatewaySupport {

    public static final int SLEEP_MILLI = 6000;

    @Autowired
    public NlinkSoapConsumer(Jaxb2Marshaller marshaller) {
        this.setDefaultUri(Configuration.currencyConverterEndPoint);
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
    }

    public com.nab.nlinkweb.domain.restdomain.ConversionRate getConversionRate() {

        ConversionRate request = new ConversionRate();
        request.setFromCurrency(Currency.AED);
        request.setToCurrency(Currency.USD);


        ConversionRateResponse response = (ConversionRateResponse) getWebServiceTemplate()
                .marshalSendAndReceive(Configuration.currencyConverterEndPoint,
                        request);

        return ConversionRateMapper.convert(response);

    }

    public com.nab.nlinkweb.domain.restdomain.ConversionRate getConversionRateHystrixTest() {
        try {
            Thread.sleep(SLEEP_MILLI);
        } catch (InterruptedException e) {
        }


        ConversionRateResponse response = new ConversionRateResponse();
        response.setConversionRateResult(Double.MAX_VALUE);

        return ConversionRateMapper.convert(response);

    }

}
