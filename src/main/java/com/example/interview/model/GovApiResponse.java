package com.example.interview.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GovApiResponse {

    @JsonProperty("fields")
    private List<String> fields;

    @JsonProperty("data")
    private List<List<Object>> data;
} 