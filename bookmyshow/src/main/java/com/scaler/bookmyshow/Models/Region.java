package com.scaler.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region extends BaseModel {

    private String city;
//    private List<Theatre> theatres; we can put region in theatre class as well.
}
