package com.example.productservice.services;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.fakeStoreProductDtos;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductServiceImpl")
public class fakeStoreProductServiceImpl implements ProductService {
    private String getURL="https://fakestoreapi.com/products/1";
    private RestTemplateBuilder restTemplateBuilder;
    fakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder= restTemplateBuilder;
    }
    //Method to convert GenericStore DTO to FakeStore
    public GenericDTO convertGenericToFakeStore(fakeStoreProductDtos fakeStoreProductDtos){
       GenericDTO genericDTO= new GenericDTO();
       genericDTO.setId(fakeStoreProductDtos.getId());
       genericDTO.setCategory(fakeStoreProductDtos.getCategory());
       genericDTO.setDescription(fakeStoreProductDtos.getDescription());
       genericDTO.setTitle(fakeStoreProductDtos.getTitle());
       genericDTO.setPrice(fakeStoreProductDtos.getPrice());
       genericDTO.setImage(fakeStoreProductDtos.getImage());

       return genericDTO;
    }
    @Override
    public GenericDTO getProductByID(Long id) {
        //Integrate FakeStore API
        // using RestTemplate

        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<fakeStoreProductDtos> responseEntity=
                restTemplate.getForEntity(getURL, fakeStoreProductDtos.class);
        //calling function to convert generic DTO to fakeSTore
        return convertGenericToFakeStore(responseEntity.getBody());
    }

    @Override
    public void getAllProduct() {

    }

    @Override
    public void deleteProductByID() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductByID() {

    }
}
