package com.example.currencyconversionservice.proxy;

import com.example.currencyconversionservice.entity.Conversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Conversion retrieveExchangeValue(@PathVariable String from,
                                            @PathVariable String to);
}
