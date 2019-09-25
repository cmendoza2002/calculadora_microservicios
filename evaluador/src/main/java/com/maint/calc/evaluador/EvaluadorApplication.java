package com.maint.calc.evaluador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EvaluadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluadorApplication.class, args);
	}

}
