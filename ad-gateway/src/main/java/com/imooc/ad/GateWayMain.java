package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jiusen Guo
 * @date 2021/1/31 2:38
 */

@SpringBootApplication
@EnableEurekaClient
public class GateWayMain
{
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain.class,args);
    }
}
