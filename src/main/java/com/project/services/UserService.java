package com.project.services;


import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.entities.User;

public interface UserService {
	
	boolean signupUser(User employee);

	List<User> getAllUsers();
	
	User findByEmail(String email);

	String loginUser(User user);
	
	User updateUserById(int id, String firstName, String lastName, String gender, String email, String contactNumber, String password);
	
}
