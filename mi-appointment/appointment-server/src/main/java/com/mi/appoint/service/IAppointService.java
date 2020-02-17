package com.mi.appoint.service;

import com.mi.appoint.domain.Appointment;
import com.mi.common.appoint.AppointInfoOutPut;

import java.util.List;
import java.util.Optional;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
public interface IAppointService {

    /**
     * 查询所有状态正常的预约列表
     * @return
     */
    List<Appointment> findUpAll();



}