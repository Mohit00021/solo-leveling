package com.mo.sololeveling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SoloLevelingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoloLevelingApplication.class, args);
	}

}
