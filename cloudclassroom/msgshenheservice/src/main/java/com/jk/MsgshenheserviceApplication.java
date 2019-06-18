package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.jk.mapper")
@EnableTransactionManagement
@EnableScheduling
public class MsgshenheserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgshenheserviceApplication.class, args);
    }

}
