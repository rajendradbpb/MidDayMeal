package com.goapps.midday.valueobject;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.goapps.midday.entity.SchoolEntity;

public class UserRequestVO {
	private String username;
	private String password;
//	private List<String> roles;
	private String firstName;
	private String lastname;
	private String middleName;
	private String status;
	private Long iIdCreatedBy;
	private Date dEffectiveDate;
	private Date dExpiryDate;
	private Long schoolId;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public List<String> getRoles() { return roles; } public void
	 * setRoles(List<String> roles) { this.roles = roles; }
	 */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getiIdCreatedBy() {
		return iIdCreatedBy;
	}
	public void setiIdCreatedBy(Long iIdCreatedBy) {
		this.iIdCreatedBy = iIdCreatedBy;
	}
	public Date getdEffectiveDate() {
		return dEffectiveDate;
	}
	public void setdEffectiveDate(Date dEffectiveDate) {
		this.dEffectiveDate = dEffectiveDate;
	}
	public Date getdExpiryDate() {
		return dExpiryDate;
	}
	public void setdExpiryDate(Date dExpiryDate) {
		this.dExpiryDate = dExpiryDate;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	
}
