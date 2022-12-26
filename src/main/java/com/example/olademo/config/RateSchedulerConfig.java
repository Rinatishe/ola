package com.example.olademo.config;

import com.example.olademo.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class RateSchedulerConfig {
    @Autowired
    private ExchangeRatesService exchangeRatesService;

    //расписание раз в день (миллисекнунды - 24 часа)
    @Scheduled(fixedRateString = "86400000")
    public void getDailyRates(){
        exchangeRatesService.getDailyExchangeRate();
    }
}
