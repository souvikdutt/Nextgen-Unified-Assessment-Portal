package com.epam.ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;


@EnableEurekaClient
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:3000")
public class UaGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaGatewayServiceApplication.class, args);
    }

}
