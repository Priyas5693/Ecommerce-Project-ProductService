package com.example.productservice.controller;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
@WebMvcTest(ProductController.class)
public class ProductControllerWebMVCTest {
    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Captor
    private ArgumentCaptor<Long> argumentCaptor;
    @Inject
    ProductController productController;
    @Test
    void testGetAllProductReturnsEmptyList() throws Exception{
         when(productService.getAllProduct()).thenReturn(new ArrayList<>());

         mockMvc.perform(get("/products"))
                 .andExpect(status().is(200))
                 .andExpect(content().string("[]"));
    }
    @Test
    void testGetAllProductReturnsValidList() throws Exception{
        List<GenericDTO> genericProductDTOs= new ArrayList<>();
        genericProductDTOs.add(new GenericDTO());
        genericProductDTOs.add(new GenericDTO());
        genericProductDTOs.add(new GenericDTO());
        when(productService.getAllProduct()).thenReturn(genericProductDTOs);

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDTOs)));
    }
    @Test
    void createProductShouldReturnNewValidProductList() throws Exception {
          GenericDTO productList = new GenericDTO();
           productList.setTitle("Macbook Air");
           productList.setCategory("Apple Products");
           productList.setDescription("New Macbook");
           productList.setPrice(200000);

           GenericDTO outputProductList = new GenericDTO();
           outputProductList.setPrice(productList.getPrice());
           outputProductList.setDescription(productList.getDescription());
           outputProductList.setCategory(productList.getCategory());
           outputProductList.setTitle(productList.getTitle());
           outputProductList.setId(1000L);

           when(productService.createProduct(any())).thenReturn(outputProductList);
           mockMvc.perform(post("/products")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(objectMapper.writeValueAsString(productList))
           )
                   .andExpect(status().is(200))
                   .andExpect(content().string(objectMapper.writeValueAsString(outputProductList)))
                   .andExpect(jsonPath("$.title",is("Macbook Air")))
                   .andExpect(jsonPath("$.price",is(200000)));
    }
//    @Test
//    @DisplayName("testProductControllerCallsProductServiceWithSameProductIDAsInput")
//    void testSameInput() throws ProductNotFoundException {
//        Long id= 100L;
//
//        when(productService.getProductByID(id)).thenReturn(new GenericDTO());
//
//        GenericDTO genericDTO= productController.getProductByID(id);
//        verify(productService).getProductByID(argumentCaptor.capture());
//        assertEquals(id,argumentCaptor.getValue());
//    }



}
