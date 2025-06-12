package com.example.interview.service;

import com.example.interview.GovClient;
import com.example.interview.model.Company;
import com.example.interview.model.GovApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMappingService companyMappingService;

    @Autowired
    private GovClient govClient;

    @Autowired
    private CompanyCounterService companyCounterService;

    public List<Company> getCompanies() {
        GovApiResponse govApiResponse = govClient.getCompanies("John Doe (test@example.com)");
        return companyMappingService.mapToCompanyList(govApiResponse);
    }

    public Company getCompanyByTicker(String ticker){
          Company company = getCompanies().stream()
                   .filter(c -> c.getTicker().equalsIgnoreCase(ticker))
                   .findFirst()
                   .orElseThrow(()->new IllegalArgumentException("Company not found"));

          companyCounterService.incrementTicker(ticker);

          return company;
    }
    
}
