package com.epam.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TheProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheProjectApplication.class, args);
    }
}
