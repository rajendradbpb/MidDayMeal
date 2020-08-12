package com.goapps.midday.valueobject.meal;

import java.util.Date;
import java.util.List;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SaveMealVO {

	@NotNull
	private Long schoolId;
	private Date mealDate;
	private Boolean isCook;
	private String noCookCause;
	
	// cook
	private List<CookInformation> cookInformation;
	private String imageBeforeCook;
	private String imageAfterCook;
	private String rationImage;
	
	
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
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
	public String getRationImage() {
		return rationImage;
	}
	public void setRationImage(String rationImage) {
		this.rationImage = rationImage;
	}
	
	

	public List<CookInformation> getCookInformation() {
		return cookInformation;
	}
	public void setCookInformation(List<CookInformation> cookInformation) {
		this.cookInformation = cookInformation;
	}



	@AllArgsConstructor
	@NoArgsConstructor
	public static class CookInformation{
		private long cookId;
		private String cookImage;
		public long getCookId() {
			return cookId;
		}
		public void setCookId(long cookId) {
			this.cookId = cookId;
		}
		public String getCookImage() {
			return cookImage;
		}
		public void setCookImage(String cookImage) {
			this.cookImage = cookImage;
		}
		
		
	}
}
