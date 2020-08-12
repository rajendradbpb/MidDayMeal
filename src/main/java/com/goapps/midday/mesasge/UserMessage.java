package com.goapps.midday.mesasge;

public class UserMessage {

	private String idRequired;
	private String passwordRequired;
	private String usernameRequired;
	private String rollIdRequired;
	private String schoolIdRequired;
	private String passwordConfirmPasswordNotMatched;
	private String invalidSchoolId;
	private String invalidNoCookCause;
	private String noCookMatched;
	public UserMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNoCookMatched() {
		return noCookMatched;
	}

	public void setNoCookMatched(String noCookMatched) {
		this.noCookMatched = noCookMatched;
	}

	public String getInvalidNoCookCause() {
		return invalidNoCookCause;
	}

	public void setInvalidNoCookCause(String invalidNoCookCause) {
		this.invalidNoCookCause = invalidNoCookCause;
	}

	public String getInvalidSchoolId() {
		return invalidSchoolId;
	}

	public void setInvalidSchoolId(String invalidSchoolId) {
		this.invalidSchoolId = invalidSchoolId;
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
