package com.scaler.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Movie extends BaseModel {

    private String name;

    @ManyToMany
    private List<Cast> cast;

    @ManyToMany
    private List<Crew> crew;

    private float ratings;

    private String genre;
}
