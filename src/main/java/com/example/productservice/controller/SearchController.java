package com.example.productservice.controller;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.SearchProductDTO;
import com.example.productservice.services.SearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController{
          private SearchService searchservice;
          SearchController(SearchService searchservice){
              this.searchservice=searchservice;
          }

    @PostMapping
    public List<GenericDTO> searchProduct(@RequestBody SearchProductDTO searchProductDTO){
              return searchservice.searchProduct(searchProductDTO.getQuery(), searchProductDTO.getPageNumber(),searchProductDTO.getItemsPerPage());
    }


}
