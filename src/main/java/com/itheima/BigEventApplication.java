package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class BigEventApplication {
    public static void main(String[] args) {
        // 启动Spring
        SpringApplication.run(BigEventApplication.class, args);
        System.out.println("Hello World!");
    }
}
