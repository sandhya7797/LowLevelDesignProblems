package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.ENUMS.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//seat status (booked/notbooked) is based on two classes show and seat. so status is created in this combination class.
@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

    private int seatNum;

    @Enumerated
    private SeatStatus status;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    private Date blockedAt;
}
