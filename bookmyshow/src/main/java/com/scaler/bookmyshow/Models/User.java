package com.scaler.bookmyshow.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@Entity
public class User extends BaseModel {

    private String name;

    private String phoneNum;

    private String emailId;

    private String password;

    @OneToMany
    private List<Booking> history;

}
