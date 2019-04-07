package com.example.vaultest;

import com.example.vaultest.configuration.MyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(MyConfiguration.class)
public class VaulTestApplication {

    private final MyConfiguration configuration;

    public VaulTestApplication(MyConfiguration configuration) {
        this.configuration = configuration;
    }
    
    
    public static void main(String[] args) {
            SpringApplication.run(VaulTestApplication.class, args);
    }
    
    
    
    
    @Bean
        CommandLineRunner runner(){
            
        return args -> {
            Logger logger = LoggerFactory.getLogger(VaulTestApplication.class);

            logger.info("----------------------------------------");
            logger.info("Configuration properties");
            logger.info("        spring.datasource.username is {}", this.configuration.getUsername());
            logger.info("        spring.datasource.password is {}", this.configuration.getPassword());
            logger.info("----------------------------------------");
            
        };
            
    }
    
    
    
    
    

}
