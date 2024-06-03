package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.entity.Conversion;
import com.example.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }


    // using RestTemplate to call currency-exchange-service
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public Conversion convertCurrency(@PathVariable String from,
                                      @PathVariable String to,
                                      @PathVariable Double quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<Conversion> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                Conversion.class, uriVariables);

        Conversion currencyConversion = responseEntity.getBody();

        if (currencyConversion == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        return new Conversion(currencyConversion.getId(), from, to,
                currencyConversion.getConversionMultiple(), quantity,
                quantity * currencyConversion.getConversionMultiple(),
                currencyConversion.getEnvironment());
    }

    // using Feign Client to call currency-exchange-service
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public Conversion convertCurrencyFeign(@PathVariable String from,
                                           @PathVariable String to,
                                           @PathVariable Double quantity) {
        Conversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new Conversion(currencyConversion.getId(), from, to,
                currencyConversion.getConversionMultiple(), quantity,
                quantity * currencyConversion.getConversionMultiple(),
                currencyConversion.getEnvironment());
    }
}
