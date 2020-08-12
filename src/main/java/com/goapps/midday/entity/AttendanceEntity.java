package com.goapps.midday.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attendance")
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceEntity {

	@Id
	@Column(name = "attendanceId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Long mealId;
	@Column(nullable = false)
	private Long schoolId;
	
	@Column(nullable = false)
	private Long userId;
	
	
	
	// student
	private Long classId;
	private Long sectionId;
	private Boolean isPresent;
	private Boolean bookedMeal;
	private Boolean confirmedMeal;
	private String noMealCause;
	
	//cook
	private String cookImage;
	
//	@Column(nullable = false)
	private Long updatedBy;
	
	@Column(nullable = false)
	private Date attendanceDate;

	
	@PrePersist
	void preInsert() {
	   if (this.getAttendanceDate() == null)
	       this.setAttendanceDate(new Date());
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Boolean getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(Boolean isPresent) {
		this.isPresent = isPresent;
	}

	public Boolean getBookedMeal() {
		return bookedMeal;
	}

	public void setBookedMeal(Boolean bookedMeal) {
		this.bookedMeal = bookedMeal;
	}

	public Boolean getConfirmedMeal() {
		return confirmedMeal;
	}

	public void setConfirmedMeal(Boolean confirmedMeal) {
		this.confirmedMeal = confirmedMeal;
	}

	public String getNoMealCause() {
		return noMealCause;
	}

	public void setNoMealCause(String noMealCause) {
		this.noMealCause = noMealCause;
	}

	public String getCookImage() {
		return cookImage;
	}

	public void setCookImage(String cookImage) {
		this.cookImage = cookImage;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	
	
}
