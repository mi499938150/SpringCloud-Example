package com.mi.user.client;

import com.mi.common.vo.ResultVO;
import com.mi.user.client.vo.AppointmentVo;
import com.mi.user.domain.Appointment;
import com.mi.user.enums.ResultEnum;
import com.mi.user.vo.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc:
 */
@Service
@Slf4j
public class AppointClientHystrix implements AppointClient {
    @Override
    public String appointMsg() {
        return  "服务不可用";
    }

    @Override
    public List<Appointment> upList() {
        return null;
    }


}