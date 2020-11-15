package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author tianlg
 */
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class LeetCodeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetCodeDemoApplication.class, args);
    }

}
