package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jiusen Guo
 * @date 2021/1/31 0:16
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
