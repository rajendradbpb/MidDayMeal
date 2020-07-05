package com.goapps.midday.valueobject;

import java.io.Serializable;
import java.util.Date;

public class SystemSourceRequestVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String cPurpose;
	private String cDescription;
	private String cDay;
	private Date dEffectiveDate;
	private Date dExpiryDate;
	private Long iIdParent;
	public SystemSourceRequestVO(String cPurpose, String cDescription, String cDay, Date dEffectiveDate,
			Date dExpiryDate, Long iIdParent) {
		super();
		this.cPurpose = cPurpose;
		this.cDescription = cDescription;
		this.cDay = cDay;
		this.dEffectiveDate = dEffectiveDate;
		this.dExpiryDate = dExpiryDate;
		this.iIdParent = iIdParent;
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
	
	
	
}
