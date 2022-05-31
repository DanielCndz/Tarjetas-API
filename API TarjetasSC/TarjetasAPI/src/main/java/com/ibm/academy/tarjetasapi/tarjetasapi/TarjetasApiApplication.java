package com.ibm.academy.tarjetasapi.tarjetasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TarjetasApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarjetasApiApplication.class, args);
    }

}
