package com.project;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.emailUtils.EmailSender;


@SpringBootApplication
@ComponentScan(basePackages = { "com.project.controllers",
        						"com.project.entities",
        						"com.project.emailUtils",
        						"com.project.services" })
@EnableJpaRepositories(basePackages = {"com.project.repositories"})
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	private static EmailSender sender;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(Application.class, args);
		//sender.sendWelcomeMessage();
	}

}

