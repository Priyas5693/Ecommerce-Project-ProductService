package com.example.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class fakeStoreProductDtos {
    private Long id;
    private String title;
    private String description;
    private String category;
    private int price;
    private String image;
}
