//package com.mi.geteway.filter;
////
////import com.netflix.zuul.ZuulFilter;
////import com.netflix.zuul.context.RequestContext;
////import com.netflix.zuul.exception.ZuulException;
////import org.apache.commons.lang.StringUtils;
////import org.springframework.http.HttpStatus;
////import org.springframework.stereotype.Component;
////
////import javax.servlet.http.HttpServletRequest;
////
////import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
////import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
////
/////**
//// * @author : Rong
//// * @date : 2020/2/16
//// * @Desc:
//// */
////@Component
////public class TokenFilter extends ZuulFilter {
////
////
////    //PRE_TYPE 过滤
////
////    @Override
////    public String filterType() {
////        return PRE_TYPE;
////    }
////
////    @Override
////    public int filterOrder() {
////        return PRE_DECORATION_FILTER_ORDER -1;
////    }
////
////    @Override
////    public boolean shouldFilter() {
////        return true;
////    }
////
////    @Override
////    public Object run() throws ZuulException {
////
////        RequestContext requestContext = RequestContext.getCurrentContext();
////        HttpServletRequest request =  requestContext.getRequest();
////
////        //这里从url参数获取,也可以从cookies,header里获取
////        String token = request.getParameter("token");
////        if (StringUtils.isEmpty(token)){
////            requestContext.setSendZuulResponse(false);
////            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
////        }
////        return null;
////    }
////}