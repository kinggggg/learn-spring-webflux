package com.zeek.learnspringwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LearnSpringWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringWebfluxApplication.class, args);
    }

}
