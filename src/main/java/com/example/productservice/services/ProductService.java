package com.example.productservice.services;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    GenericDTO getProductByID(String authtoken, Long id) throws ProductNotFoundException;
    List<GenericDTO> getAllProduct();
    GenericDTO deleteProductByID(Long id);
    GenericDTO createProduct(GenericDTO genericDTO);
    void updateProductByID();
}
