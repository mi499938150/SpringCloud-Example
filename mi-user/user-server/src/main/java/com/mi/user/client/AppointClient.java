package com.mi.user.client;

import com.mi.common.vo.ResultVO;
import com.mi.user.client.vo.AppointmentVo;
import com.mi.user.domain.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc: 使用注解FeginClient接口调用微服务
 */
//@FeignClient(value = "application:
//                               name      ->appoint
//
// ")
//当服务不可用的时候，返回AppointClientHystrix.class
@FeignClient(value = "appoint"
        , fallback = AppointClientHystrix.class
)
public interface AppointClient {


    // 调用 Appoint 服务
    // 声明接口式地址 @GetMapping("/mi-appoint/msg"）
    // 在到本服务 Controller 调用 方法
    // 访问地址为本服务地址  localhost:9001/mi-appoint/controller地址

    @GetMapping("/mi-appoint/msg")
    public String appointMsg();

    @GetMapping("/mi-appoint/appoint/uplist")
    List<Appointment> upList();

}