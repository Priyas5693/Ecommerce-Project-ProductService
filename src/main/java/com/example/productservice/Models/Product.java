package com.example.productservice.Models;


import com.example.productservice.dto.GenericDTO;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import org.aspectj.weaver.bcel.BcelPerClauseAspectAdder;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    //private Long id;
    private String title;
    private String description;
    private String image;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;


    @ManyToOne(optional = false)
    private Category category;

    private int inventory_count;

    //method to convert products into genericproduct dtos
    public GenericDTO from(Product product){
       GenericDTO genericDTO =new GenericDTO();
        genericDTO.setTitle(product.getTitle());
        genericDTO.setDescription(product.getDescription());
        genericDTO.setImage(product.getImage());
        genericDTO.setCategory(product.getCategory().getName());
        //genericDTO.setId(product.getId());
        return genericDTO;
    }
}
