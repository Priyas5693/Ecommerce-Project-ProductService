package com.example.productservice.inheritancerelations.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_tas")
public class TAs extends Users {
    private String ta_session;

}
