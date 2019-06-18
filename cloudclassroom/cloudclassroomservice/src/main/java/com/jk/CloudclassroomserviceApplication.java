package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.jk.mapper")
public class CloudclassroomserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudclassroomserviceApplication.class, args);
    }
}
