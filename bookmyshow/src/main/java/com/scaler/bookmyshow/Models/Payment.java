package com.scaler.bookmyshow.Models;

import com.scaler.bookmyshow.ENUMS.PaymentMode;
import com.scaler.bookmyshow.ENUMS.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private String refNum;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode mode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;

    private Date time;

}
