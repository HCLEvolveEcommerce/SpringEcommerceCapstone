package com.hcl.ecommerce.Ecomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication

public class EvolveEcomerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolveEcomerceApplication.class, args);
	}

}
