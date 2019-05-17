package com.tensquare.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import utils.IdWorker;

/**
 * 配置类
 */
@Configuration
public class MyConfig {

    @Bean
    public IdWorker getIdWorker() {
        return new IdWorker(1,1);
    }

}
