package com.example.be_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(value="com.simple.jwt.security")
public class BeBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeBookApplication.class, args);
    }
}
