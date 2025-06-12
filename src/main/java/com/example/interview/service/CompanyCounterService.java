package com.example.interview.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CompanyCounterService {
    private final Map<String, AtomicInteger> tickerCount = new ConcurrentHashMap<>();

    public void incrementTicker(String ticker){
        tickerCount.computeIfAbsent(ticker.toUpperCase(), k -> new AtomicInteger()).incrementAndGet();
    }

    public Map<String, Integer> getTickerCount(){
        return tickerCount.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));
    }
}
