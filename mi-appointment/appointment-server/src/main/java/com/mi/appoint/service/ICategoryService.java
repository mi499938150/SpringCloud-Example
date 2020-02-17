package com.mi.appoint.service;

import com.mi.appoint.domain.AppointCategory;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
public interface ICategoryService {

    List<AppointCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}