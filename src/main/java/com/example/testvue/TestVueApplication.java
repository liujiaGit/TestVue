package com.example.testvue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.testvue.mapper")
public class TestVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestVueApplication.class, args);
    }

}
