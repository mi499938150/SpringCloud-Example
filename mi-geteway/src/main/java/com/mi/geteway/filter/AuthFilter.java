package com.mi.geteway.filter;

import com.mi.common.utils.CookieUtil;
import com.mi.geteway.constant.RedisConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc:
 */

//权限校验
@Component
@Slf4j
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request =  requestContext.getRequest();

        /**
         * /mi-appoint/index (cookie里有openid)
         * /mi-appoint/query (cookie里有token，并且对应的redis中值)
         * /product/list 都可访问
         */
        if ("/gateway/mi-appoint/index".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request,"openid");
            log.info("[ ======获取openid ======   result = {}]",cookie);
            if (cookie ==null || StringUtils.isEmpty(cookie.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        if ("/gateway/mi-appoint/query".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request,"token");
            log.info("[ ======获取token ======   result = {}]",cookie);
            if (cookie == null
                    || StringUtils.isEmpty(cookie.getValue())
                    || StringUtils.isEmpty(stringRedisTemplate.opsForValue()
                    .get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        return null;
    }

}