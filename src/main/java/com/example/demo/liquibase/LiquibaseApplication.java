package com.example.demo.liquibase;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@SpringBootApplication
public class LiquibaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(LiquibaseApplication.class, args);
        log.info(
                "======================== started up successfully at {} {} ========================",
                LocalDate.now(),
                LocalTime.now()
        );
    }

}
