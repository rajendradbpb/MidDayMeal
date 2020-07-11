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

import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.service.SchoolService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
public class SchoolController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);
	@Autowired
	SchoolService schoolService;
	
	
	@PostMapping("/school")
	@ApiOperation(value = "Finds Pets by status",
    notes = "Multiple status values can be provided with comma seperated strings",
    response = SchoolEntity.class)
	ResponseEntity<?> saveSystemSource(@Validated @RequestBody SchoolEntity schoolEntity) {
		SchoolEntity savedData = null;
		try {
			LOGGER.info(schoolEntity.toString());
			savedData = schoolService.saveSchool(schoolEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@GetMapping("/school")
	ResponseEntity<?> getAllSystemSource(@RequestParam(required = false) Long id) {
		try {
			if(id == null)
				return new ResponseEntity<>(schoolService.getAllSchool(), HttpStatus.OK);
			else if(id != null)
				return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
