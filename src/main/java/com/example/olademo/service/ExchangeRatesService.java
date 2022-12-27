package com.example.olademo.service;

//import com.example.olademo.mapper.ExchangeRatesMapper;

import com.example.olademo.entity.ExchangeRates;
import com.example.olademo.repository.ExchangeRatesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExchangeRatesService {
    @Autowired
    private WebClient webClient;
    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");

    public void getDailyExchangeRate(){
        String str = webClient.get()
                .uri("https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=USD&to_symbol=KZT&apikey=39K9QM2MGR6RPQ7V")
                .retrieve().bodyToMono(String.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(str);
            String closeRate = String.valueOf(jsonNode.get("Time Series FX (Daily)")
                    .get(simpleDateFormat.format(new Date()))
                    .get("4. close"));
            if(closeRate == null) throw new IllegalArgumentException("rate is null");

            ExchangeRates entry = new ExchangeRates();
            entry.setSum(Float.valueOf(closeRate.replaceAll("\"", "")));
            entry.setDate(new Date());
            exchangeRatesRepository.save(entry);

//            System.out.println(closeRate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
