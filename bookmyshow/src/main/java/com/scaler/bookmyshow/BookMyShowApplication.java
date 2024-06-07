package com.scaler.bookmyshow;

import com.scaler.bookmyshow.Controllers.BookingController;
import com.scaler.bookmyshow.Controllers.UserController;
import com.scaler.bookmyshow.DTOS.SignUpRequestDTO;
import com.scaler.bookmyshow.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/* CommandLineRunner - It is an interface used in spring boot to run specific code immediately after the application starts. */


@EnableJpaAuditing /* This is a global setting for the entire application, enabling the auditing framework. */
@SpringBootApplication /* This annotation simplifies the configuration of a spring boot application by combining three annotations into one. It makes easier to start your application. @Configuration, @ComponentScan, @EnableAutoConfiguration */
public class BookMyShowApplication implements CommandLineRunner {

	private UserController userController;


	@Autowired /* Constructor based dependency injection */
	public BookMyShowApplication(UserController userController) {
		this.userController = userController;
	}

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDTO request = new SignUpRequestDTO();
		User user = new User();
		user.setName("Sandhya");
		user.setPhoneNum("7330899450");
		user.setEmailId("sandhya77@gmail.com");
		user.setPassword("abcd@1234");
		request.setUser(user);
		userController.signUp(request);
	}
}
