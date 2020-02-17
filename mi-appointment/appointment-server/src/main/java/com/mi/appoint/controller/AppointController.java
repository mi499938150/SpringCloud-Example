package com.mi.appoint.controller;

import com.mi.appoint.Vo.AppointmentInfoVo;
import com.mi.appoint.Vo.AppointmentVo;
import com.mi.appoint.Vo.ResultVOUtil;
import com.mi.appoint.domain.AppointCategory;
import com.mi.appoint.domain.Appointment;
import com.mi.appoint.service.IAppointService;
import com.mi.appoint.service.ICategoryService;
import com.mi.common.appoint.AppointInfoOutPut;
import com.mi.common.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@RestController
@RequestMapping("/appoint")
//访问地址为本服务地址  localhost:9002/mi-appoint/controller地址
//访问网关地址 http://localhost:9000/gateway/mi-appoint/
public class AppointController {

    @Autowired
    private IAppointService appointService;

    @Autowired
    private ICategoryService categoryService;

    /**
     * 获取所有数据
     */

    @GetMapping("list")

    public ResultVO<AppointmentVo> list(){

        // 1. 查询所有预约时间
        List<Appointment> appointments = appointService.findUpAll();
        // 2.查询类目(一次性查询)
        //Java lamba
        List<Integer> categoryTypeListIn = appointments.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        // 2. 查询类目
        List<AppointCategory> appointCategoryList =
                categoryService.findByCategoryTypeIn(categoryTypeListIn);
        // 3. 数据拼装
        List<AppointmentVo> appointmentVoList = new ArrayList<>();
        for (AppointCategory appointCategory : appointCategoryList){
            AppointmentVo appointmentVo = new AppointmentVo();
            // 4. 添加分欸数据
            appointmentVo.setCategoryName(appointCategory.getCategoryName());
            appointmentVo.setCategoryType(appointCategory.getCategoryType());
            // 5. 添加预约数据
            List<AppointmentInfoVo> appointmentInfoVoList = new ArrayList<>();
            for (Appointment appointment : appointments){
                if (appointment.getCategoryType()
                        .equals(appointCategory.getCategoryType())){
                    AppointmentInfoVo appointmenInfo = new AppointmentInfoVo();
                    BeanUtils.copyProperties(appointment,appointmenInfo);
                    appointmentInfoVoList.add(appointmenInfo);
                }
            }
            appointmentVo.setAppointmentInfoVoList(appointmentInfoVoList);
            appointmentVoList.add(appointmentVo);
        }
        return ResultVOUtil.success(appointmentVoList);
    }

    /**
     * 获取列表
     * @return
     */
   @GetMapping("uplist")
    public List<Appointment>  upList(){
        return appointService.findUpAll();
   }




   // 测试 服务降级
    @GetMapping("appointList")
    public ResultVO<AppointmentVo> AppointList(){


        // 1. 查询所有预约时间
        List<Appointment> appointments = appointService.findUpAll();
        // 2.查询类目(一次性查询)
        //Java lamba
        List<Integer> categoryTypeListIn = appointments.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        // 2. 查询类目
        List<AppointCategory> appointCategoryList =
                categoryService.findByCategoryTypeIn(categoryTypeListIn);
        // 3. 数据拼装
        List<AppointmentVo> appointmentVoList = new ArrayList<>();
        for (AppointCategory appointCategory : appointCategoryList){
            AppointmentVo appointmentVo = new AppointmentVo();
            // 4. 添加分欸数据
            appointmentVo.setCategoryName(appointCategory.getCategoryName());
            appointmentVo.setCategoryType(appointCategory.getCategoryType());
            // 5. 添加预约数据
            List<AppointmentInfoVo> appointmentInfoVoList = new ArrayList<>();
            for (Appointment appointment : appointments){
                if (appointment.getCategoryType()
                        .equals(appointCategory.getCategoryType())){
                    AppointmentInfoVo appointmenInfo = new AppointmentInfoVo();
                    BeanUtils.copyProperties(appointment,appointmenInfo);
                    appointmentInfoVoList.add(appointmenInfo);
                }
            }
            appointmentVo.setAppointmentInfoVoList(appointmentInfoVoList);
            appointmentVoList.add(appointmentVo);
        }
        // 设置时间超时
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResultVOUtil.success(appointmentVoList);
    }


}