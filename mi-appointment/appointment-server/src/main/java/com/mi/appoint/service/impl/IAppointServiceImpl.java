package com.mi.appoint.service.impl;

import com.mi.appoint.domain.Appointment;
import com.mi.appoint.enums.AppointStatusEnum;
import com.mi.appoint.repository.AppointmentRepository;
import com.mi.appoint.service.IAppointService;
import com.mi.common.appoint.AppointInfoOutPut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Service
public class IAppointServiceImpl implements IAppointService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findUpAll() {
        Appointment appointment = new Appointment();
        appointment.setAppointStatus(AppointStatusEnum.UP.getCode());
        Example<Appointment> example = Example.of(appointment);

        return appointmentRepository.findAll(example);
    }




    /**
     * 通过Id获取列表
     * @param appointId
     * @return
     */



}