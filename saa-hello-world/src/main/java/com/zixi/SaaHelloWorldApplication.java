package com.zixi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
public class SaaHelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaaHelloWorldApplication.class, args);
        System.out.println("+----------------------------------------------------+ ");
        System.out.println("启动状态：启动成功");
        System.out.println("+----------------------------------------------------+ ");
    }
}