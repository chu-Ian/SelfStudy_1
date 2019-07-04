package com.tensquare.spit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import utils.IdWorker;

@Configuration
public class SpitConfig {

    @Bean
    public IdWorker getWorkId() {
        return new IdWorker(1, 1);
    }

}
