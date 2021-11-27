package com.project.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user_details")
public class User {
	
	public User() {}
	
	
	
	public User(int id,
			@NotBlank(message = "First name should not be empty") @Length(min = 2, max = 50, message = "First Name should be between 2 and 50 characters") String firstName,
			@NotBlank(message = "Last name should not be empty") @Length(min = 2, max = 50, message = "Last Name should be between 2 and 50 characters") String lastName,
			@NotBlank(message = "Gender should not be empty") String gender,
			@NotBlank(message = "Email should not be empty") String email,
			@NotBlank(message = "Contact number should not be empty") String contactNumber,
			@NotBlank(message = "Password should not be empty") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
	}



	@Id
	@SequenceGenerator(name = "sequenceForUserId",sequenceName = "sequenceForUserId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceForUserId")
	private int id;
	
	@Column
	@NotBlank(message = "First name should not be empty")
	@Length(min = 2, max = 50, message = "First Name should be between 2 and 50 characters")
	private String firstName;
	
	@Column
	@NotBlank(message = "Last name should not be empty")
	@Length(min = 2, max = 50, message = "Last Name should be between 2 and 50 characters")
	private String lastName;
	
	@Column
	@NotBlank(message = "Gender should not be empty")
	private String gender;
	
	@Column
	@NotBlank(message = "Email should not be empty")
	private String email;
	
	@Column
	@NotBlank(message = "Contact number should not be empty")
	private String contactNumber;
	
	@Column
	@NotBlank(message = "Password should not be empty")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
	
}
