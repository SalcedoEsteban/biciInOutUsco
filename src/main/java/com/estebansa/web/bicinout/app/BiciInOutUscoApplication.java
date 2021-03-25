package com.estebansa.web.bicinout.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BiciInOutUscoApplication
{
	/* se registra el RestTemplate en el contenedor de sring  */
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BiciInOutUscoApplication.class, args);
	}

}
