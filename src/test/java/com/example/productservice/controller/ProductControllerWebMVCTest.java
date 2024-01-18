package com.example.productservice.controller;

import com.example.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;

import static org.mockito.Mockito.when;;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMVCTest {
    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Test
    void testGetAllProductWebMVC() throws Exception{
         when(productService.getAllProduct()).thenReturn(new ArrayList<>());

         mockMvc.perform(get("/products"))
                 .andExpect(status().is(200))
                 .andExpect(content().string("[]"));
    }



}
