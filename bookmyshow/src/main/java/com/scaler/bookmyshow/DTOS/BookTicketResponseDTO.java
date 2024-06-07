package com.scaler.bookmyshow.DTOS;

import com.scaler.bookmyshow.ENUMS.ResponseStatus;
import com.scaler.bookmyshow.Models.Booking;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class BookTicketResponseDTO {
    private ResponseStatus response;
    private String failureReason;
    private Booking booking;
}
