package com.zpavel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VireeApplication {

    public static void main(String[] args) {
        SpringApplication.run(VireeApplication.class, args);
    }
}
