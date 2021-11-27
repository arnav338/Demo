package com.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "meal_details")
public class MealDetails {
	
	@Id
	@SequenceGenerator(name = "sequenceForMealId",sequenceName = "sequenceForMealId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceForMealId")
	private int mealId;
	
	@Column
	@NotBlank(message = "Meal type not be empty")
	private String mealType;
	
	@Column
	@NotBlank(message = "Calorie value should not be empty")
	private String calorieValue;
	
	@Column
	@NotBlank(message = "Protein value not be empty")
	private String proteinValue;
	
	@Column
	@NotBlank(message = "Fat value not be empty")
	private String fatValue;
	
	@Column
	private String userEmail;
	
	public MealDetails() {
		super();
	}

	public MealDetails(int mealId, @NotBlank(message = "Meal type not be empty") String mealType,
			@NotBlank(message = "Calorie value should not be empty") String calorieValue,
			@NotBlank(message = "Protein value not be empty") String proteinValue,
			@NotBlank(message = "Fat value not be empty") String fatValue, String userEmail) {
		super();
		this.mealId = mealId;
		this.mealType = mealType;
		this.calorieValue = calorieValue;
		this.proteinValue = proteinValue;
		this.fatValue = fatValue;
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "MealDetails [mealId=" + mealId + ", mealType=" + mealType + ", calorieValue=" + calorieValue
				+ ", proteinValue=" + proteinValue + ", fatValue=" + fatValue + ", userEmail=" + userEmail + "]";
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getCalorieValue() {
		return calorieValue;
	}

	public void setCalorieValue(String calorieValue) {
		this.calorieValue = calorieValue;
	}

	public String getProteinValue() {
		return proteinValue;
	}

	public void setProteinValue(String proteinValue) {
		this.proteinValue = proteinValue;
	}

	public String getFatValue() {
		return fatValue;
	}

	public void setFatValue(String fatValue) {
		this.fatValue = fatValue;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
