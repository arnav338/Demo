package com.project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorMappingController implements ErrorController {

	public static Logger logger = LoggerFactory.getLogger(ErrorMappingController.class);
	
	@RequestMapping("/error")
	@CrossOrigin
	public String handleError() {
		logger.info("Error page reached");
		return "!!! Under development !!!";
	}
	
	@Override
	public String getErrorPath() {
		return null;
	}

}
