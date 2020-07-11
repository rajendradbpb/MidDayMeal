package com.goapps.midday.mesasge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = "message.properties")
@ConfigurationProperties(prefix = "user.exception")
@Component
public class UserExceptionMessage {
	private String idRequired;
	private String usernameRequired;
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
	
	
	
}
