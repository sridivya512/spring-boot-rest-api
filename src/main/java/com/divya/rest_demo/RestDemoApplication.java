package com.divya.rest_demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Cloud Vendor API Application",
				description = "Cloud Vendor Documentation",
				version = "1.0",
				contact = @Contact(
						name = "Sridivya",
						url = "www.example.com",
						email = "test@example.com"
				)
		)
)
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

}
