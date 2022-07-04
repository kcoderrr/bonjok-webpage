package com.bonjok.food.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //JPA Auditing 활성화한다.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
