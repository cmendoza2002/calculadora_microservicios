package com.maint.calc.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    private static Logger logger = LogManager.getLogger(ConfigServerApplication.class);
    public static void main(String[] args) {
        if (args != null) logger.warn("argumentos: " + Arrays.toString(args));
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
