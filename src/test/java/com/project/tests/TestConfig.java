package com.project.tests;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.project.Application;

@Configuration
@ComponentScan(basePackages = {
		"com.project"
},
basePackageClasses = Application.class,
value = "com.project")
public class TestConfig {

}

