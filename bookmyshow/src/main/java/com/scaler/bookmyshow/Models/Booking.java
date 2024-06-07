package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.ENUMS.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity /* It is an annotation in JPA that marks a Java class as an entity. */
public class Booking extends BaseModel {

    @ManyToOne
    private User user;

    //many-many bec same showSeat can have two different bookings one is confirmed and another is cancelled. Also same seat can be booked by multiple users one at a time when it is available.
    @ManyToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToOne
    private Screen screen;

    @ManyToOne
    private Movie movie;

    @OneToMany
    private List<Payment> payments;

    @ManyToOne
    private Show show;

    private Date time;
}
