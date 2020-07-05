package com.goapps.midday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.goapps.midday")
@EntityScan("com.goapps.midday.entity")
public class MidDayMealApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidDayMealApplication.class, args);
	}

}
