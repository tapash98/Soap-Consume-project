package com.alfaris.ipsh.soapService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootConsumeSoapServiceApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsumeSoapServiceApplication.class, args);
	}

}
