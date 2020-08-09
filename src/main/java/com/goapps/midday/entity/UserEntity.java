package com.goapps.midday.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {

	@Id
	@Column(name = "iIdUser")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false,unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private long schoolId;
//	private List<String> roles;
	@Column(nullable = false)
	private String firstName;
	private String lastname;
	private String middleName;
	private String status;
	private Long iIdCreatedBy;
	private Date dEffectiveDate;
	private Date dExpiryDate;
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity(String username, String password, String firstName, String lastname, Long iIdCreatedBy) {
		super();
		this.setUsername(username);
		this.password = password;
		this.firstName = firstName;
		this.lastname = lastname;
		this.iIdCreatedBy = iIdCreatedBy;
	}
	public UserEntity(String username, String password, String firstName, String lastname, Long iIdCreatedBy,long schoolId) {
		super();
		this.setUsername(username);
		this.password = password;
		this.firstName = firstName;
		this.lastname = lastname;
		this.iIdCreatedBy = iIdCreatedBy;
		this.schoolId = schoolId;
	}
	
	@PrePersist
	void preInsert() {
	   if (this.dEffectiveDate == null)
	       this.dEffectiveDate = new Date();
	   
	   if (this.dExpiryDate == null)
		   this.dExpiryDate = new Date("01/01/2099");
	   
	   if(status == null)
		   this.status = "Active";
	   
	   
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	/*
	 * public SchoolEntity getSchool() { return school; } public void
	 * setSchool(SchoolEntity school) { this.school = school; }
	 */
	public long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
