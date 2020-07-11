package com.goapps.midday.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Meal")
public class MealEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iIdMeal;
	
	@Column(nullable = false)
	private Long iIdUser;
	@Column(nullable = false)
	private Long iIdSchool;
	
	private String receipes; // comma separeted values
	private Date dDate;
	private String groceries ;
	private String imageBeforeCook ;
	private String imageAfterCook;
	
	
	public MealEntity() {
	}
	public MealEntity(Long iIdMeal, Long iIdUser, Long iIdSchool, String receipes, Date dDate, String groceries,
			String imageBeforeCook, String imageAfterCook) {
		super();
		this.iIdMeal = iIdMeal;
		this.iIdUser = iIdUser;
		this.iIdSchool = iIdSchool;
		this.receipes = receipes;
		this.dDate = dDate;
		this.groceries = groceries;
		this.imageBeforeCook = imageBeforeCook;
		this.imageAfterCook = imageAfterCook;
	}
	
	@PrePersist
	void preInsert() {
	   if (this.getdDate() == null)
	       this.setdDate(new Date());
	   
	}
	public Long getiIdMeal() {
		return iIdMeal;
	}
	public void setiIdMeal(Long iIdMeal) {
		this.iIdMeal = iIdMeal;
	}
	public Long getiIdUser() {
		return iIdUser;
	}
	public void setiIdUser(Long iIdUser) {
		this.iIdUser = iIdUser;
	}
	public Long getiIdSchool() {
		return iIdSchool;
	}
	public void setiIdSchool(Long iIdSchool) {
		this.iIdSchool = iIdSchool;
	}
	public String getReceipes() {
		return receipes;
	}
	public void setReceipes(String receipes) {
		this.receipes = receipes;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	public String getGroceries() {
		return groceries;
	}
	public void setGroceries(String groceries) {
		this.groceries = groceries;
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
