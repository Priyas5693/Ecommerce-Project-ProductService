package com.example.productservice.controller;

import com.example.productservice.dto.ExceptionDTOs;
import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.fakeStoreProductDtos;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //create object of service class
    private ProductService ps;
    ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService ps){

        this.ps=ps;
    }
    @GetMapping("/{id}")
     public GenericDTO getProductByID(@PathVariable("id") Long id) throws ProductNotFoundException {
        return ps.getProductByID(id);

     }
     @GetMapping
     public List<GenericDTO> getAllProduct(){
     return ps.getAllProduct();
    }
    @DeleteMapping("/{id}")
    public GenericDTO deleteProductByID(@PathVariable("id") Long id){
        return ps.deleteProductByID(id);

    }
    @PostMapping
    public GenericDTO createProduct(@RequestBody GenericDTO genericDTO){
        return ps.createProduct(genericDTO);
    }
    public void updateProductByID(){

    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDTOs exceptionDTOs = new ExceptionDTOs();
//        exceptionDTOs.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDTOs.setMessage(productNotFoundException.getMessage());
//        ResponseEntity<ExceptionDTOs> responseEntity= new ResponseEntity<>(exceptionDTOs,HttpStatus.NOT_FOUND);
//
//        return responseEntity;
//    }


}
