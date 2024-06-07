package com.scaler.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private int seatNum;

    private int row;

    private int col;

    @ManyToOne
    private SeatType seatType;
}
