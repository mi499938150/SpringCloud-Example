package com.mi.appoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppointApplication {
    public static void main(String args[]){
        SpringApplication.run(AppointApplication.class, args);
    }

}