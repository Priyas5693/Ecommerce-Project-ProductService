package com.example.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private int price;
    private String image;
}
