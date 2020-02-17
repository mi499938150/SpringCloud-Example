package com.mi.appoint.repository;

import com.mi.appoint.domain.AppointCategory;
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
public interface AppointmentCategoryRepository extends JpaRepository<AppointCategory,Integer>{

    List<AppointCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
