package com.mi.user.controller;

import com.mi.common.vo.ResultVO;
import com.mi.user.client.vo.AppointmentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc:
 * @LoadBalanced
 * 开启负载均衡
 * 实现轮询
 */

@RestController
@Slf4j
public class LoadBanlancedController {


    @Autowired
    private RestTemplate restTemplate;


    /**
     *  使用 ribbon 访问  + 网关
     *  localhost:9000/gateway/mi-user/getAppointByRibbon
     * @return
     */
    @GetMapping("/getAppointByRibbon")
    public ResultVO<AppointmentVo> getAppointByList(){
        log.info("mi-user:getAppointByList - > ");

        return restTemplate.getForObject(
                "http://appoint/mi-appoint/appoint/list",
                ResultVO.class
        );
    }
}