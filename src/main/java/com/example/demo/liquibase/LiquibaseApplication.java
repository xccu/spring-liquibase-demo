package com.example.demo.liquibase;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;


@Slf4j
@SpringBootApplication(scanBasePackages = "com.example.demo.liquibase")
@MapperScan(basePackages = { "com.example.demo.liquibase.mapper","com.example.demo.liquibase.dao"})
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
