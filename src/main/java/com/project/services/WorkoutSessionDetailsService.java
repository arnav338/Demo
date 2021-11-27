package com.project.services;

import java.util.List;

import com.project.entities.WorkoutSessionDetails;

public interface WorkoutSessionDetailsService {
	
	boolean saveWorkoutSession(WorkoutSessionDetails workout);

	List<WorkoutSessionDetails> loadAllWorkoutSessions(WorkoutSessionDetails workout);
	
	
}
