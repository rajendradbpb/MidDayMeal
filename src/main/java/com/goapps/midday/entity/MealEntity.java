package com.goapps.midday.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.goapps.midday.exception.InvalidRequestException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Meal")
@NoArgsConstructor
@AllArgsConstructor
public class MealEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mealId")
	private Long id;
	
	
	@Column(nullable = false)
	private Long schoolId;
	
	private Date mealDate;
	private Boolean isCook;
	private String noCookCause;
	private String imageBeforeCook;
	private String imageAfterCook;
	private String rationImage;
	
	@PrePersist
	void preInsert() {
	   if (this.getMealDate() == null)
	       this.setMealDate(new Date());
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getRationImage() {
		return rationImage;
	}
	public void setRationImage(String rationImage) {
		this.rationImage = rationImage;
	}
	public Date getMealDate() {
		return mealDate;
	}
	public void setMealDate(Date mealDate) {
		this.mealDate = mealDate;
	}
	public Boolean getIsCook() {
		return isCook;
	}
	public void setIsCook(Boolean isCook) {
		this.isCook = isCook;
	}
	public String getNoCookCause() {
		return noCookCause;
	}
	public void setNoCookCause(String noCookCause) {
		this.noCookCause = noCookCause;
	}
	public String getImageBeforeCook() {
		return imageBeforeCook;
	}
	public void setImageBeforeCook(String imageBeforeCook) {
		this.imageBeforeCook = imageBeforeCook;
	}
	public String getImageAfterCook() {
		return imageAfterCook;
	}
	public void setImageAfterCook(String imageAfterCook) {
		this.imageAfterCook = imageAfterCook;
	}
	
}
