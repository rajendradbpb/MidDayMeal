package com.goapps.midday.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.InvalidRelationIdException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goapps.midday.entity.ClassEntity;
import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.entity.SectionEntity;
import com.goapps.midday.mesasge.MessageConfiguration;
import com.goapps.midday.service.SchoolService;
import com.goapps.midday.service.user.UserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
public class SchoolController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageConfiguration messageConfig;
	
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
	
	@GetMapping("/school/filter")
	ResponseEntity<?> getSchoolByFilter(@RequestParam(required = true) String filter, String username
			, Long id) throws InvalidRelationIdException{
		SchoolEntity schoolEntity = null;
		long schoolId;
		try {
			switch (filter) {
			case "userId":
				if(id == 0) {
					throw new InvalidRelationIdException(messageConfig.getUserMessage().getIdRequired());
				}
				 schoolId = userService.getUserById(id).getSchoolId();
				schoolEntity = schoolService.getSchoolById(schoolId);
				break;
			case "username":
				if(username == null) {
					throw new InvalidRelationIdException(messageConfig.getUserMessage().getUsernameRequired());
				}
				 schoolId = userService.getUserByUsername(username).getSchoolId();
				schoolEntity = schoolService.getSchoolById(schoolId);
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return new ResponseEntity<>(schoolEntity, HttpStatus.OK);
	}
	/* Start class api */
	@PostMapping("/school/class")
	@ApiOperation(value = "Saving class",
    notes = "class should have mapped with school",
    response = ClassEntity.class)
	ResponseEntity<?> saveClass(@Validated @RequestBody ClassEntity classEntity) {
		ClassEntity savedData = null;
		try {
			LOGGER.info(classEntity.toString());
			savedData = schoolService.saveClass(classEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	
	@GetMapping("/school/class/{schoolId}")
	@ApiOperation(value = "Get all class",response = ClassEntity.class)
	ResponseEntity<?> getAllClass(@PathVariable Long schoolId) {
		ClassEntity savedData = null;
		List<ClassEntity> classes = new ArrayList<ClassEntity>();
		try {
			classes = schoolService.getAllClass(schoolId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(classes, HttpStatus.OK);
	}
	
	@PostMapping("/school/class/section")
	@ApiOperation(value = "Saving section",
    response = SectionEntity.class)
	ResponseEntity<?> saveSection(@Validated @RequestBody SectionEntity sectionEntity) {
		SectionEntity savedData = null;
		try {
			savedData = schoolService.saveSection(sectionEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	
	@GetMapping("/school/class/section/{classId}")
	@ApiOperation(value = "Get all class",response = SectionEntity.class)
	ResponseEntity<?> getAllSection(@PathVariable Long classId) {
		List<SectionEntity> sectionList = new ArrayList<SectionEntity>();
		try {
			sectionList = schoolService.getAllSection(classId);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(sectionList, HttpStatus.OK);
	}
	/* end class api */
	
}
