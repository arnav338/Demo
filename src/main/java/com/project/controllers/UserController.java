package com.project.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.User;
import com.project.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	public static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserServiceImpl userServiceImpl;

	// to add user -> http://localhost:9100/user/signupUser
	@RequestMapping("/signupUser")
	@CrossOrigin
	public boolean registerUser(@RequestBody User user) throws IOException {
		logger.info("Received request to signup user {} ", user);
		boolean authenticationFlag = userServiceImpl.signupUser(user);
		return authenticationFlag ? true : false;
	}

	// to login user -> http://localhost:9100/user/loginUser
	@RequestMapping("/loginUser")
	@CrossOrigin
	public String loginUser(@RequestBody User user) throws IOException {
		logger.info("Received request to login user {} ", user);
		String authenticationMessage = userServiceImpl.loginUser(user);
		return authenticationMessage;
	}

	// to login user data -> http://localhost:9100/user/loadUser
	@RequestMapping("/loadUser")
	@CrossOrigin
	public User loadUser(@RequestBody User user) throws IOException {
		logger.info("Received request to load user {} ", user);
		User returnedUser = new User();
		returnedUser = userServiceImpl.findByEmail(user.getEmail()); 
		logger.info("Returning user {}",returnedUser);
		return returnedUser;
	}

}
