package com.example.productservice.controller;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.services.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
//    @MockBean
//    private ProductService productService;
//
//    @Inject
//    private ProductController productController;
//    @Test
//    void testOnePlusOneIsTwoOrNot(){
//
//        assertEquals(2, 1+1, "1+1 should be 2");
//    }
//    @Test
//    void testGetProductByIdMock() throws ProductNotFoundException {
//        GenericDTO genericDTO= new GenericDTO();
//        when(productService.getProductByID(100L)).thenReturn(genericDTO);
//        GenericDTO genericDTO1= productController.getProductByID(100L);
//        //assertNull(productController.getProductByID(100L));
//        assertEquals(genericDTO,genericDTO1);
//    }

//    @Test
//    void testGetProductByIdMockException() throws ProductNotFoundException {
//        when(productService.getProductByID(1L)).thenThrow(ProductNotFoundException.class);
//
//        assertThrows(ProductNotFoundException.class, ()->productController.getProductByID(1L));
//
//    }

}
