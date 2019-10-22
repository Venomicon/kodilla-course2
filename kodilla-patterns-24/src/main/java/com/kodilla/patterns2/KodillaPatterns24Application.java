package com.kodilla.patterns2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class KodillaPatterns24Application {

    public static void main(String[] args) {
        SpringApplication.run(KodillaPatterns24Application.class, args);
    }

}
