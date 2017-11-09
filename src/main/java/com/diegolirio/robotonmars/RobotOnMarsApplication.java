package com.diegolirio.robotonmars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RobotOnMarsApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(RobotOnMarsApplication.class, args);
	}
}
