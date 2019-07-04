package com.tensquare.aritcle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import utils.IdWorker;

@Configuration
public class IdConfig {

    @Bean
    public IdWorker getIdWork() {
        return new IdWorker(1,1);
    }
}
