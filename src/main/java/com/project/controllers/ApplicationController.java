package com.project.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.emailUtils.EmailSender;
import com.project.entities.User;
import com.project.services.UserServiceImpl;

@RestController
@RequestMapping("/app")
public class ApplicationController {

	public static Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	EmailSender sender;

	// to add user -> http://localhost:9100/app/test
	@SuppressWarnings("static-access")
	@RequestMapping("/test")
	@CrossOrigin
	public boolean testApp() throws IOException {
		logger.info("Testing app health ");
		sender.sendTestMessage();
		return true;
	}

}
