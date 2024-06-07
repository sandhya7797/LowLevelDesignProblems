package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking save(Booking booking);
}
