package com.sb_ss_myb.frame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ="com.sb_ss_myb.frame")
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		// ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}

}
