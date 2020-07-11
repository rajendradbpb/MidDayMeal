package com.goapps.midday.controllers;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.mesasge.UserExceptionMessage;
import com.goapps.midday.service.SchoolService;
import com.goapps.midday.service.UserService;
import com.goapps.midday.utitlity.BeanFactory;
import com.goapps.midday.valueobject.UserRequestVO;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@Autowired
	UserExceptionMessage userExceptionMessage;
	
	@Autowired
	BeanFactory beanFactory;
	
	@Autowired
	SchoolService schoolService; 
	
	@PostMapping("/user")
	ResponseEntity<?> saveUser(@Validated @RequestBody UserEntity userEntity) {
		UserEntity savedData = null;
		try {
			
			LOGGER.info(userEntity.toString());
			savedData = userService.saveUser(userEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@GetMapping("/user")
	ResponseEntity<?> getAllUser(@RequestParam(required = false) Long id) {
		try {
			if(id == null)
				return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
//			else if(id != null)
//				return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
