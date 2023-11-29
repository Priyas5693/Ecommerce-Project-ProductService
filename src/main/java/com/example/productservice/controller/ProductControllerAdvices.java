package com.example.productservice.controller;

import com.example.productservice.dto.ExceptionDTOs;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTOs> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDTOs exceptionDTOs= new ExceptionDTOs();
        exceptionDTOs.setMessage(productNotFoundException.getMessage());
        exceptionDTOs.setHttpStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exceptionDTOs,HttpStatus.NOT_FOUND);
    }

}
