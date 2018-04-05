package com.nab.nlinkweb;

import com.nab.nlinkweb.aspects.LoggingAspect;
import com.nab.nlinkweb.config.Configuration;
import org.aspectj.lang.Aspects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    @Autowired
    void setEnvironment(Environment env) {
        System.out.println(env.getProperty("info.description"));
    }

    @Bean
    public LoggingAspect createBeanFromStaticMethodFactory(){
        return Aspects.aspectOf(LoggingAspect.class);

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
