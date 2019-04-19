package com.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.price")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class PricingLauncher {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PricingLauncher.class, args);
	}

}
