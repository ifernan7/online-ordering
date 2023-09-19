package com.online_ordering.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//note: This shows me real exceptions!
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class} )
@ComponentScan(basePackages = {"com.online_ordering.*"})
@EnableJpaRepositories(basePackages = "com.online_ordering.repository")
@EntityScan("com.online_ordering.domain")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}