package com.goapps.midday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.goapps.midday")
//@EntityScan("com.goapps.midday.entity")
public class MidDayMealApplication {
	
	/*
	 * @PostConstruct public void initUser() { List<UserEntity> users = Stream.of(
	 * new UserEntity ("java1", "password1", "first1", "last1", 1l), new UserEntity
	 * ("java2", "password2", "first2", "last2", 1l), new UserEntity ("java3",
	 * "password3", "first3", "last3", 1l) ).collect(Collectors.toList());
	 * userRepository.saveAll(users);
	 * 
	 * }
	 */

	public static void main(String[] args) {
		SpringApplication.run(MidDayMealApplication.class, args);
	}

}
