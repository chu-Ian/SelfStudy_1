package com.tensquare.gathering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启redi缓存支持
public class GatheringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class, args);
    }
}
