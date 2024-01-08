package com.example.productservice.inheritancerelations.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_students")

public class Students extends Users {
    private Double psp;

}
