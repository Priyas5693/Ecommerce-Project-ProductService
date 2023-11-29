package com.example.productservice.services;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.fakeStoreProductDtos;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class fakeStoreProductServiceImpl implements ProductService {
    private String getURL="https://fakestoreapi.com/products/{id}";
    private String getproductURL="https://fakestoreapi.com/products";
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
    //exception handler are in controller
    @Override
    public GenericDTO getProductByID(Long id) throws ProductNotFoundException {
        //Integrate FakeStore API
        // using RestTemplate

        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<fakeStoreProductDtos> responseEntity=
                restTemplate.getForEntity(getURL, fakeStoreProductDtos.class,id);
        //calling function to convert generic DTO to fakeSTore
        fakeStoreProductDtos fakeStoreProductDtos= responseEntity.getBody();
        if(fakeStoreProductDtos==null){
            throw new ProductNotFoundException("Product with id:"+id+" doesn't exists");
        }
        return convertGenericToFakeStore(fakeStoreProductDtos);
    }

    @Override
    public List<GenericDTO> getAllProduct() {
       RestTemplate restTemplate = restTemplateBuilder.build();
       ResponseEntity<fakeStoreProductDtos[]> responseEntity =
               restTemplate.getForEntity(getproductURL, fakeStoreProductDtos[].class);
       List<GenericDTO> genericDTOList = new ArrayList<>();
       List<fakeStoreProductDtos> fakeStoreProductDtosList= List.of(responseEntity.getBody());
       for(fakeStoreProductDtos fakeStoreProductDtos:fakeStoreProductDtosList){
           genericDTOList.add(convertGenericToFakeStore(fakeStoreProductDtos));
       }
        return genericDTOList;
    }

    @Override
    public GenericDTO deleteProductByID(Long id) {
        //the delete methods for the rest template isn't returning anything and return type is void
        //but as we want to return the object which we have deleted
        //we will use get product template code with modification
        //we will use getForEntity method and modify it to delete
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(fakeStoreProductDtos.class);
        ResponseExtractor<ResponseEntity<fakeStoreProductDtos>> responseExtractor =
                restTemplate.responseEntityExtractor(fakeStoreProductDtos.class);
        ResponseEntity<fakeStoreProductDtos> responseEntity=
                restTemplate.execute(getURL, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertGenericToFakeStore(responseEntity.getBody());

    }

    @Override
    public GenericDTO createProduct(GenericDTO genericdto) {
         RestTemplate restTemplate = restTemplateBuilder.build();
         ResponseEntity<fakeStoreProductDtos> responseEntity =
                 restTemplate.postForEntity(getproductURL,genericdto, fakeStoreProductDtos.class);
         return convertGenericToFakeStore(responseEntity.getBody());

    }

    @Override
    public void updateProductByID() {

    }
}
