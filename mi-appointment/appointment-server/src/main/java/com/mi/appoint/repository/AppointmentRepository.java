package com.mi.appoint.repository;

import com.mi.appoint.Vo.AppointmentInfoVo;
import com.mi.appoint.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String>{

//    List<Appointment> findByAppointment(Integer appointStatus);


}
