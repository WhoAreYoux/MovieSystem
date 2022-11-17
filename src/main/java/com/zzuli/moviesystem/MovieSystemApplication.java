package com.zzuli.moviesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MovieSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSystemApplication.class, args);
    }

}
