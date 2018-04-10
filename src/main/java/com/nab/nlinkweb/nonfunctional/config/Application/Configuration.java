package com.nab.nlinkweb.nonfunctional.config.Application;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@RefreshScope
public class Configuration {


    public static String description;

    @Value("${info.description}")
    public void setDescription(String db) {
        description = db;
    }

    public static String currencyConverterEndPoint;

    @Value("${services.currencyConverter.endpoint}")
    public void setCurrencyConverterEndPoint(String endPoint) {
        currencyConverterEndPoint = endPoint;
    }

    public static String logLevel;

    @Value("${application.logging.level}")
    public void setLogLevel(String log) {
        logLevel = log;
    }

}
