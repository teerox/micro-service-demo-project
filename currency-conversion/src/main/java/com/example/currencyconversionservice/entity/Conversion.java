package com.example.currencyconversionservice.entity;

public class Conversion {

    private Long id;
    private String from;

    private String to;
    private Double conversionMultiple;
    private Double quantity;
    private Double totalCalculatedAmount;
    private String environment;

    public Conversion() {
    }

    public Conversion(Long id, String from, String to, Double conversionMultiple, Double quantity, Double totalCalculatedAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionMultiple() {
        return this.conversionMultiple;
    }

    public void setConversionMultiple(Double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCalculatedAmount() {
        return this.totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(Double totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", from='" + getFrom() + "'" +
            ", to='" + getTo() + "'" +
            ", conversionMultiple='" + getConversionMultiple() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", totalCalculatedAmount='" + getTotalCalculatedAmount() + "'" +
            ", port='" + getEnvironment() + "'" +
            "}";
    }
}
