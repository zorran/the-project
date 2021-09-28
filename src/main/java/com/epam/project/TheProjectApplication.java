package com.epam.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EntityScan
public class TheProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheProjectApplication.class, args);
    }
}
