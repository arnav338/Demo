package com.project.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.project.entities.User;
import com.project.entities.WorkoutSessionDetails;
import com.project.repositories.WorkoutSessionDetailsRepo;

@Service
public class WorkoutSessionDetailsServiceImpl implements WorkoutSessionDetailsService {
	
	@Autowired
	WorkoutSessionDetailsRepo workoutRepo;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	public static Logger logger = LoggerFactory.getLogger(WorkoutSessionDetailsServiceImpl.class);


	@Override
	public boolean saveWorkoutSession(WorkoutSessionDetails workout) {
		WorkoutSessionDetails returenedWokout;
		User user = new User();
		user.setEmail(workout.getUserEmail());
		if(userServiceImpl.checkIfUserExists(user)) {
			try {
				logger.info("User exists, saving workout session {} for user {}",workout,user);
				returenedWokout = workoutRepo.save(workout);
				if(!ObjectUtils.isEmpty(returenedWokout)) {
					return true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	@Override
	public List<WorkoutSessionDetails> loadAllWorkoutSessions(WorkoutSessionDetails workout) {
		List<WorkoutSessionDetails> returenedWokouts = new ArrayList<WorkoutSessionDetails>();
		try {
			returenedWokouts = workoutRepo.findByUserEmail(workout.getUserEmail());
			logger.info("Found {} workouts",returenedWokouts.size());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return returenedWokouts;
	}
	
	
	
	
}
