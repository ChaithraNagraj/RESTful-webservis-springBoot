package com.bridgelabz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
/**
 * Rest Template is used to create application that consume Restful web services,
 *   Here we can get to know the implementation or use of REst template
 * @author admin
 *
 */
@SpringBootApplication
//@ComponentScan(basePackages="com.bridgelabz.demo.controller")
public class SpringBootRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestTemplateApplication.class, args);
	}
}
	/**@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	}**/