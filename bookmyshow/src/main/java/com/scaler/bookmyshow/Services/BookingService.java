package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.ENUMS.BookingStatus;
import com.scaler.bookmyshow.ENUMS.SeatStatus;
import com.scaler.bookmyshow.Exceptions.InvalidShowIdException;
import com.scaler.bookmyshow.Exceptions.SeatNotAvailableException;
import com.scaler.bookmyshow.Exceptions.UserNotFoundException;
import com.scaler.bookmyshow.Models.*;
import com.scaler.bookmyshow.Repositories.BookingRepository;
import com.scaler.bookmyshow.Repositories.ShowRepository;
import com.scaler.bookmyshow.Repositories.ShowSeatRepository;
import com.scaler.bookmyshow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;

    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    private PriceCalculationService priceCalculationService;

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculationService priceCalculationService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = priceCalculationService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> seatIds)
            throws InvalidShowIdException, UserNotFoundException, SeatNotAvailableException {

          /*
        ------ START lock here for this lecture
        * 1. Get the user with user id from DB
        * 2. Get the show details from DB
        * ------------ Start LOCK here ------------------
        * 3. get the show seats with the given show seats ids from DB
        * 4. check if the show seats are available
        * 5. If they are not available, throw an error
        * 6. If they are available, update the status to blocked and update the timestamp
        * 7. Update the show seats in DB
        * --------- Release lock here -------------------
        * 8. return
        -------- END lock here for this lecture ------------
        * */

        Optional<User> savedUser = userRepository.findById(userId);

        if(savedUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        User user = savedUser.get();

        Optional<Show> savedShow = showRepository.findById(showId);

        if(savedShow.isEmpty()) {
            throw new InvalidShowIdException();
        }

        Show show = savedShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);

        for(ShowSeat showSeat : showSeats) {
            if(!(showSeat.getStatus().equals(SeatStatus.AVAILABLE) || showSeat.getStatus().equals(SeatStatus.BLOCKED) &&
                    Duration.between(showSeat.getBlockedAt().toInstant(),
                            new Date().toInstant()).toMinutes()>15)) {
                throw new SeatNotAvailableException();
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats) {
            showSeat.setStatus(SeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculationService.getPrice(savedShowSeats, show));

        return bookingRepository.save(booking);
    }
}
