package com.project.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.project.entities.MealDetails;
import com.project.repositories.MealDetailsRepo;
import com.project.repositories.UserRepo;

@Service
public class MealDetailsServiceImpl implements MealDetailsService {
	
public static Logger logger = LoggerFactory.getLogger(MealDetailsServiceImpl.class);
	
	@Autowired
	public MealDetailsRepo mealRepo;
	
	@Override
	public List<MealDetails> findAllById() {
		
		return null;
	}
	
	@Override
	public boolean saveMeal(MealDetails meal) {
		MealDetails returnedMeal;
		try {
			returnedMeal = mealRepo.save(meal);
			logger.info("Meal saved : "+returnedMeal);
			if(!ObjectUtils.isEmpty(returnedMeal)) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<MealDetails> loadAllMeals(MealDetails meal) {
		List<MealDetails> returnedMeals = new ArrayList<MealDetails>();
		try {
			returnedMeals = mealRepo.findByUserEmail(meal.getUserEmail());
			logger.info("Got {} meals ",returnedMeals.size());
			if(returnedMeals.size()==0) {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnedMeals;
	}
	
	
	
}
