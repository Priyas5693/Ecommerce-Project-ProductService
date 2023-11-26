package com.example.productservice.services;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.fakeStoreProductDtos;

public interface ProductService {
    GenericDTO getProductByID(Long id);
    void getAllProduct();
    void deleteProductByID();
    void createProduct();
    void updateProductByID();
}
