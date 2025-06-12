package com.example.interview.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.interview.model.Company;
import com.example.interview.model.GovApiResponse;

@Service
public class CompanyMappingService {

    public List<Company> mapToCompanyList(GovApiResponse govApiResponse) {
        return govApiResponse.getData().stream()
                .map(this::mapToCompany)
                .collect(Collectors.toList());
    }

    public Company mapToCompany(List<Object> entry) {
        if(entry.size() != 4) {
            throw new IllegalArgumentException("Invalid entry size");
        }
        return Company.builder()
            .cik(((Number) entry.get(0)).longValue())
            .name((String) entry.get(1))
            .ticker((String) entry.get(2))
            .exchange((String) entry.get(3))
            .build();
    }
}
