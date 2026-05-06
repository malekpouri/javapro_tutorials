package ir.javapro.deprman_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest APIs",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Mohammad Malekpouri",
						email = "m.malekpoor@gmail.com",
						url = "https://www.javapro.ir"
				)
		)
)
@SpringBootApplication
@EnableDiscoveryClient
public class DeprmanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeprmanServiceApplication.class, args);
	}

}
