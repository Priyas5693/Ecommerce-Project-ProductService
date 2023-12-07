package com.example.productservice.ThirdPartyClient.FakeStoreClient;

import com.example.productservice.dto.GenericDTO;
import com.example.productservice.dto.fakeStoreProductDtos;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreClientAdapter{

    private String fakeStoreUrl;

    @Value("${fakeStore.api.path.products}")
    private String pathforproducts;
    private String getURL; //="https://fakestoreapi.com/products/{id}";
    private String getproductURL; //="https://fakestoreapi.com/products";
    private RestTemplateBuilder restTemplateBuilder;
    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder, @Value("${fakeStore.api.url}") String fakeStoreUrl, @Value("${fakeStore.api.path.products}") String pathforproducts){
        this.restTemplateBuilder= restTemplateBuilder;
        this.fakeStoreUrl=fakeStoreUrl;
        this.pathforproducts=pathforproducts;
        this.getURL= fakeStoreUrl+pathforproducts+"/{id}";
        this.getproductURL= fakeStoreUrl+pathforproducts;
    }
    //Method to convert GenericStore DTO to FakeStore
    //exception handler are in controller
    public fakeStoreProductDtos getProductByID(Long id) throws ProductNotFoundException {
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
        return responseEntity.getBody();
    }

    public List<fakeStoreProductDtos> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<fakeStoreProductDtos[]> responseEntity =
                restTemplate.getForEntity(getproductURL, fakeStoreProductDtos[].class);

        return List.of(responseEntity.getBody());
    }
    public fakeStoreProductDtos deleteProductByID(Long id) {
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
        return responseEntity.getBody();

    }
    public fakeStoreProductDtos createProduct(GenericDTO genericdto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<fakeStoreProductDtos> responseEntity =
                restTemplate.postForEntity(getproductURL,genericdto, fakeStoreProductDtos.class);
        return responseEntity.getBody();

    }
    public void updateProductByID() {

    }
}
