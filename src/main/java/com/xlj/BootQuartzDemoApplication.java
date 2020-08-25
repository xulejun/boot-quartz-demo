package com.xlj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启Quartz启动
@EnableScheduling
public class BootQuartzDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootQuartzDemoApplication.class, args);
    }

}
