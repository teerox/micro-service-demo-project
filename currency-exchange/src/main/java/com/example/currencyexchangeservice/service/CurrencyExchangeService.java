package com.example.currencyexchangeservice.service;

import com.example.currencyexchangeservice.entity.CurrencyExchange;

public interface CurrencyExchangeService {
    public CurrencyExchange retrieveExchangeValue(String from, String to);
}
