package com.goapps.midday.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.service.SchoolService;
import com.goapps.midday.service.UserService;
import com.goapps.midday.utitlity.ImageProcessing;

@RestController
public class TodoController implements Runnable{

	Logger LOG = LoggerFactory.getLogger(TodoController.class);
	@Autowired
	ImageProcessing imageProcessingBean;
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/todo/createImage")
	public void createImage() {
		//imageProcessingBean.createImageFromBase64();
	}
	@GetMapping("/todo/run")
	public void doRun() {
		run();
	}
	@Override
	public void run() {
		LOG.info("saving school data");
		// save school data
		
	}
	
	
}
