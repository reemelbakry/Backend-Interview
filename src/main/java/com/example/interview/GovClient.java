package com.example.interview;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.interview.model.GovApiResponse;

@FeignClient(name = "govClient", url ="https://www.sec.gov/files/company_tickers_exchange.json")
public interface GovClient {
    @GetMapping
    public GovApiResponse getCompanies(@RequestHeader("User-Agent") String userAgent);
}
