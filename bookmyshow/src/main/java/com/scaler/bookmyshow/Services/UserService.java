package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Exceptions.UserAldyExistsException;
import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String name, String phoneno, String email, String password) throws UserAldyExistsException {

        Optional<User> savedUser = userRepository.findByEmailId(email);

        if(!savedUser.isEmpty()) {
            throw new UserAldyExistsException();
        }

        User user = new User();

        if(savedUser.isEmpty()) {
            user.setEmailId(email);
            user.setPassword(password);
            user.setName(name);
            user.setPhoneNum(phoneno);
            userRepository.save(user);
        }

        return user;

    }
}
