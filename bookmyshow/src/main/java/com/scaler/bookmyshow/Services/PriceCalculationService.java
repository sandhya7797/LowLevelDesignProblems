package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Models.Show;
import com.scaler.bookmyshow.Models.ShowSeat;
import com.scaler.bookmyshow.Models.ShowSeatType;
import com.scaler.bookmyshow.Repositories.ShowSeatRepository;
import com.scaler.bookmyshow.Repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

    private ShowSeatRepository showSeatRepository;

    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public PriceCalculationService(ShowSeatRepository showSeatRepository, ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int getPrice(List<ShowSeat> showSeats, Show show) {

       List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

       int amount = 0;
       for(ShowSeat showSeat : showSeats) {
           for(ShowSeatType showSeatType : showSeatTypes) {
               if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                   amount += showSeatType.getPrice();
                   break;
               }
           }
       }

        return amount;
    }
}
