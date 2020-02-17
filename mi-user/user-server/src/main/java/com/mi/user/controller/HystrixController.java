package com.mi.user.controller;

import com.mi.common.vo.ResultVO;
import com.mi.user.client.vo.AppointmentVo;
import com.mi.user.domain.Appointment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author : Rong
 * @date : 2020/2/17
 * @Desc:  Hystrix 触发降级
 */
// 本地地址 localhost:9001/mi-user/getAppointInfoList
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {




    //设置降级配置
    // 超时时间3秒
    @HystrixCommand(
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),  //超时时间
         //    断熔器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  				//设置熔断
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),	//请求数达到后才计算
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),	//错误率
    }
    )
    @GetMapping("getAppointInfoList")
    public String getAppointByList(@RequestParam("number") Integer number){
        if (number % 2 == 0) {
            return "success";
        }
        log.info("mi-user:getAppointByList - > ");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "http://127.0.0.1:9002/mi-appoint/appoint/appointList",
                String.class
        );
    }

    @RequestMapping("test")
    public String test(){
        return "test";
    }


    private String fallback() {
        return "太拥挤了, 请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认提示：太拥挤了, 请稍后再试~~";
    }
}

