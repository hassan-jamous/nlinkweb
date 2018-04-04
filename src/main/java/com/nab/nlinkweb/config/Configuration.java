package com.nab.nlinkweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class Configuration {

    @Value("${info.description}")
    public String description;

}
