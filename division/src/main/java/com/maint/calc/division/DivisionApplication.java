package com.maint.calc.division;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DivisionApplication {

    public static void main(String[] args) {
        if (args != null) System.out.println(args);
        SpringApplication.run(DivisionApplication.class, args);
    }

}
