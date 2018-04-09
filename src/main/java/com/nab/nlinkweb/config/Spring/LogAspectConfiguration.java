package com.nab.nlinkweb.config.Spring;

import com.nab.nlinkweb.aspects.LoggingAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogAspectConfiguration {
    @Bean
    public LoggingAspect createBeanFromStaticMethodFactory() {
        return Aspects.aspectOf(LoggingAspect.class);
    }
}
