package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com")
@EnableTransactionManagement
public class ResourceManagementPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceManagementPlatformApplication.class, args);
    }
}