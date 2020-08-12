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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goapps.midday.config.AppConstants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false,unique = true)
	private String username;
	
	@Column(nullable = false)
	@JsonIgnore
	private String password;
	
	private long schoolId;
	private long roleId;

	@Column(nullable = false)
	private String firstName;
	private String lastname;
	private String middleName;
	
	private String email;
	private String phone;
	private String alternatePhone;
	// teacher
	private String isClassTeacher;
	private Long classId;
	private Long sectionId;
	
	// student
	private String fatherName;
	private String motherName;
	private String parentContactNo;
	
	//bank
	private String bankAccNo;
	private String ifsc;
	
	//address
	private String plotNo;
	private String street;
	private String city;
	private String village;
	private String state;
	private String district;
	private String country;
	private String pincode;
	
	private String status;
	private Long iIdCreatedBy;
	private Date dEffectiveDate;
	private Date dExpiryDate;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(String username, String password, long schoolId, long roleId, String firstName) {
		super();
		this.username = username;
		this.password = password;
		this.schoolId = schoolId;
		this.roleId = roleId;
		this.firstName = firstName;
	}
	@PrePersist
	void preInsert() {
	   if (this.dEffectiveDate == null)
	       this.dEffectiveDate = new Date();
	   
	   if (this.dExpiryDate == null)
		   this.dExpiryDate = new Date("01/01/2099");
	   
	   if(status == null)
		   this.status = AppConstants.STATUS_INACTIVE;
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
	
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAlternatePhone() {
		return alternatePhone;
	}
	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}
	public String getIsClassTeacher() {
		return isClassTeacher;
	}
	public void setIsClassTeacher(String isClassTeacher) {
		this.isClassTeacher = isClassTeacher;
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getParentContactNo() {
		return parentContactNo;
	}
	public void setParentContactNo(String parentContactNo) {
		this.parentContactNo = parentContactNo;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	
	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
