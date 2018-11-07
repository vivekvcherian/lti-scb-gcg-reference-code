package com.scb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate restClient = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory()));
		return restClient;
	}
	@Bean
	public ClientHttpRequestFactory clientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequesyFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequesyFactory.setConnectTimeout(60000);
		clientHttpRequesyFactory.setBufferRequestBody(false);
		clientHttpRequesyFactory.setReadTimeout(60000);
		return clientHttpRequesyFactory;
	}
	
	
}
