package com.goapps.midday.mesasge;

public class UserMessage {

	private String idRequired;
	private String passwordRequired;
	private String usernameRequired;
	private String rollIdRequired;
	private String schoolIdRequired;
	private String passwordConfirmPasswordNotMatched;
	public UserMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdRequired() {
		return idRequired;
	}
	public void setIdRequired(String idRequired) {
		this.idRequired = idRequired;
	}
	public String getUsernameRequired() {
		return usernameRequired;
	}
	public void setUsernameRequired(String usernameRequired) {
		this.usernameRequired = usernameRequired;
	}
	public String getRollIdRequired() {
		return rollIdRequired;
	}
	public void setRollIdRequired(String rollIdRequired) {
		this.rollIdRequired = rollIdRequired;
	}
	public String getSchoolIdRequired() {
		return schoolIdRequired;
	}
	public void setSchoolIdRequired(String schoolIdRequired) {
		this.schoolIdRequired = schoolIdRequired;
	}
	public String getPasswordRequired() {
		return passwordRequired;
	}
	public void setPasswordRequired(String passwordRequired) {
		this.passwordRequired = passwordRequired;
	}
	public String getPasswordConfirmPasswordNotMatched() {
		return passwordConfirmPasswordNotMatched;
	}
	public void setPasswordConfirmPasswordNotMatched(String passwordConfirmPasswordNotMatched) {
		this.passwordConfirmPasswordNotMatched = passwordConfirmPasswordNotMatched;
	}
	
	
}
