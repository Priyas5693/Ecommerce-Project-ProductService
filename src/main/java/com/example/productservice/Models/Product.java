package com.example.productservice.Models;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import org.aspectj.weaver.bcel.BcelPerClauseAspectAdder;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;


    @ManyToOne(optional = false)
    private Category category;
}
