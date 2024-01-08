package com.example.productservice.inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_students")

public class Students extends Users{
    private Double psp;

}
