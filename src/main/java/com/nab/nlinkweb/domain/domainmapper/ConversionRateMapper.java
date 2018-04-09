package com.nab.nlinkweb.domain.domainmapper;


import com.nab.nlinkweb.domain.restdomain.ConversionRate;
import lombok.experimental.UtilityClass;
import nlink.wsdl.domain.ConversionRateResponse;

@UtilityClass
public class ConversionRateMapper {

    public ConversionRate convert(ConversionRateResponse cr) {
        return ConversionRate.builder().conversionRate(cr.getConversionRateResult()).build();
    }
}
