package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long aLong);

    Optional<User> findByEmailId(String email);

    User save(User user);
}
