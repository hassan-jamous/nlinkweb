package com.nab.nlinkweb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@RefreshScope
public class Configuration {

    @Getter
    @Setter
    @Value("${info.description}")
    private String description;

    @Getter
    @Setter
    @Value("${application.logging.level}")
    private String logLevel;

}
