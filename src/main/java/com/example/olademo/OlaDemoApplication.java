package com.example.olademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OlaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlaDemoApplication.class, args);
	}
}



