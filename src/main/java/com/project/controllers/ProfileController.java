package com.project.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.User;
import com.project.services.UserServiceImpl;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	public static Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	UserServiceImpl userServiceImpl;

	// to add user -> http://localhost:9100/profile/editUser
	@RequestMapping("/editUser")
	@CrossOrigin
	public boolean registerUser(@RequestBody User user) throws IOException {
		logger.info("Received request to edit user {} ", user);
		User returnedUser = new User();
		if(userServiceImpl.checkIfUserExists(user)) {
			returnedUser = userServiceImpl.updateUserById(user.getId(), user.getFirstName(), user.getLastName(), user.getGender(), user.getEmail(), user.getContactNumber(), user.getPassword());
			return true;
		}
		return false;
	}

}
