package com.tocker.systemmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableF
@SpringBootApplication
public class SystemManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemManagerApplication.class, args);
    }

}
