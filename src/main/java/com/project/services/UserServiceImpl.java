package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.project.entities.User;
import com.project.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Service
public class UserServiceImpl implements UserService{
	
	public static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserRepo userRepo;

	@Override
	public boolean signupUser(User user) {
		boolean userExists = false;
		try {
			logger.info("Trying to add user : {}",user);
			userExists = checkIfUserExists(user);
			if(userExists) {
				logger.info("User already exists");
				System.out.println("User already exists");
				return false;
			}
			else {
				logger.info("Verification successful. No user exists with this email. Adding new user");
				userRepo.save(user);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public String loginUser(User user) {
		boolean userExists = false;
		User returnedUser = new User();
		String authenticationMessage=null;
		try {
			logger.info("Trying to login user : {}",user);
			userExists = checkIfUserExists(user);
			if(userExists) {
				logger.info("User exists. Will authenticate password");
				returnedUser = findByEmail(user.getEmail());
				if(returnedUser.getPassword().contentEquals(user.getPassword())) {
					logger.info("Password matched");
					authenticationMessage = "Password matched";
				}
				else {
					logger.info("Password authentication failed");
					authenticationMessage = "Password authentication failed";
				}
			}
			else {
				logger.info("User with this email doesnt exists");
				authenticationMessage =  "User with this email doesnt exists";
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return authenticationMessage;
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> listOfEmployees= new ArrayList<>();
		
		try {
			logger.info("Fetching all employees");
			listOfEmployees = userRepo.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return listOfEmployees;
	}


	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	@SuppressWarnings("deprecation")
	public boolean checkIfUserExists(User user) {
		User returnedUser = new User();
		logger.info("Checking if user with email id {} exists",user.getEmail());
		returnedUser = findByEmail(user.getEmail());
		if(ObjectUtils.isEmpty(returnedUser)) {
			return false;
		}
		boolean existFlag = !StringUtils.isEmpty(returnedUser.getId()) ? true : false;
		return existFlag;
	}

	@Override
	public User updateUserById(int id, String firstName, String lastName, String gender, String email,
			String contactNumber, String password) {
		logger.info("Updating user {}",firstName);
		User returnedUser = new User();
		userRepo.updateUserById(id, firstName, lastName, gender, email, contactNumber, password);
		return returnedUser;
	}
	

}
