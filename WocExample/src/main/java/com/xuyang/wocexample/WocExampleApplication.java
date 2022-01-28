package com.xuyang.wocexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot项目启动
@SpringBootApplication(scanBasePackages = "com.xuyang.wocexample")
public class WocExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WocExampleApplication.class, args);
    }

}
