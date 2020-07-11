package com.goapps.midday.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.goapps.midday.utitlity.ImageProcessing;

@Configuration
public class BeanConfiguration {

	@Bean
	public ImageProcessing imageProcessingBean() {
		return new ImageProcessing();
	}
}
