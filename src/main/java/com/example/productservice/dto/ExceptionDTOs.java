package com.example.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ExceptionDTOs {
    private HttpStatus httpStatus;
    private String message;
}
