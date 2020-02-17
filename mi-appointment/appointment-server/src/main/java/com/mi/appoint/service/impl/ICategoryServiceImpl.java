package com.mi.appoint.service.impl;

import com.mi.appoint.domain.AppointCategory;
import com.mi.appoint.repository.AppointmentCategoryRepository;
import com.mi.appoint.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Slf4j
@Service
public class ICategoryServiceImpl implements ICategoryService {

    @Autowired
    private AppointmentCategoryRepository categoryRepository;

    @Override
    public List<AppointCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}