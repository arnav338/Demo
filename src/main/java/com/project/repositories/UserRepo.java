package com.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.User;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
	@Modifying
    @Query("UPDATE User user SET user.firstName = :firstName, user.lastName = :lastName,user.gender = :gender,user.email = :email,user.contactNumber = :contactNumber,user.password = :password WHERE user.id = :id")
	public void updateUserById(@Param("id") int id,@Param("firstName") String firstName,@Param("lastName") String lastName,
						@Param("gender") String gender,@Param("email") String email,@Param("contactNumber") String contactNumber,
						@Param("password") String password);
	
}
