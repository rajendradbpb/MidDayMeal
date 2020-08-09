package com.goapps.midday;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.repository.UserRepository;

@SpringBootApplication
//@ComponentScan("com.goapps.midday")
//@EntityScan("com.goapps.midday.entity")
public class MidDayMealApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUser() {
		List<UserEntity> users = Stream.of(
				new UserEntity ("java1", "password1", "first1", "last1", 1l),
				new UserEntity ("java2", "password2", "first2", "last2", 1l),
				new UserEntity ("java3", "password3", "first3", "last3", 1l)
				).collect(Collectors.toList());
//		userRepository.saveAll(users);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(MidDayMealApplication.class, args);
	}

}
