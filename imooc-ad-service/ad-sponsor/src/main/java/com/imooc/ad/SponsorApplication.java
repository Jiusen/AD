package com.imooc.ad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Jiusen Guo
 * @date 2021/2/1 16:34
 * 主启动
 */
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.imooc.ad.dao")
public class SponsorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
    }
}
