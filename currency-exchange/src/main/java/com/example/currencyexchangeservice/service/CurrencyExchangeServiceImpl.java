package com.example.currencyexchangeservice.service;

import com.example.currencyexchangeservice.entity.CurrencyExchange;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchange retrieveExchangeValue(String from, String to) {
        return currencyExchangeRepository.findByFromAndTo(from, to);
    }
}
