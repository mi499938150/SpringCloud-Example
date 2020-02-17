package com.mi.user.controller;

import com.mi.common.vo.ResultVO;
import com.mi.user.client.AppointClient;
import com.mi.user.client.vo.AppointmentVo;
import com.mi.user.domain.Appointment;
import com.mi.user.vo.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc:
 */
// 用FeignClient调用 appoint 的服务

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private AppointClient appointClient;

    //访问地址为本服务地址  localhost:9001/mi-appoint/controller地址
    //访问网关地址 http://localhost:9000/gateway/mi-appoint/

    @GetMapping("/getAppointMsg")

    public String getAppointMsg(){
        String result  = appointClient.appointMsg();
        log.info("result = {}",result);
        return result;
    }

    @GetMapping("/getAppointUpList")
    public List<Appointment> getAppointUpList(){
        return appointClient.upList();
    }


}