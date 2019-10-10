package com.maint.calc.division;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DivisionApplication {

    private static Logger logger = LogManager.getLogger(DivisionApplication.class);
    public static void main(String[] args) {
        if (args != null) logger.warn("argumentos: " + Arrays.toString(args));
        SpringApplication.run(DivisionApplication.class, args);
    }

}
