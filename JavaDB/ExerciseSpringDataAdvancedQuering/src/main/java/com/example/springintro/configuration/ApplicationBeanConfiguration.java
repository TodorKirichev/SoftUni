package com.example.springintro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }
}
