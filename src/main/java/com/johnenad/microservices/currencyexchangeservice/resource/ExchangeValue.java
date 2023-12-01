package com.johnenad.microservices.currencyexchangeservice.resource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

@Entity
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(name = "CONVERSION_MULTIPLE")
    private BigDecimal conversionMultiple;

    @Transient
    private String exchangeEnvironmentInfo;

    public ExchangeValue() {

    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public String getExchangeEnvironmentInfo() {
        return exchangeEnvironmentInfo;
    }

    public void setExchangeEnvironmentInfo(String environmentInfo) {
        this.exchangeEnvironmentInfo = environmentInfo;
    }

}