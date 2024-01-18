package com.example.productservice.services;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    GenericDTO getProductByID(Long id) throws ProductNotFoundException;
    List<GenericDTO> getAllProduct();
    GenericDTO deleteProductByID(Long id);
    GenericDTO createProduct(GenericDTO genericDTO);
    void updateProductByID();
}
