package com.demo.crm.config;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.crm.jwt.JwtException;
import com.demo.crm.jwt.JwtUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 从http请求头中取出 token
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            throw new JwtException();
        }
        // 解析 jwt 串
        try {
            DecodedJWT decodedJWT = JwtUtils.verifyToken(token);// 可能时间过期
            request.setAttribute("userId", decodedJWT.getClaim("userid").asInt());
            request.setAttribute("username", decodedJWT.getClaim("username").asString());
        } catch (Exception e) {
            throw new JwtException();
        }
        return true;
    }
}
