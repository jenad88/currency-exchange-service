package com.johnenad.microservices.currencyexchangeservice.config;

import com.amazonaws.xray.jakarta.servlet.AWSXRayServletFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import jakarta.servlet.Filter;

@Configuration
public class WebConfig {
    @Bean
    public Filter TracingFilter() {
        return new AWSXRayServletFilter("currency-exchange-service");
    }
}