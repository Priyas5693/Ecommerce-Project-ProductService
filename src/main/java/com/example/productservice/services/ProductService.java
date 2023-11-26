package com.example.productservice.services;

import com.example.productservice.dto.GenericDTO;

import java.util.List;

public interface ProductService {
    GenericDTO getProductByID(Long id);
    List<GenericDTO> getAllProduct();
    void deleteProductByID();
    GenericDTO createProduct(GenericDTO genericDTO);
    void updateProductByID();
}
