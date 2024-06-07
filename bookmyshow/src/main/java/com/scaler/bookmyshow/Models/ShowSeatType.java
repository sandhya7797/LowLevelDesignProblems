package com.scaler.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//ticket price depends upon show + seatType
@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private int price;
}
