package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOS.BookTicketRequestDTO;
import com.scaler.bookmyshow.DTOS.BookTicketResponseDTO;
import com.scaler.bookmyshow.DTOS.CancelTicketRequestDTO;
import com.scaler.bookmyshow.DTOS.CancelTicketResponseDTO;
import com.scaler.bookmyshow.ENUMS.ResponseStatus;
import com.scaler.bookmyshow.Models.Booking;
import com.scaler.bookmyshow.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    @Autowired /* constructor based injection (most preferred) */
    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketReq) {

        BookTicketResponseDTO response = new BookTicketResponseDTO();

        Booking booking = null;

        try {
            booking = bookingService.bookTicket(
                    bookTicketReq.getUserId(),
                    bookTicketReq.getShowId(),
                    bookTicketReq.getShowSeatIds()
            );
        } catch (Exception ex) {
            response.setResponse(ResponseStatus.FAILED);
            response.setFailureReason("Booking failed. Please retry !");
        }
        response.setResponse(ResponseStatus.SUCCESS);
        response.setBooking(booking);

        return response;
    }

    public CancelTicketResponseDTO cancelTicket(CancelTicketRequestDTO cancelReq) {
        //Impl cancel logic and call refund api from here.
        return null;
    }
}
