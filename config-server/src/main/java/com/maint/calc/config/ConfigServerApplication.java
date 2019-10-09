package com.maint.calc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        if (args != null) System.out.println(args);
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
