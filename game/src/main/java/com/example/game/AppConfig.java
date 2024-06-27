package com.example.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Game pacman() {
        return new Pacman();
    }

    @Bean
    public Game mario() {
        return new Mario();
    }

    @Bean
    public Game templeRun() {
        return new TempleRun();
    }



}
