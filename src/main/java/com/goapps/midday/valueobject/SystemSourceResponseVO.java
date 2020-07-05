package com.goapps.midday.valueobject;

import java.io.Serializable;
import java.util.Date;

public class SystemSourceResponseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long cPurpose;
	private String cDescription;
	public SystemSourceResponseVO(Long id, Long cPurpose, String cDescription) {
		super();
		this.id = id;
		this.cPurpose = cPurpose;
		this.cDescription = cDescription;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getcPurpose() {
		return cPurpose;
	}
	public void setcPurpose(Long cPurpose) {
		this.cPurpose = cPurpose;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	
	
	
}
