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
@Table(name="SystemSource")
public class SystemSourceEntity {

	@Id
	@Column(name = "systemSourceId",nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String cPurpose;
	
	@Column(nullable = false)
	private String cValue;
	
	public String getcValue() {
		return cValue;
	}
	public void setcValue(String cValue) {
		this.cValue = cValue;
	}
	private String cDescription;
	private String cDay;
	private Date dEffectiveDate;
	private Date dExpiryDate;

	private Long iIdParent;
	
	@PrePersist
	void preInsert() {
	   if (this.dEffectiveDate == null)
	       this.dEffectiveDate = new Date();
	   
	   if (this.dExpiryDate == null)
		   this.dExpiryDate = new Date("01/01/2099");
	   
	   
	}
	public SystemSourceEntity(String cPurpose, String cValue) {
		super();
		this.cPurpose = cPurpose;
		this.cValue = cValue;
	}
	
	public SystemSourceEntity() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getcPurpose() {
		return cPurpose;
	}
	public void setcPurpose(String cPurpose) {
		this.cPurpose = cPurpose;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	public String getcDay() {
		return cDay;
	}
	public void setcDay(String cDay) {
		this.cDay = cDay;
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
	public Long getiIdParent() {
		return iIdParent;
	}
	public void setiIdParent(Long iIdParent) {
		this.iIdParent = iIdParent;
	}
	@Override
	public String toString() {
		return "SystemSourceEntity [id=" + id + ", cPurpose=" + cPurpose + ", cValue=" + cValue + ", cDescription="
				+ cDescription + ", cDay=" + cDay + ", dEffectiveDate=" + dEffectiveDate + ", dExpiryDate="
				+ dExpiryDate + ", iIdParent=" + iIdParent + "]";
	}
	
	
	
	
}
