package com.scaler.bookmyshow.DTOS;

import com.scaler.bookmyshow.ENUMS.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpResponseDTO {

    private ResponseStatus responseStatus;
    private String failureReason;
    private Long userId;
}
