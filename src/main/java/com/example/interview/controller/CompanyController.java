package com.example.interview.controller;

import java.util.List;
import java.util.Map;

import com.example.interview.service.CompanyCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.model.Company;
import com.example.interview.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyCounterService companyCounterService;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companyService.getCompanies());
    }

    @GetMapping("/ticker/{ticker}")
    public ResponseEntity<Company> getByticker(@PathVariable String ticker) {
        return ResponseEntity.ok(companyService.getCompanyByTicker(ticker));
    }

    @GetMapping("/activity")
    public ResponseEntity<Map<String,Integer>> getActivity() {
        return ResponseEntity.ok(companyCounterService.getTickerCount());
    }

}
