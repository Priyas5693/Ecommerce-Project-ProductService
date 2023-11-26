package com.example.productservice.controller;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.fakeStoreProductDtos;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //create object of service class
    private ProductService ps;
    ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService ps){

        this.ps=ps;
    }
    @GetMapping("/{id}")
     public GenericDTO getProductByID(@PathVariable("id") Long id){
        return ps.getProductByID(id);

     }
     @GetMapping
     public void getAllProduct(){

    }
    @DeleteMapping("/id")
    public void deleteProductByID(){

    }
    public void createProduct(){

    }
    public void updateProductByID(){

    }
}
