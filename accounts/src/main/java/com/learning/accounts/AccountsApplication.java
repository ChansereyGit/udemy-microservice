package com.learning.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Management System for Microservice",
                description = "A simple RESTful API for managing bank accounts",
				version = "v1",
				contact = @Contact(
						name = "author",
						email = "john.doe@example.com",
                        url = "https://www.example.com"
				),
				license = @License(
						name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Accounts microservice Rest API documentation",
				url = "https://www.example.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
