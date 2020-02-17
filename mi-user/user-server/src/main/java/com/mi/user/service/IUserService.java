package com.mi.user.service;

import com.mi.user.domain.UserInfo;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
public interface IUserService {
    /**
     * 通过openid来查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
