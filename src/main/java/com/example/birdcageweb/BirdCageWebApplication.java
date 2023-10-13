package com.example.birdcageweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BirdCageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirdCageWebApplication.class, args);
    }

}
