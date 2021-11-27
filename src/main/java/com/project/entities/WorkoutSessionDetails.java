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
@Table(name = "workout_session_details")
public class WorkoutSessionDetails {

	public WorkoutSessionDetails() {
		super();
	}
	
	public WorkoutSessionDetails(int workoutSessionId,
			@NotBlank(message = "Workout type can not be empty") String workoutType,
			@NotBlank(message = "Calorie count can not be empty") String calorieSpent,
			@NotBlank(message = "Max heart beat can not be empty") String maxHeartBeat,
			@NotBlank(message = "Average heart beat can not be empty") String avgHeartBeat,
			@NotBlank(message = "Fat value can not be empty") String fatBurnt, @NotBlank String userEmail) {
		super();
		this.workoutSessionId = workoutSessionId;
		this.workoutType = workoutType;
		this.calorieSpent = calorieSpent;
		this.maxHeartBeat = maxHeartBeat;
		this.avgHeartBeat = avgHeartBeat;
		this.fatBurnt = fatBurnt;
		this.userEmail = userEmail;
	}

	@Id
	@SequenceGenerator(name = "sequenceForWorkoutId",sequenceName = "sequenceForWorkoutId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceForWorkoutId")
	private int workoutSessionId;
	
	@Column
	@NotBlank(message = "Workout type can not be empty")
	private String workoutType;
	
	@Column
	@NotBlank(message = "Calorie count can not be empty")
	private String calorieSpent;
	
	@Column
	@NotBlank(message = "Max heart beat can not be empty")
	private String maxHeartBeat;
	
	@Column
	@NotBlank(message = "Average heart beat can not be empty")
	private String avgHeartBeat;
	
	@Column
	@NotBlank(message = "Fat value can not be empty")
	private String fatBurnt;
	
	@Column
	@NotBlank
	private String userEmail;

	@Override
	public String toString() {
		return "WorkoutSessionDetails [workoutSessionId=" + workoutSessionId + ", workoutType=" + workoutType
				+ ", calorieSpent=" + calorieSpent + ", maxHeartBeat=" + maxHeartBeat + ", avgHeartBeat=" + avgHeartBeat
				+ ", fatBurnt=" + fatBurnt + ", userEmail=" + userEmail + "]";
	}

	public int getWorkoutSessionId() {
		return workoutSessionId;
	}

	public void setWorkoutSessionId(int workoutSessionId) {
		this.workoutSessionId = workoutSessionId;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}

	public String getCalorieSpent() {
		return calorieSpent;
	}

	public void setCalorieSpent(String calorieSpent) {
		this.calorieSpent = calorieSpent;
	}

	public String getMaxHeartBeat() {
		return maxHeartBeat;
	}

	public void setMaxHeartBeat(String maxHeartBeat) {
		this.maxHeartBeat = maxHeartBeat;
	}

	public String getAvgHeartBeat() {
		return avgHeartBeat;
	}

	public void setAvgHeartBeat(String avgHeartBeat) {
		this.avgHeartBeat = avgHeartBeat;
	}

	public String getFatBurnt() {
		return fatBurnt;
	}

	public void setFatBurnt(String fatBurnt) {
		this.fatBurnt = fatBurnt;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
}
