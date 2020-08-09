package com.goapps.midday.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "school")
@NoArgsConstructor
@AllArgsConstructor
public class SchoolEntity {

	@Id
	@Column(name = "schoolId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	@NotNull
	private String country;
	@NotNull
	private String state;
	
	private String city;
	private String pinCode;
	private double fLat;
	private double fLng;
	private Date dEffectiveDate;
	private Date dExpiryDate;
	
	/* @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserEntity> users;
	
	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	} */

	
	
	public SchoolEntity() {
		super();
	}

	@PrePersist
	void preInsert() {
		   if (this.dEffectiveDate == null)
		       this.dEffectiveDate = new Date();
		   
		   if (this.dExpiryDate == null)
			   this.dExpiryDate = new Date("01/01/2099");
		   
		   
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public double getfLat() {
		return fLat;
	}

	public void setfLat(double fLat) {
		this.fLat = fLat;
	}

	public double getfLng() {
		return fLng;
	}

	public void setfLng(double fLng) {
		this.fLng = fLng;
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
	
	
	
}
