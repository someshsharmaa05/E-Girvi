package com.Byteforce.E_girvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "E-Girvi",
				version = "1.0.1",
				description = "this project is for Jwellers",
				termsOfService = "mind your own code",
				contact = @Contact(
						name = "Somesh Sharma",
						email = "someshsharmaa05@gmail.com"
				),
				license = @License(
						name = "license",
						url = "E-girvi.com"
				)
		)
)
public class EGirviApplication {

	public static void main(String[] args) {
		SpringApplication.run(EGirviApplication.class, args);
	}

}
