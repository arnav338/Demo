package com.project.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.entities.MealDetails;

@Repository
@Transactional
public interface MealDetailsRepo extends JpaRepository<MealDetails, Integer> {
	
	public List<MealDetails> findByUserEmail(String userEmail);
	
}