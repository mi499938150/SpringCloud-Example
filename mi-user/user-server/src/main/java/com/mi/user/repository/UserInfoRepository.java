package com.mi.user.repository;

import com.mi.user.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Repository
public interface UserInfoRepository  extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);
}
