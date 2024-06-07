package com.scaler.bookmyshow.DTOS;

import com.scaler.bookmyshow.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDTO {

    private User user;
}
