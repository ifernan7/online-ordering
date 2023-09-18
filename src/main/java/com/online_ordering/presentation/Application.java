package com.online_ordering.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

@SpringBootApplication
//note: This shows me real exceptions!
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class} )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}