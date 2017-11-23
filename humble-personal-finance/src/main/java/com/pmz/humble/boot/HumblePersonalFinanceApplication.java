package com.pmz.humble.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.pmz.humble")
public class HumblePersonalFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumblePersonalFinanceApplication.class, args);
	}
}
