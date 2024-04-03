package com.example.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductDTO {

    private String query;
    private int pageNumber;
    private int itemsPerPage;
}
