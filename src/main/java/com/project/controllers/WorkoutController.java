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

import com.project.entities.WorkoutSessionDetails;
import com.project.services.WorkoutSessionDetailsServiceImpl;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
	
	public static Logger logger = LoggerFactory.getLogger(WorkoutController.class);
	
	@Autowired
	WorkoutSessionDetailsServiceImpl workoutServiceImpl;
	
	// to save workout -> http://localhost:9100/workout/saveWorkout
	@RequestMapping("/saveWorkout")
	@CrossOrigin
	public boolean saveWorkout(@RequestBody WorkoutSessionDetails workout) throws IOException{
		logger.info("Received request to save Workout {} ",workout);
		boolean authenticationFlag = workoutServiceImpl.saveWorkoutSession(workout);
		return authenticationFlag ? true : false;
		
	}
	
	// to save workout -> http://localhost:9100/workout/showAllWorkouts
	@RequestMapping("/showAllWorkouts")
	@CrossOrigin
	public List<WorkoutSessionDetails> showAllWorkouts(@RequestBody WorkoutSessionDetails workout) throws IOException{
		logger.info("Received request to load all workouts for {} ",workout.getUserEmail());
		List<WorkoutSessionDetails> returenedWokouts = new ArrayList<WorkoutSessionDetails>();
		returenedWokouts = workoutServiceImpl.loadAllWorkoutSessions(workout);
		return returenedWokouts;
			
	}
	
	
	
	
}
