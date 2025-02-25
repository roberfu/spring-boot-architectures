package cl.springmachine.clean.infrastructure.external;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExternalClientConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
