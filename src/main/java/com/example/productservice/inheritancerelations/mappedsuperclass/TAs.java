package com.example.productservice.inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_tas")
public class TAs extends Users {
    private String ta_session;

}
