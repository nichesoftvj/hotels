package com.pyt.supplier.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

	// this LoadBalanced annotation will enable ribbon client
	@Bean
	RestTemplate restTemplateRibbon() {
		// return new RestTemplate();
		return new RestTemplateBuilder().build();
	}

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
