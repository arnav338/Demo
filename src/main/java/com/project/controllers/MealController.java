package com.project.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.MealDetails;
import com.project.services.MealDetailsServiceImpl;

@RestController
@RequestMapping("/meal")
public class MealController {
	
	public static Logger logger = LoggerFactory.getLogger(MealController.class);
	
	@Autowired
	MealDetailsServiceImpl mealServiceImpl;
	
	// to save meal -> http://localhost:9100/meal/saveMeal
	@RequestMapping("/saveMeal")
	@CrossOrigin
	public boolean saveMeal(@RequestBody MealDetails meal) throws IOException{
		logger.info("Received request to save meal {} ",meal);
		boolean authenticationFlag = mealServiceImpl.saveMeal(meal);
		return authenticationFlag ? true : false;
		
	}
	
	// to load meals -> http://localhost:9100/meal/loadAllMeals
	@RequestMapping("/loadAllMeals")
	@CrossOrigin
	public List<MealDetails> loadAllMeals(@RequestBody MealDetails meal) throws IOException{
		logger.info("Received request to load all meals for user with mail - {} ",meal.getUserEmail());
		List<MealDetails> returnedMeals = new ArrayList<MealDetails>();
		returnedMeals =  mealServiceImpl.loadAllMeals(meal);
		return returnedMeals;
		
	}
}
