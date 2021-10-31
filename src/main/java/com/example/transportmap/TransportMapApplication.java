package com.example.transportmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan("com.example.transportmap")
@SpringBootApplication
public class TransportMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportMapApplication.class, args);
    }

}
