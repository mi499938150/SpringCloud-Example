package com.mi.geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

        public static void main(String args[]){
            SpringApplication.run(ZuulGatewayApplication.class,args);
        }
    }
