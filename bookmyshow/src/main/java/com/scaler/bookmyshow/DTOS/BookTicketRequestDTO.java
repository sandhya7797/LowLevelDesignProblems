package com.scaler.bookmyshow.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {

    //TODO : just confirm why only id's are coming here.

    private Long userId;

    private Long showId;

    private List<Long> showSeatIds;
}
