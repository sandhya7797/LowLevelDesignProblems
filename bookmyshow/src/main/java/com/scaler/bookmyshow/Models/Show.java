package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.ENUMS.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Show extends BaseModel {

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    private Screen screen;


}
