package com.nab.nlinkweb.nonfunctional.config.Application;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@RefreshScope
public class Configuration {

    private static String description;
    private static String currencyConverterEndPoint;
    private static String logLevel;

    public static String getDescription() {
        return Configuration.description;
    }

    public static String getCurrencyConverterEndPoint() {
        return Configuration.currencyConverterEndPoint;
    }

    public static String getLogLevel() {
        return Configuration.logLevel;
    }

    @Value("${info.description}")
    public void setDescription(String db) {
        description = db;
    }

    @Value("${services.currencyConverter.endpoint}")
    public void setCurrencyConverterEndPoint(String endPoint) {
        currencyConverterEndPoint = endPoint;
    }

    @Value("${application.logging.level}")
    public void setLogLevel(String log) {
        logLevel = log;
    }

}
