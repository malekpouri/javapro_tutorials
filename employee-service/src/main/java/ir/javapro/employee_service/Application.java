package ir.javapro.employee_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest APIs",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Mohammad Malekpouri",
						email = "m.malekpoor@gmail.com",
						url = "https://www.javapro.ir"
				)
		)
)
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Application {
//	@Bean
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	@Bean
	WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
