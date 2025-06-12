package com.example.interview.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    private long cik;
    private String name;
    private String ticker;
    private String exchange;
} 