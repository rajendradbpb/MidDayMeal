package com.goapps.midday.valueobject.user;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SaveSchoolAdminUserVO {
	@NotNull
	private String username;
	@NotNull
	private String schoolName;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
