package com.maint.calc.discovery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

    private static Logger logger = LogManager.getLogger(DiscoveryApplication.class);
    public static void main(String[] args) {
        if (args != null) logger.warn("argumentos: " + Arrays.toString(args));
        SpringApplication.run(DiscoveryApplication.class, args);
    }

}
