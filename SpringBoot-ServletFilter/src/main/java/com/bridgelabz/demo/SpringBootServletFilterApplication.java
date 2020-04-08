package com.bridgelabz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * MAin intention of this example is to understand the  working
 * of servlet filter
 * If we dint use @Restcontroller we will gwt whitelable page error
 * 
 * @author chaithra
 *
 */
@SpringBootApplication
@RestController   
public class SpringBootServletFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServletFilterApplication.class, args);
	}
	@RequestMapping(value= "/")
public String hello() {
		return "Hello World";
	}
}
