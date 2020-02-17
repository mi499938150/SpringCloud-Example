package com.mi.user.controller;

import com.mi.common.utils.CookieUtil;
import com.mi.common.vo.ResultVO;
import com.mi.user.constant.CookieConstant;
import com.mi.user.constant.RedisConstant;
import com.mi.user.domain.UserInfo;
import com.mi.user.enums.ResultEnum;
import com.mi.user.enums.RoleEnum;
import com.mi.user.service.IUserService;
import com.mi.user.vo.ResultVOUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
//访问地址为本服务地址  localhost:9001/mi-user/controller地址
//访问网关地址 http://localhost:9000/gateway/mi-user/
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/index")
    public ResultVO buyer(@RequestParam("openid") String openid,
                          HttpServletResponse response) {
        //1. openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        //2. 判断角色
        if (!RoleEnum.INDEX.getCode().equals( userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //3. cookie里设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.expire);

        return ResultVOUtil.success();
    }


    @GetMapping("/query")
    public ResultVO seller(@RequestParam("openid") String openid,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        //判断是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }

        //1. openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        //2. 判断角色
        if (!RoleEnum.QUERY.getCode().equals( userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //3. redis设置key=UUID, value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS);

        //4. cookie里设置token=UUID
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);

        return ResultVOUtil.success();
    }

    @GetMapping("user")
    public ResultVO LoginTo(){

        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        userInfo.setOpenid("1234567");
        userInfo.setPassword("123456");
        return ResultVOUtil.success(userInfo);
    }
}