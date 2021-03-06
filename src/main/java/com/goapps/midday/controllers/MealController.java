package com.goapps.midday.controllers;

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

import com.goapps.midday.entity.MealEntity;
import com.goapps.midday.service.MealService;

@RestController
public class MealController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MealController.class);
	@Autowired
	MealService mealService;
	
	
	@PostMapping("/meal")
	ResponseEntity<?> saveSystemSource(@Validated @RequestBody MealEntity mealEntity) {
		MealEntity savedData = null;
		try {
			LOGGER.info(mealEntity.toString());
			savedData = mealService.saveMeal(mealEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@GetMapping("/meal")
	ResponseEntity<?> getAllMeal(@RequestParam(required = false) Long id) {
		try {
			if(id == null)
				return new ResponseEntity<>(mealService.getAllMeal(), HttpStatus.OK);
			else if(id != null)
				return new ResponseEntity<>(mealService.getMealById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
