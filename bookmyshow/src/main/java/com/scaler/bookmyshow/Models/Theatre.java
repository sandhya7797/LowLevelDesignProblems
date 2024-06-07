package com.scaler.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel {

    private String name;

    private String Address;

    @OneToMany
    private List<Screen> screens;
//  private List<Show> shows;

    @ManyToOne
    private Region region;
}
