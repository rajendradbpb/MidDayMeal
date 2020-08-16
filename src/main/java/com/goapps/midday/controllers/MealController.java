package com.goapps.midday.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goapps.midday.entity.MealEntity;
import com.goapps.midday.mesasge.MessageConfiguration;
import com.goapps.midday.service.meal.MealService;
import com.goapps.midday.valueobject.meal.SaveMealVO;
import com.goapps.midday.valueobject.meal.TakeStudentAttendanceVO;

@RestController
public class MealController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MealController.class);
	@Autowired
	MealService mealService;
	
	@Autowired
	MessageConfiguration messageConfig;
	
	
	@PostMapping("/meal")// save meal with basic details
	ResponseEntity<?> saveMeal(@Validated @RequestBody SaveMealVO saveMealVO) {
		MealEntity meal = null;
		try {
			mealService.validateMealData(saveMealVO);
			meal = mealService.mapSaveMealVO(saveMealVO,"save");
			//process cook
			meal = mealService.processMealRequest(meal,saveMealVO);
//			meal = mealService.saveMeal(meal);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(meal, HttpStatus.OK);
	}
	
	@PutMapping("/meal/takeAttendance")// save meal with basic details
	ResponseEntity<?> takeAttendance(@Validated @RequestBody TakeStudentAttendanceVO takeStudentAttendanceVO) {
		try {
			mealService.takeAttendance(takeStudentAttendanceVO);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(messageConfig.getUserMessage().getDataUpdateSuccess(), HttpStatus.OK);
	}
	
	@PutMapping("/meal/confirmAttendance")// save meal with basic details
	ResponseEntity<?> confirmAttendance(@Validated @RequestBody TakeStudentAttendanceVO takeStudentAttendanceVO) {
		try {
			mealService.confirmAttendance(takeStudentAttendanceVO);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(messageConfig.getUserMessage().getDataUpdateSuccess(), HttpStatus.OK);
	}
	/*
	 * @PutMapping("/meal")// update meal with basic details ResponseEntity<?>
	 * updatedMeal(@Validated @RequestBody SaveMealVO saveMealVO) { MealEntity meal
	 * = null; try { meal = mealService.mapSaveMealVO(saveMealVO,"update");
	 * mealService.validateUserData(meal); meal = mealService.saveMeal(meal); }
	 * catch (Exception e) { LOGGER.error(e.getMessage()); return new
	 * ResponseEntity<>(e, HttpStatus.BAD_REQUEST); } return new
	 * ResponseEntity<>(meal, HttpStatus.OK); }
	 */
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
