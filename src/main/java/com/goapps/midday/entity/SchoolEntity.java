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

@Entity
@Table(name= "school")
public class SchoolEntity {

	@Id
	@Column(name = "iIdSchool")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String cName;
	@NotNull
	private String cCountry;
	@NotNull
	private String cState;
	private String cCity;
	private String cPinCode;
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

	public SchoolEntity(String cName, String cCountry, String cState) {
		super();
		this.cName = cName;
		this.cCountry = cCountry;
		this.cState = cState;
	}
	
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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcCountry() {
		return cCountry;
	}

	public void setcCountry(String cCountry) {
		this.cCountry = cCountry;
	}

	public String getcState() {
		return cState;
	}

	public void setcState(String cState) {
		this.cState = cState;
	}

	public String getcCity() {
		return cCity;
	}

	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	public String getcPinCode() {
		return cPinCode;
	}

	public void setcPinCode(String cPinCode) {
		this.cPinCode = cPinCode;
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
