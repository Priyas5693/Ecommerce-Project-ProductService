package com.example.productservice.inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentors")
public class Mentor extends Users {
    private Double avgRating;

}
