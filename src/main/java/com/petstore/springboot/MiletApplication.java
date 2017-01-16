package com.petstore.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.petstore.springboot"})
public class MiletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiletApplication.class, args);
	}
}
