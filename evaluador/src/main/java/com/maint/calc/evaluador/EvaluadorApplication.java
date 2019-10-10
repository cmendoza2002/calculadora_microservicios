package com.maint.calc.evaluador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EvaluadorApplication {

	private static Logger logger = LogManager.getLogger(EvaluadorApplication.class);

	public static void main(String[] args) {
		if (args != null) logger.warn("argumentos: " + Arrays.toString(args));
		SpringApplication.run(EvaluadorApplication.class, args);
	}

}
