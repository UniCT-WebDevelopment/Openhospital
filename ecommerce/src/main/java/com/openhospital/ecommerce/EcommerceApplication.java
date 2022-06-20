package com.openhospital.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.openhospital.ecommerce"})
public class EcommerceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
