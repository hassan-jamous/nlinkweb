package com.nab.nlinkweb;

import com.nab.nlinkweb.nonfunctional.config.Application.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties
@EnableCircuitBreaker
public class Application {

    @Autowired
    private Configuration config;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
