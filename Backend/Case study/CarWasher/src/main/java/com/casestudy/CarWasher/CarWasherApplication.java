package com.casestudy.CarWasher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarWasherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWasherApplication.class, args);
	}

}
