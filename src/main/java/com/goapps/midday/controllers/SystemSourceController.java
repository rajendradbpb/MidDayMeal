package com.goapps.midday.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goapps.midday.entity.SystemSourceEntity;
import com.goapps.midday.service.SystemSourceService;

@RestController
public class SystemSourceController {

	private static final Logger LOGGER = LogManager.getLogger(SystemSourceController.class);
	@Autowired
	SystemSourceService systemSourceService;
	
	@PostMapping("/systemSource")
	ResponseEntity<?> saveSystemSource(@Validated @RequestBody SystemSourceEntity systemSourceEntity) {
		SystemSourceEntity savedData = null;
		try {
			LOGGER.info(systemSourceEntity.toString());
			savedData = systemSourceService.saveSystemSource(systemSourceEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@GetMapping("/systemSource")
	ResponseEntity<?> getAllSystemSource(@RequestParam(required = false) String cPurpose, @RequestParam(required = false)  Long iIdParent) {
		List<SystemSourceEntity> list = null;
		try {
			if(cPurpose == null && iIdParent == null)
				list = systemSourceService.getAllSystemSource();
			else if(cPurpose != null && iIdParent == null)
				list = systemSourceService.findBycPurpose(cPurpose);
			else if(cPurpose != null && iIdParent != null)
				list = systemSourceService.findBycPurposeAndiIdParent(cPurpose, iIdParent);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
