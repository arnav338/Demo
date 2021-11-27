package com.project.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.entities.WorkoutSessionDetails;

@Repository
@Transactional
public interface WorkoutSessionDetailsRepo extends JpaRepository<WorkoutSessionDetails, Integer> {
	
	public List<WorkoutSessionDetails> findByUserEmail(String userEmail);
	
}
