package com.example.productservice.services;

import com.example.productservice.Models.Product;
import com.example.productservice.dto.GenericDTO;
import com.example.productservice.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;
    public SearchService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<GenericDTO> searchProduct(String query, int pageNumber, int pageSize){
        PageRequest pageRequest =  PageRequest.of(pageNumber, pageSize);
          List<Product> product =  productRepository.findAllByTitleContainingIgnoreCase(query,pageRequest);
          List<GenericDTO> genericDTOList= new ArrayList<>();
          for(Product products: product){
              genericDTOList.add(products.from(products));
          }
          return genericDTOList;
    }

}

