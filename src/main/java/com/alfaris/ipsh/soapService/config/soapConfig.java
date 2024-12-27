package com.alfaris.ipsh.soapService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class soapConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
		marshaller.setPackagesToScan("com.alfaris.ipsh.consumessoapservice");
		return marshaller;
	}

}
