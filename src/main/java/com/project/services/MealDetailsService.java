package com.project.services;


import java.util.List;

import com.project.entities.MealDetails;
import com.project.entities.User;

public interface MealDetailsService {
	
	List<MealDetails> findAllById();

	boolean saveMeal(MealDetails meal);
	
	public List<MealDetails> loadAllMeals(MealDetails meal);
	
	
}
