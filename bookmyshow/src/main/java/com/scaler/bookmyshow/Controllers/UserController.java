package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOS.SignUpRequestDTO;
import com.scaler.bookmyshow.DTOS.SignUpResponseDTO;
import com.scaler.bookmyshow.ENUMS.ResponseStatus;
import com.scaler.bookmyshow.Exceptions.UserAldyExistsException;
import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired /* constructor based injection (most preferred) */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpReq) throws UserAldyExistsException {

        SignUpResponseDTO response = new SignUpResponseDTO();

        User user = null;

        try {
            user = userService.signUp(signUpReq.getUser().getName(),
                    signUpReq.getUser().getPhoneNum(),
                    signUpReq.getUser().getEmailId(),
                    signUpReq.getUser().getPassword());
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILED);
            response.setFailureReason("signup failed. User already exists !");
            System.out.println("User already exists !");
        }
        response.setResponseStatus(ResponseStatus.SUCCESS);
        if (user != null) {
            response.setUserId(user.getId());
        }
        return response;
    }
}
