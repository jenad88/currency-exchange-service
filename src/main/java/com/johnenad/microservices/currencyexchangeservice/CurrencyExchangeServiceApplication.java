package com.johnenad.microservices.currencyexchangeservice;

import com.johnenad.microservices.currencyexchangeservice.resource.ExchangeValue;
import com.johnenad.microservices.currencyexchangeservice.resource.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CurrencyExchangeServiceApplication implements CommandLineRunner {

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        long count = exchangeValueRepository.count();

        if (count == 0) {
            exchangeValueRepository.save(new ExchangeValue(1000L, "USD", "INR", BigDecimal.valueOf(65.0)));
            exchangeValueRepository.save(new ExchangeValue(1001L, "EUR", "INR", BigDecimal.valueOf(75.0)));
            exchangeValueRepository.save(new ExchangeValue(1002L, "GBP", "INR", BigDecimal.valueOf(85.0)));
            exchangeValueRepository.save(new ExchangeValue(1003L, "AUD", "INR", BigDecimal.valueOf(55.0)));
            exchangeValueRepository.save(new ExchangeValue(1004L, "CAD", "INR", BigDecimal.valueOf(45.0)));
        }
    }
}
