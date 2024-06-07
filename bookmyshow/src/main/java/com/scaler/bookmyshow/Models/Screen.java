package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.ENUMS.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Screen extends BaseModel {

    private String name;

    //For list of enums we would represent relation using below annotation.
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    //private List<Show> shows;

    @OneToMany
    private List<Seat> seats;
}
