package com.goapps.midday.mesasge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("message.properties")
@ConfigurationProperties(prefix = "message")
public class MessageConfiguration {
	private ImageMessage imageMessage;
	private UserMessage userMessage;
	public MessageConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImageMessage getImageMessage() {
		return imageMessage;
	}
	public void setImageMessage(ImageMessage imageMessage) {
		this.imageMessage = imageMessage;
	}
	public UserMessage getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}
	
	
}
