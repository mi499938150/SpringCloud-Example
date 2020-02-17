package com.mi.user.service.impl;

import com.mi.user.domain.UserInfo;
import com.mi.user.repository.UserInfoRepository;
import com.mi.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */

@Service
public class IUserServiceImpl  implements IUserService{

    @Autowired
    private UserInfoRepository repository;

    /**
     * 通过openid来查询用户信息
     *
     * @param openid
     * @return
     */

    @Override
    public UserInfo findByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}